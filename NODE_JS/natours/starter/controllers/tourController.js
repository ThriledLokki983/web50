const multer = require('multer');
const sharp = require('sharp');
const Tour = require('./../model/tourModel');
const catchAsync = require('./../utils/catchAsync');
const factory = require('./handlerFactory');
const AppError = require('./../utils/appError');

/**
 * Store images in memory
 */
const multerStorage = multer.memoryStorage();

/**
 * CHeck and restrict file types to be uploaded
 * @param {*} req
 * @param {*} file
 * @param {*} cbFunc
 */
const multerFilter = (req, file, cbFunc) => {
  if (file.mimetype.startsWith('image')) {
    cbFunc(null, true);
  } else {
    cbFunc(new AppError('Not an image! Please upload only images', 400), false);
  }
};

/**
 * Configure multer upload for the destination of all uploaded files
 * This is just to make the code cleaner
 */
const upload = multer({
  storage: multerStorage,
  fileFilter: multerFilter,
});

/**
 * Middleware to take care of our multiple image uploads
 * for a single upload | upload.single('form field name')
 * for multiple uploads with the same name | upload.Array('images')
 * or multiple uploads with the different names | upload.fields('images')
 *
 */
exports.uploadTourImages = upload.fields([
  { name: 'imageCover', maxCount: 1 },
  { name: 'images', maxCount: 3 },
]);

/**
 * Middleware to process images
 * First check if any image is uploaded or not
 * Single processing for the ImageCover & process images in a loop
 * important!! put the images on the req.body
 * images is an array so we loop with map and since it is an async function we wait for the promise coming from the array of images using Promise.  * all ()
 */
exports.resizeTourImages = catchAsync(async (req, res, next) => {
  if (!req.files.imageCover || !req.files.images) return next();

  req.body.imageCover = `tour-${req.params.id}-${Date.now()}-cover.jpeg`;

  await sharp(req.files.imageCover[0].buffer)
    .resize(2000, 1333)
    .toFormat('jpeg')
    .jpeg({ quality: 90 })
    .toFile(`public/img/tours/${req.body.imageCover}`);

  req.body.images = [];

  await Promise.all(
    req.files.images.map(async (file, i) => {
      const fileName = `tour-${req.params.id}-${Date.now()}-${i + 1}.jpeg`;

      await sharp(file.buffer)
        .resize(2000, 1333)
        .toFormat('jpeg')
        .jpeg({ quality: 90 })
        .toFile(`public/img/tours/${fileName}`);

      req.body.images.push(fileName);
    })
  );

  next();
});

/**
 * Top 5 Tours
 * @param {*} req
 * @param {*} res
 * @param {*} next
 */
exports.aliasTopTours = async (req, res, next) => {
  try {
    req.query.limit = '5';
    req.query.sort = '-ratingsAverage,price';
    req.query.fields = 'name,price,ratingsAverage,summary,difficulty';
  } catch (err) {
    console.log(err);
  }
  next();
};

/**
 * Creates Tour Document
 * Update Tour Document using ID
 * Delete Tour Document using ID
 * Query for a single Tour
 * Query for all Tours
 */
exports.createTour = factory.createOne(Tour);
exports.updateTour = factory.updateOne(Tour);
exports.deleteTour = factory.deleteOne(Tour);
exports.getTour = factory.getOne(Tour, { path: 'reviews' });
exports.getAllTours = factory.getAll(Tour);

exports.getTourStats = catchAsync(async (req, res, next) => {
  const stats = await Tour.aggregate([
    {
      $match: { ratingAverage: { $gte: 4.5 } },
    },
    {
      $group: {
        // _id: null,
        // _id: '$difficulty',
        _id: { $toUpper: '$difficulty' },
        numTours: { $sum: 1 }, // Number of tours
        numRatings: { $sum: '$ratingsQuantity' },
        avgRating: { $avg: '$ratingAverage' },
        avgPrice: { $avg: '$price' },
        minPrice: { $min: '$price' },
        maxPrice: { $max: '$price' },
      },
    },
    {
      $sort: { avgPrice: 1 },
    },
  ]);

  res.status(200).json({
    status: 'success',
    data: {
      stats,
    },
  });
});

exports.getMonthlyPlan = catchAsync(async (req, res, next) => {
  const year = +req.params.year; // 2021

  const plan = await Tour.aggregate([
    {
      $unwind: '$startDates',
    },
    {
      $match: {
        startDates: {
          $gte: new Date(`${year}-01-01`),
          $lte: new Date(`${year}-12-31`),
        },
      },
    },
    {
      $group: {
        _id: { $month: '$startDates' },
        numTourStarts: { $sum: 1 },
        tours: { $push: '$name' },
      },
    },
    {
      $addFields: { month: '$_id' },
    },
    {
      $project: {
        _id: 0,
      },
    },
    {
      $sort: { numTourStarts: -1 },
    },
    {
      $limit: 12,
    },
  ]);

  res.status(200).json({
    status: 'success',
    data: {
      plan,
    },
  });
});

/**
 * Specifying the Geo Location in MongoDB. || {$geoWithin {$centerSphere: radiant, longitude, latitude}} ||
 * @param {*} req
 * @param {*} res
 * @param {*} next
 * '/tours-within/:distance/center/:latlng/unit/:unit' // Route:
 * tours-within/233/center/34.111745,-118.113491/unit/mi
 * Mongo expects a radiant: which is the result of the distance / radius of the earth
 */
exports.getToursWithin = catchAsync(async (req, res, next) => {
  const { distance, latlng, unit } = req.params;
  const [lat, lng] = latlng.split(',');

  const radius = unit === 'mi' ? distance / 3963.2 : distance / 6378.1;

  if (!lat || !lng) {
    next(
      new AppError('Please provide latitude and longitude in the format lat,lng', 400)
    );
  }

  const tour = await Tour.find({
    startLocation: { $geoWithin: { $centerSphere: [[lng, lat], radius] } },
  });

  console.log(distance, latlng, unit);

  res.status(200).json({
    status: 'success',
    results: tour.length,
    data: {
      data: tour,
    },
  });
});

/**
 * GeoNear always needs to be the first aggregation pipeline in the first stage ||
 * $geoNear requires a field that has geospatial index || If multiple fields, you will need to specify which one to be used
 * Route: '/distances/:latlng/unit/:unit'
 */
exports.getDistances = catchAsync(async (req, res, next) => {
  const { latlng, unit } = req.params;
  const [lat, lng] = latlng.split(',');

  const multiplier = unit === 'mi' ? 0.000621371 : 0.001;

  if (!lat || !lng) {
    next(
      new AppError('Please provide latitude and longitude in the format lat,lng', 400)
    );
  }

  const distances = await Tour.aggregate([
    {
      $geoNear: {
        near: {
          type: 'Point',
          coordinates: [+lng, +lat],
        },
        distanceField: 'distance',
        distanceMultiplier: multiplier,
      },
    },
    {
      $project: {
        distance: 1,
        name: 1,
      },
    },
  ]);

  res.status(200).json({
    status: 'success',
    data: {
      data: distances,
    },
  });
});
