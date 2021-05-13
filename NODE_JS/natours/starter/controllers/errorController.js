const sendErrorDev = (err, res) => {
  res.status(err.statusCode).json({
    status: err.status,
    error: err,
    message: err.message,
    stack: err.stack,
  });
};

const sendErrorProd = (err, res) => {
  res.status(err.statusCode).json({
    status: err.status,
    message: err.message,
  });
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
