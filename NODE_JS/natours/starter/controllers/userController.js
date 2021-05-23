const multer = require('multer');
const sharp = require('sharp');
const User = require('./../model/userModel');
const catchAsync = require('./../utils/catchAsync');
const AppError = require('./../utils/appError');
const factory = require('./handlerFactory');

/**
 * Create a multer storage with destination and filename
 */
// const multerStorage = multer.diskStorage({
//   destination: (req, file, cbFunc) => {
//     cbFunc(null, 'public/img/users');
//   },
//   filename: (req, file, cbFunc) => {
//     const ext = file.mimetype.split('/')[1];
//     cbFunc(null, `user-${req.user.id}-${Date.now()}.${ext}`);
//   },
// });

const multerStorage = multer.memoryStorage();

/**
 * CHeck and restrict file types to be uploaded
 * @param {*} req
 * @param {*} file
 * @param {*} cbFunc
 */
const multerFilter = (req, file, cbFunc) => {
  if (file.mimetype.startsWith('image')) {
    cbFunc(null, true);
  } else {
    cbFunc(new AppError('Not an image! Please upload only images', 400), false);
  }
};

/**
 * Configure multer upload for the destination of all uploaded files
 * This is just to make the code cleaner
 */
const upload = multer({
  storage: multerStorage,
  fileFilter: multerFilter,
});

/**
 * Create an export for our upload
 */
exports.uploadUserPhoto = upload.single('photo');

/**
 * Process and manipulate the image to fit our needs || Avoid large and variable image sizes
 * This middleware runs right after the photo is uploaded, the upload is in buffer and not in filesystem now
 * The image processing resizes the image and sets the quality to 90% then finally writes the image to our filesystem in our preferred folder
 * @param {*} req
 * @param {*} res
 * @param {*} next
 */
exports.resizeUserPhoto = (req, res, next) => {
  if (!req.file) return next();

  req.file.filename = `user-${req.user.id}-${Date.now()}.jpeg`;

  sharp(req.file.buffer)
    .resize(500, 500)
    .toFormat('jpeg')
    .jpeg({ quality: 90 })
    .toFile(`public/img/users/${req.file.filename}`);

  next();
};

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

exports.getMe = (req, res, next) => {
  req.params.id = req.user.id;
  next();
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
 * Update User info | If there is a photo, add it to the filteredBody
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
  if (req.file) filteredBody.photo = req.file.filename;
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
