/**
 * Views Controller || Takes care of the main functionality of how the views should work
 */
const Tour = require('../model/tourModel');
const catchAsync = require('../utils/catchAsync');
const AppError = require('./../utils/appError');
const User = require('../model/userModel');

/**
 * Get all the tour data from collection and pass it into the template || Build template || Render the template using the tour data
 * @param {*} req
 * @param {*} res
 */
exports.getOverview = catchAsync(async (req, res, next) => {
  const tours = await Tour.find();

  res.status(200).render('overview', {
    title: 'All tours',
    tours,
  });
});

/**
 * Get all the tour data from collection and pass it into the template || Build template || Render the template using the tour data
 * @param {*} req
 * @param {*} res
 */
exports.getTour = catchAsync(async (req, res, next) => {
  const tour = await Tour.findOne({ slug: req.params.slug }).populate({
    path: 'reviews',
    fields: 'review rating user',
  });

  if (!tour) {
    return next(new AppError(`There is  no tour call: ${req.params.slug}.`, 404));
  }

  res
    .status(200)
    .set(
      'Content-Security-Policy',
      "default-src 'self' https://*.mapbox.com https://api.stripe.com ;base-uri 'self';block-all-mixed-content;font-src 'self' https: data:;frame-ancestors 'self';img-src 'self' data:;object-src 'none';script-src https://cdnjs.cloudflare.com https://api.mapbox.com https://js.stripe.com/v3/ 'self' blob:;  frame-src  https://js.stripe.com https://hooks.stripe.com; connect-src 'self' https: data:;script-src-attr 'none';style-src 'self' https: 'unsafe-inline';upgrade-insecure-requests"
    )
    .render('tour', {
      title: `${tour.name} Tour`,
      tour,
    });
});

/**
 * Login form
 * @param {*} req
 * @param {*} res
 */
exports.getLogin = (req, res) => {
  res.status(200).render('login', {
    tile: 'Log into your account',
  });
};

/**
 * Get user account information
 * @param {*} req
 * @param {*} res
 */
exports.getAccount = (req, res) => {
  res.status(200).render('account', {
    tile: 'Your account',
  });
};

exports.updateUserData = catchAsync(async (req, res, next) => {
  const updatedUser = await User.findByIdAndUpdate(
    req.user.id,
    {
      name: req.body.name,
      email: req.body.email,
    },
    {
      new: true,
      runValidators: true,
    }
  );

  res.status(200).render('account', {
    tile: 'Your account',
    user: updatedUser,
  });
});
