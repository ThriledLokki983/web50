const crypto = require('crypto');
const { promisify } = require('util');
const User = require('./../model/userModel');
const catchAsync = require('./../utils/catchAsync');
const jwt = require('jsonwebtoken');
const AppError = require('./../utils/appError');
const sendEmail = require('./../utils/email');

/**
 *
 * @param {any} id
 * @returns {jwt token} Token which will be added to every user for authentication
 */
const signToken = (id) => {
  return jwt.sign({ id }, process.env.JWT_SECRET, {
    expiresIn: process.env.JWT_EXPIRES_IN,
  });
};

/**
 * Refactor
 * @param {Object|} user The user we need to modify its data
 * @param {Number} statusCode Status code to be used e.g. 401, 200 etc
 * @param {Object} res Response to be sent to the client
 */
const createAndSendToken = (user, statusCode, res) => {
  const token = signToken(user._id);

  res.status(statusCode).json({
    status: 'success',
    token,
    data: {
      user: user,
    },
  });
};

/**
 * Create a Web.Token with the JWT library and send to the client
 * Login user right after signup
 */
exports.signup = catchAsync(async (req, res, next) => {
  const { name, email, password, passwordConfirm, passwordChangedAt } = req.body;
  const newUser = await User.create({
    name: name,
    email: email,
    password: password,
    passwordConfirm: passwordConfirm,
    passwordChangedAt: passwordChangedAt,
  });

  createAndSendToken(newUser, 201, res);
});

/**
 *  wrapped in catchAsync() to avoid ugly try/catch function everywhere
 * Check if email and password exist, if user && password is correct, if everything is ok, send token to client
 * The password is not part of the results from our query so we use the select() to include it
 * Use the instance method from User to check if password is correct
 * Login user
 */
exports.login = catchAsync(async (req, res, next) => {
  const { email, password } = req.body;

  if (!email || !password) {
    return next(new AppError('Please provide an email and password', 400));
  }

  const user = await User.findOne({ email: email }).select('+password');

  if (!user || !(await user.correctPassword(password, user.password))) {
    return next(new AppError('Incorrect email or password', 401));
  }

  createAndSendToken(user, 200, res);
});

/**
 * Middleware to make sure that users are authenticated before viewing tours
 * Get the token and check if it exist, verify token, check if user still exists,Check if user changed password after token was issued, then next()
 * Get the current user check is a password change has happen or not and then finally grant access to the protected rout (route handler itself)
 */
exports.protect = catchAsync(async (req, res, next) => {
  let token;

  if (req.headers.authorization && req.headers.authorization.startsWith('Bearer')) {
    token = req.headers.authorization.split(' ')[1];
  }

  if (!token) {
    return next(new AppError('You are not logged in!. Please login to get access', 401));
  }

  const decode = await promisify(jwt.verify)(token, process.env.JWT_SECRET);

  const currentUser = await User.findById(decode.id);
  if (!currentUser) {
    return next(new AppError('The user associated to this token does not exist.', 401));
  }

  if (currentUser.changePasswordAfter(decode.iat)) {
    return next(
      new AppError(
        'User recently changed password, please check password and login again',
        401
      )
    );
  }

  req.user = currentUser;
  next();
});

/**
 *
 * @param  {Array |..any} ['admin', 'lead-guide']
 * @returns {Function} Func checks if current user have the correct/right role/permission to perform the action
 * If role is correct, we continue to perform the action, if not, return an error
 */
exports.restrictTo = (...roles) => {
  return (req, res, next) => {
    if (!roles.includes(req.user.role)) {
      return next(new AppError('You do not have permission to perform this action', 403));
    }
    next();
  };
};

/**
 * Get User based on the posted email, Generate random reset token and sent it to user's email
 * @param {*} req
 * @param {*} res
 * @param {*} next
 */
exports.forgotPassword = catchAsync(async (req, res, next) => {
  const user = await User.findOne({ email: req.body.email });

  if (!user) {
    return next(new AppError(`There is no user with this email address`, 404));
  }

  const resetToken = user.createPasswordResetToken();
  await user.save({ validateBeforeSave: false });

  const resetURL = `${req.protocol}://${req.get(
    'host'
  )}/api/users/resetPassword/${resetToken}`;

  const message = `Forgot a password: Submit a PATCH request with your new password and passwordConfirm to: ${resetURL}.\nIf you did not forget your password, please ignore this email`;

  try {
    await sendEmail({
      email: user.email,
      subject: 'Your Password Reset Token (valid for 10mins)',
      message,
    });

    res.status(200).json({
      status: 'success',
      message: 'Token sent to email',
    });
  } catch (err) {
    console.log(err);
    // user.passwordResetToken = undefined;
    // user.passwordResetExpires = undefined;
    // await user.save({ validateBeforeSave: false });

    // return next(
    //   new AppError('There was an error sending the email, please try again later', 500)
    // );
  }
});

/**
 * Get user based on the token, only if the token has not expired
 * Set the new password and Update the changedPasswordAt property for the user
 * Check if the password-expires is > date.now()
 * Log the user in
 * @param {*} req
 * @param {*} res
 * @param {*} next
 */
exports.resetPassword = catchAsync(async (req, res, next) => {
  const hashedToken = crypto.createHash('sha256').update(req.params.token).digest('hex');

  const user = await User.findOne({
    passwordResetToken: hashedToken,
    passwordResetExpires: { $gt: Date.now() },
  });

  if (!user) return next(new AppError('Token is invalid or has expired', 400));

  user.password = req.body.password;
  user.passwordConfirm = req.body.passwordConfirm;
  user.passwordResetToken = undefined;
  user.passwordResetExpires = undefined;

  await user.save();

  createAndSendToken(user, 200, res);
});

/**
 * For loggedin users to update/edit their password
 * First Get the user form our user collection, check if POSTED password is correct, if yes, then UPDATE password, Log user in send JWT
 * using User.findByIdAndUpdate() will not work // pre - save() middleware && password validator won't work
 * @param {*} req
 * @param {*} res
 * @param {*} next
 */
exports.updatePassword = catchAsync(async (req, res, next) => {
  const user = await User.findById(req.user.id).select('+password');

  if (!(await user.correctPassword(req.body.passwordCurrent, user.password))) {
    return next(new AppError('Your current password is wrong', 401));
  }

  user.password = req.body.password;
  user.passwordConfirm = req.body.passwordConfirm;
  await user.save();

  next();
});
