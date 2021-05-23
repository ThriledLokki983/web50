const express = require('express');
const authController = require('./../controllers/authController');
const bookingController = require('./../controllers/bookingController');

/**
 * Create the router to be used
 */
const router = express.Router();

router.get(
  '/checkout-session/:tourId',
  authController.protect,
  bookingController.getCheckoutSession
);

/**
 * Exports the router if not we cannot use it app.js
 */

module.exports = router;
