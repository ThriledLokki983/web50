const express = require('express');
const authController = require('./../controllers/authController');
const reviewController = require('./../controllers/reviewController');

/**
 * Creates the router variable to be used from express
 * MergeParams allows our router to access parameters from other routers //
 * Preserve the req.params values from the parent router.
 */
const router = express.Router({ mergeParams: true });

/**
 * If you don't login, you cannot get access to any of the routes below
 */
router.use(authController.protect);

/**
 * User should be able to login first before creating a review
 * Route to get all the reviews
 * Route to create a review for a tour
 */
router
  .route('/')
  .get(reviewController.getAllReviews)
  .post(
    authController.protect,
    authController.restrictTo('user'),
    reviewController.setTourUserIds,
    reviewController.createReview
  );

/**
 * Update Route
 * Delete Route
 */
router
  .route('/:id')
  .get(reviewController.getReview)
  .patch(authController.restrictTo('user', 'admin'), reviewController.updateReview)
  .delete(authController.restrictTo('user', 'admin'), reviewController.deleteReview);

/**
 * Exports the router if not we cannot use it app.js
 */

module.exports = router;
