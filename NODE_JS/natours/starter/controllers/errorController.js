const AppError = require('../utils/appError');

/**
 * @param {Error} Operational error that has occurred (error in decoding the PayLoad / token expires)
 * @returns {AppError} an instance of the global error handler for Production Mode
 */
const handleJWTError = () => new AppError('Invalid token, please login again', 401);
const handleJWTExpiredError = () =>
  new AppError('Your Token has expired, please try again', 401);

const handleValidationErrorDB = (err) => {
  const errors = Object.values(err.errors).map((el) => el.message);

  const message = `Invalid input data: ${errors.join('. ')}`;
  return new AppError(message, 400);
};

const handleDuplicateFieldsDB = (err) => {
  const value = err.keyValue.name;
  const message = `Duplicate field value: ${value}. Please use another value!`;

  return new AppError(message, 404);
};

const handleCastErrorDB = (err) => {
  const message = `Invalid ${err.path}: ${err.value}.`;
  return new AppError(message, 400);
};

/**
 * FOr all errors that are generated during development and also from the API
 * @param {*} err
 * @param {*} req
 * @param {*} res
 * Render the error message
 */
const sendErrorDev = (err, req, res) => {
  if (req.originalUrl.startsWith('/api')) {
    return res.status(err.statusCode).json({
      status: err.status,
      error: err,
      message: err.message,
      stack: err.stack,
    });
  }

  // console.error('ERROR 💥', err);

  return res.status(err.statusCode).render('error', {
    title: 'Something went wrong',
    msg: err.message,
  });
};

/**
 * Operational, Trusted error: send message to client
 * @param {*} err
 * @param {*} req
 * @param {*} res
 * one handler for Operational/API errors - send message to client
 * Another handler for the rendered website
 * Programming or other unknown error: don't leak error details to client
 * Send generic message to client
 */
const sendErrorProd = (err, req, res) => {
  // API
  if (req.originalUrl.startsWith('/api')) {
    // A) Operational
    if (err.isOperational) {
      return res.status(err.statusCode).json({
        status: err.status,
        message: err.message,
      });
    }
    // 1) Log error
    // console.error('ERROR 💥', err);

    return res.status(500).json({
      status: 'error',
      message: 'Something went very wrong',
    });
  }
  if (err.isOperational) {
    // console.log(err);
    return res.status(err.statusCode).render('error', {
      title: 'Something went wrong',
      msg: err.message,
    });
  }
  // 1) Log error
  // console.error('ERROR 💥', err);

  // 2) Send generic message to client
  return res.status(err.statusCode).render('error', {
    title: 'Something is not right',
    msg: 'Please try again later',
  });
};

module.exports = (err, req, res, next) => {
  // 4 - params means an error handling middleware
  err.statusCode = err.statusCode || 500;
  err.status = err.status || 'error';

  // Sending different errors based on whether we are dev mode or production mode
  if (process.env.NODE_ENV === 'development') {
    sendErrorDev(err, req, res);
  } else if (process.env.NODE_ENV === 'production') {
    let error = { ...err };
    error.message = err.message;

    if (error.kind === 'ObjectId') error = handleCastErrorDB(error);
    if (error.code === 11000) error = handleDuplicateFieldsDB(error);
    if (error._message === 'Validation failed') error = handleValidationErrorDB(error);
    if (error.name === 'JsonWebTokenError') error = handleJWTError();
    if (error.name === 'TokenExpiredError') error = handleJWTExpiredError();

    // console.log(error);
    sendErrorProd(error, req, res);
  }
};
