const mongoose = require('mongoose');
const slugify = require('slugify');

// Mongoose - MODEL for crud
const tourSchema = new mongoose.Schema(
  {
    name: {
      type: String,
      required: [true, 'A tour must have a Name'], // validator
      unique: true,
      trim: true,
      maxlength: [40, 'A tour name can have only 40 characters'],
      minlength: [10, 'A tour name must have at least 10 characters'],
      // validate: [validator.isAlpha, 'Tour name must only contain characters'],
    },
    slug: String,
    duration: {
      type: Number,
      required: [true, 'A tour must have a duration'],
    },
    maxGroupSize: {
      type: Number,
      required: [true, 'A tour must have a group size'],
    },
    difficulty: {
      type: String,
      required: [true, 'A tour must have a difficulty'],
      enum: {
        values: ['easy', 'medium', 'difficult'],
        message: 'Difficulty is either easy/medium/difficult',
      },
    },
    ratingAverage: {
      type: Number,
      default: 4.5,
      min: [1, 'Rating must be at least 1.0'], // works for dates too
      max: [5, 'Rating must be at most 5.0'],
      set: (val) => Math.round(val * 10) / 10,
    },
    ratingsQuantity: {
      type: Number,
      default: 0,
    },
    price: {
      type: Number,
      required: [true, 'A tour must have a Price'],
    },
    priceDiscount: {
      type: Number,
      validate: {
        validator: function (val) {
          // this only points to the current doc on NEW document creation
          return val < this.price;
        },
        message: 'Discount price ({VALUE}) should be below the regular price',
      },
    },
    summary: {
      type: String,
      trim: true,
      required: [true, 'A tour must have a Summary'],
    },
    description: {
      type: String,
      trim: true,
    },
    imageCover: {
      type: String,
      required: [true, 'A tour must have a cover Image'],
    },
    images: [String],
    createdAt: {
      type: Date,
      default: Date.now(),
      select: false,
    },
    startDates: [Date],
    secretTour: {
      type: Boolean,
      default: false,
    },
    startLocation: {
      // GeoJSON - This is an embedded object
      type: {
        type: String,
        default: 'Point',
        enum: ['Point'],
      },
      coordinates: [Number],
      address: String,
      description: String,
    },
    /**
     * An array of objects to create new documents inside the Parent document
     */
    locations: [
      {
        type: {
          type: String,
          default: 'Point',
          enum: ['Point'],
        },
        Coordinates: [Number],
        address: String,
        description: String,
        day: Number,
      },
    ],
    // guides: Array, for embedding the object during save

    /**
     * Creating a reference to the User model for the populate() mongoose method to work effectively
     */
    guides: [
      {
        type: mongoose.Schema.Types.ObjectId,
        ref: 'User',
      },
    ],
  },
  {
    toJSON: { virtuals: true }, // these properties are not part of the DB
    toObject: { virtuals: true },
  }
);

/**
 * Creating an Index
 * Negative: Sort in Descending order
 * Positive: Sort in Ascending order
 * Compound Index (2 - variables)
 */
tourSchema.index({ price: 1, ratingAverage: -1 });
tourSchema.index({ slug: 1 });
tourSchema.index({ startLocation: '2dsphere' });

tourSchema.virtual('durationWeeks').get(function () {
  return (this.duration / 7).toFixed(2);
});

/**
 * VIRTUAL POPULATE
 * This is to avoid child referencing of the reviews on the parent element/document which is the Tour
 * ForeignField: where the id of this schema (tour) is stored in the review
 * LocalField: where the id of the current data is stored in the schema: _id
 */
tourSchema.virtual('reviews', {
  ref: 'Review',
  foreignField: 'tour',
  localField: '_id',
});

// DOCUMENT MIDDLEWARE: runs before the save() and create()
tourSchema.pre('save', function (next) {
  this.slug = slugify(this.name, { lower: true });
  next();
});

/**
 * This will fetch the user info behind the scenes for all the Array of _id in the guides
 * Embed Users as guides
 */
// tourSchema.pre('save', async function (next) {
//   const guidesPromises = this.guides.map(async (id) => await User.findById(id));
//   this.guides = await Promise.all(guidesPromises);
//   next();
// });

// QUERY MIDDLEWARE: runs before any find() query is executed
tourSchema.pre(/^find/, function (next) {
  // tourSchema.pre('find', function (next) {
  this.find({ secretTour: { $ne: true } });

  this.start = Date.now();
  next();
});

/**
 * A Middleware to populate our query will all the guides correct info using the _ids in the guides[]
 * Using populate() with Promises will need executePopulate() in order to work
 */
tourSchema.pre(/^find/, function (next) {
  this.populate({
    path: 'guides',
    select: '-__v -passwordChangedAt',
  });

  next();
});

tourSchema.post(/^find/, function (doc, next) {
  console.log(`Query lasted: ${Date.now() - this.start} Milliseconds`);
  // console.log(doc);
  next();
});

/**
 * AGGREGATION MIDDLEWARE
 */
// tourSchema.pre('aggregate', function (next) {
//   this.pipeline().unshift({ $match: { secretTour: { $ne: true } } });

//   console.log(this.pipeline());
//   next();
// });

/**
 * Create the model from the Tour Schema
 * Export the model
 */
const Tour = mongoose.model('Tour', tourSchema); // Capitalize a model name
module.exports = Tour;
