// const tours = await Tour.find()
//   .where('duration')
//   .equals(5)
//   .where('difficulty')
//   .equals('easy');

// // 1) Filtering
// const queryObj = { ...req.query };
// const excludedFields = ['page', 'sort', 'limit', 'fields'];
// excludedFields.forEach((el) => delete queryObj[el]);

// // 2) Advanced Filtering
// let queryString = JSON.stringify(queryObj);
// queryString = queryString.replace(
//   /\b(gte|gt|lte|lt)\b/g,
//   (match) => `$${match}`
// );
// console.log(JSON.parse(queryString));

// console.log(req.query, queryObj);
// const tours = await Tour.find(req.query);
// const tours = await Tour.find(queryObj);

// const tours = await Tour.find({
//   duration: 5,
//   difficulty: 'easy',
// });
// let query = Tour.find(JSON.parse(queryString));

// SORTING
// if (req.query.sort) {
//   const sortBy = req.query.sort.split(',').join(' ');
//   query = query.sort(sortBy);
//   // sort('price ratingAverage')
// } else {
//   query = query.sort('-createdAt');
// }

// FIELD LIMITING
// if (req.query.fields) {
//   const fields = req.query.fields.split(',').join(' ');
//   query = query.select(fields);
// } else {
//   query = query.select('-__v'); // exclude this field
// }

// PAGINATION
// const page = +req.query.page; // defining default values
// const limit = req.query.limit * 1 || 100;
// const skip = (page - 1) * limit;

// // page=2&limit=10, 1-10 page1, 11-20 page2, 21-30 page3
// query = query.skip(skip).limit(limit);

// if (req.query.page) {
//   const numTours = await Tour.countDocuments();
//   if (skip >= numTours) throw new Error(`This page does not exist`);
// }

//    console.log(req.query);

// exports.checkID = (req, res, next, val) => {
//   console.log(`Tour id is:\t${val}`);
//   if (+req.params.id > tours.length)
//     return res.status(404).json({
//       status: 'fail',
//       message: 'Invalid ID',
//     });
//   next();
// };

// exports.checkBody = (req, res, next) => {
//   if (!req.body.name || !req.body.price)
//     return res.status(400).json({
//       status: 'fail',
//       message: 'Missing name or Price',
//     });
//   next();
// };

// TOUR MODEL
// const testTour = new Tour({
//   name: 'The Park Camper',
//   price: 497,
// });

// testTour
//   .save()
//   .then((doc) => {
//     console.log(doc);
//   })
//   .catch((err) => {
//     console.log(err.message);
//   });

// tourSchema.pre('save', function (next) {
//   console.log('Will save document...');
//   next();
// });

// tourSchema.post('save', function (doc, next) {
//   console.log(doc);
//   next();
// });

// creating our own middleware function
// app.use((req, res, next) => {
//   console.log('Hello from the middleware 👋');
//   next(); // to avoid blocking the app
// });

// const err = new Error(`Can't find ${req.originalUrl} on this server`);
// err.status = 'fail';
// err.statusCode = 404;

// exports.createTour = fn(async (req, res, next) => {
//     try {
//       const newTour = await Tour.create(req.body);

//       res.status(201).json({
//         status: 'success',
//         data: {
//           tour: newTour,
//         },
//       });
//     } catch (err) {
//       res.status(400).json({
//         status: 'fail',
//         message: err,
//       });
//     }
//   });

// exports.deleteTour = catchAsync(async (req, res, next) => {
//     await Tour.findByIdAndDelete(req.params.id,  {
//       rawResult: true,
//     });
//     res.status(204).json({
//       status: 'success',
//       data: null,
//     });
//   });

// Connecting to the local DB
// mongoose.connect(process.env.DATABASE_LOCAL, {
//   useNewUrlParser: true,
//   useCreateIndex: true,
//   useFindAndModify: false,
//   useUnifiedTopology: true,
// }).then(() => console.log("DB Connection successful"));

// reviewSchema.pre(/^find/, function (next) {
//   this.populate({
//     path: 'tour',
//     select: 'name',
//   }).populate({
//     path: 'user',
//     select: 'name photo',
//   });

//   next();
// });
