const express = require('express');
const morgan = require('morgan');
const rateLimit = require('express-rate-limit');
const helmet = require('helmet');

const tourRouter = require('./routes/tourRoutes');
const userRouter = require('./routes/userRoutes');
const AppError = require('./utils/appError');
const globalErrorHandler = require('./controllers/errorController');

/**
 * Global Framework
 */
const app = express();

/**
 * Set Security HTTP  headers
 */
app.use(helmet());
app.use(helmet.xssFilter());

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
 * Body Parser, Reading data from the body into req.body()
 * Middleware: this can modify the incoming request
 * serving static files
 * A body less than 10kilobytes will not be accepted
 */
app.use(express.json({ limit: '10kb' }));

/**
 * Serving static files
 */
app.use(express.static(`${__dirname}/public`));

/**
 * TEST MIDDLEWARE - this was just for testing, it has no particular use. But I wont delete it
 */
app.use((req, res, next) => {
  req.requestTime = new Date().toISOString();
  next();
});

/**
 * ROUTES
 */
app.use('/api/v1/tours', tourRouter);
app.use('/api/v1/users', userRouter);

app.all('*', (req, res, next) => {
  next(new AppError(`Can't find ${req.originalUrl} on this server`, 404));
});

app.use(globalErrorHandler);

module.exports = app;
