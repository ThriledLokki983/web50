const { request } = require('../app');
const Review = require('./../model/reviewModel');
const catchAsync = require('./../utils/catchAsync');
const factory = require('./handlerFactory');

/**
 * Allowing nested routes
 * Controller that will help create a review
 * using the req.body prevents anything not defined in our schema to be ignored
 * @param {*} req
 * @param {*} res
 * @param {*} next
 */
exports.setTourUserIds = (req, res, next) => {
  if (!req.body.tour) req.body.tour = req.params.tourId;
  if (!req.body.user) req.body.user = req.user.id;
  next();
};

/**
 * Creates User Document || This will use the setTourUserIds() middleware
 * Update User Document using ID || This does not update passwords
 * Delete User Document using ID
 * Query for a single Review
 * Query for all Reviews
 */
exports.deleteReview = factory.deleteOne(Review);
exports.updateReview = factory.updateOne(Review);
exports.createReview = factory.createOne(Review);
exports.getReview = factory.getOne(Review);
exports.getAllReviews = factory.getAll(Review);
