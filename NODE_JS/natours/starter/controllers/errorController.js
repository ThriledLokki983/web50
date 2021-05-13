module.exports = (err, req, res, next) => {
  // 4 - params means an error handling middleware
  err.statusCode = err.statusCode || 500;
  err.status = err.status || 'error';

  res.status(err.statusCode).json({
    status: err.status,
    message: err.message,
  });
};
