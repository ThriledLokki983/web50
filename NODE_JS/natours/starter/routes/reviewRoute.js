const express = require('express');
const authController = require('./../controllers/authController');
const reviewController = require('./../controllers/reviewController');

/**
 * Creates the router variable to be used from express
 */
const router = express.Router();

/**
 * User should be able to login first before creating a review
 * Route to get all the reviews
 * Route to create a review for a tour
 */
router
  .route('/')
  .get(authController.protect, reviewController.getAllReviews)
  .post(reviewController.createReview);

/**
 * Exports the router if not we cannot use it app.js
 */

module.exports = router;
