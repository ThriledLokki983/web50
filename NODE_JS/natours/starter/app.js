/**
 * Import/Require or core modules that the app depends on
 */
const path = require('path');
const express = require('express');
const morgan = require('morgan');
const rateLimit = require('express-rate-limit');
const helmet = require('helmet');
const mongoSanitize = require('express-mongo-sanitize');
const xss = require('xss-clean');
const hpp = require('hpp');
const cors = require('cors');
const cookieParser = require('cookie-parser');

const tourRouter = require('./routes/tourRoutes');
const userRouter = require('./routes/userRoutes');
const reviewRouter = require('./routes/reviewRoute');
const viewRouter = require('./routes/viewRoute');
const AppError = require('./utils/appError');
const globalErrorHandler = require('./controllers/errorController');

/**
 * Global Framework
 */
const app = express();

/**
 * Se the Headers for
 */
// app.use((req, res, next) => {
//   res.setHeader(
//     'Content-Security-Policy',
//     "script-src  'self' api.mapbox.com",
//     "script-src-elem 'self' api.mapbox.com"
//   );
//   next();
// });

/**
 * Define the view engine and the location of the templates
 */
app.set('view engine', 'pug');
app.set('views', path.join(__dirname, 'views'));

/**
 * Serving static files
 */
app.use(express.static(path.join(__dirname, 'public')));

/**
 * Set Security HTTP  headers
 */
app.use(helmet());
app.use(cors());

/**
 * Development Logging
 */
if (process.env.NODE_ENV === 'development') {
  app.use(morgan('dev'));
}

/**
 * Limit Requests from same API
 */
const limiter = rateLimit({
  max: 200,
  windowMs: 60 * 60 * 1000,
  message: 'Too Many request from this ip, please try again in an hour!',
});
app.use('/api', limiter);

/**
 * Body Parser, Reading data from the body into req.body(). Makes sure the body is parsed beforehand
 * Middleware: this can modify the incoming request
 * serving static files
 * A body less than 10kilobytes will not be accepted
 */
app.use(express.json({ limit: '10kb' }));
app.use(express.urlencoded({ extended: true, limit: '10kb' }));
app.use(cookieParser());

/**
 * Data Sanitization against NoSQL query injection
 * Data Sanitization against XSS - prevent html with malicious js script
 */
app.use(mongoSanitize());
app.use(xss());

/**
 * Prevent parameter pollution
 */
app.use(
  hpp({
    whitelist: [
      'duration',
      'ratingAverage',
      'ratingsQuantity',
      'maxGroupSize',
      'difficulty',
      'price',
    ],
  })
);

/**
 * TEST MIDDLEWARE - this was just for testing, it has no particular use. But I wont delete it
 */
app.use((req, res, next) => {
  req.requestTime = new Date().toISOString();
  console.log('Cookies: ', req.cookies);
  next();
});

/**
 * ROUTES
 * Rendering Pages
 * API
 */
app.use('/', viewRouter);
app.use('/api/v1/tours', tourRouter);
app.use('/api/v1/users', userRouter);
app.use('/api/v1/reviews', reviewRouter);

app.all('*', (req, res, next) => {
  next(new AppError(`Can't find ${req.originalUrl} on this server`, 404));
});

app.use(globalErrorHandler);

module.exports = app;
