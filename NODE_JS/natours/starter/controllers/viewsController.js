/**
 * Views Controller || Takes care of the main functionality of how the views should work
 */
const Tour = require('../model/tourModel');
const catchAsync = require('../utils/catchAsync');
const AppError = require('./../utils/appError');
const User = require('../model/userModel');
const Booking = require('../model/bookingModel');

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
      "default-src 'self' https://*.mapbox.com https://js.stripe.com/v3/; base-uri 'self';block-all-mixed-content;font-src 'self' https: data:;frame-ancestors 'self';img-src 'self' data:;object-src 'none';script-src 'self' https://api.mapbox.com/mapbox-gl-js/v2.1.1/mapbox-gl.js https://js.stripe.com/v3/; script-src-attr 'none';style-src 'self' https: 'unsafe-inline'; connect-src *; worker-src 'self' blob:; upgrade-insecure-requests"
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

/**
 * Find bookings, Tours with the returned IDs
 * @param {*} req
 * @param {*} res
 * @param {*} next
 */
exports.getMyTours = catchAsync(async (req, res, next) => {
  const bookings = await Booking.find({ user: req.user.id });

  const tourIDs = bookings.map((el) => el.tour);
  const tours = await Tour.find({ _id: { $in: tourIDs } });

  res.status(200).render('overview', {
    title: 'My Tours',
    tours,
  });
});
