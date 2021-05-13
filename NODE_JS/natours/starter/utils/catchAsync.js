/**
 *
 * @param {Async function} fn - returns a promise and when there is an error, the catch will pass the error to the next() function, which then further passes it on to the global error handler and that's it. Magic! -- error is correctly handled
 * @returns {Anonymous function} - can be assigned to a parameter e.g. createTour
 *
 */
const catchAsync = (fn) => {
  return (req, res, next) => {
    fn(req, res, next).catch((err) => next(err));
  };
};

module.exports = catchAsync;
