const { request } = require('../app');
const Review = require('./../model/reviewModel');
const catchAsync = require('./../utils/catchAsync');

/**
 * Allowing nested routes
 * Controller that will help create a review
 * using the req.body prevents anything not defined in our schema to be ignored
 */
exports.createReview = catchAsync(async (req, res, next) => {
  if (!req.body.tour) req.body.tour = req.params.tourId;
  if (!req.body.user) req.body.user = req.user.id;

  const newReview = await Review.create(req.body);

  res.status(201).json({
    status: 'success',
    data: {
      review: newReview,
    },
  });
});

/**
 * Retrieving all the reviews from the DB
 */
exports.getAllReviews = catchAsync(async (req, res, next) => {
  const reviews = await Review.find();

  res.status(200).json({
    status: 'success',
    results: reviews.length,
    data: {
      review: reviews,
    },
  });
});
