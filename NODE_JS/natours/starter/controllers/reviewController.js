const Review = require('./../model/reviewModel');
const catchAsync = require('./../utils/catchAsync');

/**
 * Controller that will help create a review
 * using the req.body prevents anything not defined in our schema to be ignored
 */
exports.createReview = catchAsync(async (req, res, next) => {
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
