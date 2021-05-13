const User = require('./../model/userModel');
const catchAsync = require('./../utils/catchAsync');
const jwt = require('jsonwebtoken');
const AppError = require('./../utils/appError');

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

  const token = jwt.sign({ id: newUser._id }, process.env.JWT_SECRET, {
    expiresIn: process.env.JWT_EXPIRES_IN,
  });

  res.status(201).json({
    status: 'success',
    token,
    data: {
      user: newUser,
    },
  });
});

/**
 * Check if email and password exist, if user && password is correct, if everything is ok, send token to client
 * Login user
 */
exports.login = (req, res, next) => {
  const { email, password } = req.body;

  if (!email || !password) {
    return next(new AppError('Please provide an email and password', 400));
  }

  const user = User.findOne({ email: email });

  const token = '';

  res.status(200).json({
    status: 'success',
    token,
  });
};
