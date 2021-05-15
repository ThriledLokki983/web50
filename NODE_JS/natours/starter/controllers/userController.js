const User = require('./../model/userModel');
const catchAsync = require('./../utils/catchAsync');
const AppError = require('./../utils/appError');
const factory = require('./handlerFactory');

exports.createUser = (req, res) => {
  res.status(500).json({
    status: 'error',
    message: 'This route is not yet defined, Please use signUp instead',
  });
};

exports.updateUser = (req, res) => {
  res.status(500).json({
    status: 'error',
    message: 'This route is not yet defined',
  });
};

/**
 * Loop through all the fields that are in the object, and each of the fields, we check if it is one of the allowedfields, if is
 * We create an element in the newObject with the same element
 * @param Object obj
 * @param  {Array} allowedFields
 * @returns {Object}
 */
const filterObj = (obj, ...allowedFields) => {
  const newObject = {};
  Object.keys(obj).forEach((el) => {
    if (allowedFields.includes(el)) newObject[el] = obj[el];
  });
  return newObject;
};

/**
 * Create error if user tries to POST/ update password
 * Else, update user document and since we are not dealing with any sensitive data like password, we can then use findByIdAnUpdate() method
 * Filter out the unwanted fields names that are not to be allowed to be updated
 * Update User info
 * @param {*} req
 * @param {*} res
 * @param {*} next
 */
exports.updateMe = catchAsync(async (req, res, next) => {
  if (req.body.password || req.body.passwordConfirm) {
    return next(
      new AppError(
        'This route is not for password update, Please use /updateMyPassword.',
        400
      )
    );
  }

  const filteredBody = filterObj(req.body, 'name', 'email');
  const updatedUser = await User.findByIdAndUpdate(req.user.id, filteredBody, {
    new: true,
    runValidators: true,
  });

  res.status(200).json({
    status: 'success',
    data: {
      user: updatedUser,
    },
  });
});

exports.deleteMe = catchAsync(async (req, res, next) => {
  const updatedUser = await User.findByIdAndUpdate(req.user.id, { active: false });

  res.status(204).json({
    status: 'success',
    data: null,
  });
});

/**
 * Creates User uses the SignUp from the authController file
 * Update User Document using ID || This does not update passwords
 * Delete User Document using ID
 * Query for a single User
 * Query for all USers
 */
exports.deleteUser = factory.deleteOne(User);
exports.updateUserInfo = factory.updateOne(User);
exports.getUser = factory.getOne(User);
exports.getAllUsers = factory.getAll(User);
