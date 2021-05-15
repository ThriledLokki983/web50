const catchAsync = require('./../utils/catchAsync');
const AppError = require('./../utils/appError');
const APIFeatures = require('./../utils/apiFeatures');

/**
 * Delete Document/Info Function
 * @param {Model} Model any model that has already been created can then make use of this delete function
 * @returns {Async Function} which is then used as a query on the DB
 */
exports.deleteOne = (Model) =>
  catchAsync(async (req, res, next) => {
    const doc = await Model.findByIdAndDelete(req.params.id);

    if (!doc) {
      return next(new AppError('No document found with that ID', 404));
    }

    res.status(204).json({
      status: 'success',
      data: null,
    });
  });

/**
 * Update Document/Info in DB
 * @param {Model} Model any model that has already been created can then make use of this delete function
 * @returns {Async Function} which is then used as a query on the DB to execute action
 */
exports.updateOne = (Model) =>
  catchAsync(async (req, res, next) => {
    const doc = await Model.findByIdAndUpdate(req.params.id, req.body, {
      new: true,
      runValidators: true,
    });

    if (!doc) {
      return next(new AppError('No document found with that ID', 404));
    }
    res.status(200).json({
      status: 'success',
      data: {
        data: doc,
      },
    });
  });

/**
 * Create new Document in DB
 * @param {Model} Model any model that has already been created can then make use of this delete function
 * @returns {Async Function} which is then used as a query on the DB to execute action
 */
exports.createOne = (Model) =>
  catchAsync(async (req, res, next) => {
    const doc = await Model.create(req.body);

    if (!doc) {
      return next(new AppError('Cannot create an empty Document!', 404));
    }

    res.status(201).json({
      status: 'success',
      data: {
        data: doc,
      },
    });
  });

/**
 * Query for one Document in DB
 * @param {Model} Model any model that has already been created can then make use of this delete function
 * @param {Function} popOptions || Query for a single tour with the populate() mongoose method || path: && select:
 * @returns {Async Function} which is then used as a query on the DB to execute action
 * Behind the scenes, populate() creates new query and this still affects performance. Take that into account
 */
exports.getOne = (Model, popOptions) =>
  catchAsync(async (req, res, next) => {
    let query = Model.findById(req.params.id);
    if (popOptions) query = query.populate(popOptions);

    const doc = await query;

    if (!doc) {
      return next(new AppError('No document found with that ID', 404));
    }

    res.status(200).json({
      status: 'success',
      data: {
        doc,
      },
    });
  });

/**
 * This allows for nested GET review || e.g tour (A small hack) || Retrieving all the reviews from the DB
 * @param {Model} Model any model that has already been created can then make use of this delete function
 * @returns {Async Function} which is then used as a query on the DB to execute action
 * const doc = await features.query.explain(); // this helps to get stats on the query performed
 */
exports.getAll = (Model) =>
  catchAsync(async (req, res, next) => {
    let filter = {};
    if (req.params.tourId) filter = { tour: req.params.tourId };

    const features = new APIFeatures(Model.find(filter), req.query)
      .filter()
      .sort()
      .limitFields()
      .paginate();

    const doc = await features.query;

    res.status(200).json({
      status: 'success',
      results: doc.length,
      data: {
        data: doc,
      },
    });
  });
