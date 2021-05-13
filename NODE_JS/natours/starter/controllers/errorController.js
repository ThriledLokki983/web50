const sendErrorDev = (err, res) => {
  res.status(err.statusCode).json({
    status: err.status,
    error: err,
    message: err.message,
    stack: err.stack,
  });
};

const sendErrorProd = (err, res) => {
  // Operational, Trusted error: send message to client
  if (err.isOperational) {
    res.status(err.statusCode).json({
      status: err.status,
      message: err.message,
    });
    // Programming or other unknown error: don't leak error details to client
  } else {
    // 1) Log error
    console.error('ERROR 💥', err);

    // 2) Send generic message to client
    res.status(500).json({
      status: 'error',
      message: 'Something went very wrong',
    });
  }
};

module.exports = (err, req, res, next) => {
  // 4 - params means an error handling middleware
  err.statusCode = err.statusCode || 500;
  err.status = err.status || 'error';

  // Sending different errors based on whether we are dev mode or production mode
  if (process.env.NODE_ENV == 'development') {
    sendErrorDev(err, res);
  } else if ((process.env.NODE_ENV = 'production')) {
    sendErrorProd(err, res);
  }
};
