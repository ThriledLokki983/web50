const mongoose = require('mongoose');
const Tour = require('./tourModel');

/**
 * Model for Reviews
 * It contains references to the Tour and which to the User who will make that review
 */

const reviewSchema = new mongoose.Schema(
  {
    review: {
      type: String,
      required: [true, 'Review cannot be empty!'],
    },
    rating: {
      type: Number,
      min: 1,
      max: 5,
    },
    createdAt: {
      type: Date,
      default: Date.now(),
    },
    /**
     * Reference to the Tour
     */
    tour: {
      type: mongoose.Schema.Types.ObjectId,
      ref: 'Tour',
      required: [true, 'review must belong to a tour'],
    },

    /**
     * Reference to the User
     */
    user: {
      type: mongoose.Schema.Types.ObjectId,
      ref: 'User',
      required: [true, 'A review must belong to a user'],
    },
  },
  /**
   * these properties are not part of the DB
   * Whenever there is a calculated value which is not part of the db, it will still show bcos of this virtuals
   */
  {
    toJSON: { virtuals: true },
    toObject: { virtuals: true },
  }
);

/**
 * A Middleware to populate our query will all the guides correct info using the _ids in the guides[]
 * Using populate() with Promises will need executePopulate() in order to work
 */
reviewSchema.pre(/^find/, function (next) {
  this.populate({
    path: 'user',
    select: 'name photo',
  });

  next();
});

/**
 * Perform Aggregate on the Model
 * @param {Object} tourId | This is the tour we want want to do the calculation on
 * Afterwards, we will have to persist the data on the Tour DB
 */
reviewSchema.statics.calcAverageRating = async function (tourId) {
  const stats = await this.aggregate([
    {
      $match: { tour: tourId },
    },
    {
      $group: {
        _id: '$tour',
        nRating: { $sum: 1 },
        avgRating: { $avg: '$rating' },
      },
    },
  ]);

  await Tour.findByIdAndUpdate(tourId, {
    ratingsQuantity: stats[0].nRating,
    ratingAverage: stats[0].avgRating,
  });
};

/**
 * THIS points to the current document
 */
reviewSchema.post('save', function () {
  this.constructor.calcAverageRating(this.tour);
});

/**
 * Create the Model from the Review Schema
 * Export the Model in order to be able to be used
 */
const Review = mongoose.model('Review', reviewSchema);
module.exports = Review;
