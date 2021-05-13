const { promisify } = require('util');
const User = require('./../model/userModel');
const catchAsync = require('./../utils/catchAsync');
const jwt = require('jsonwebtoken');
const AppError = require('./../utils/appError');

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
 * Create a Web.Token with the JWT library and send to the client
 * Login user right after signup
 */
exports.signup = catchAsync(async (req, res, next) => {
  const { name, email, password, passwordConfirm } = req.body;
  const newUser = await User.create({
    name: name,
    email: email,
    password: password,
    passwordConfirm: passwordConfirm,
  });

  const token = signToken(newUser._id);

  res.status(201).json({
    status: 'success',
    token,
    data: {
      user: newUser,
    },
  });
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

  const token = signToken(user._id);

  res.status(200).json({
    status: 'success',
    token,
  });
});

/**
 * Middleware to make sure that users are authenticated before viewing tours
 * Get the token and check if it exist, verify token, check if user still exists,Check if user changed password after token was issued, then next()
 */
exports.protect = catchAsync(async (req, res, next) => {
  let token;

  if (req.headers.authorization && req.headers.authorization.startsWith('Bearer')) {
    token = req.headers.authorization.split(' ')[1];
  }

  if (!token) {
    return next(new AppError('You are not logged in!. Please login to get access', 401));
  }

  const decodedPayload = await promisify(jwt.verify)(token, process.env.JWT_SECRET);

  const freshUser = await User.findById(decodedPayload.id);
  if (!freshUser) {
    return next(new AppError('The user associated to this token does not exist.', 401));
  }

  freshUser.changePasswordAfter(decodedPayload.iat);

  next();
});
