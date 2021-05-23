const express = require('express');
const userController = require('./../controllers/userController');
const authController = require('./../controllers/authController');
const { route } = require('./reviewRoute');

const router = express.Router();

router.post('/signup', authController.signup);
router.post('/login', authController.login);
router.get('/logout', authController.logout);

router.post('/forgotPassword', authController.forgotPassword);
router.patch('/resetPassword/:token', authController.resetPassword);

router.use(authController.protect);

router.get('/me', userController.getMe, userController.getUser);
router.patch('/updateMyPassword', authController.updatePassword);
router.patch(
  '/updateMe',
  userController.uploadUserPhoto,
  userController.resizeUserPhoto,
  userController.updateMe
); // single takes the field-name in the form for the upload
router.delete('/deleteMe', userController.deleteMe);

/**
 * Restrict the below functionalities to only Admin
 */
router.use(authController.restrictTo('admin'));

router.route('/').get(userController.getAllUsers).post(userController.createUser);
router
  .route('/:id')
  .get(userController.getUser)
  .patch(userController.updateUserInfo)
  .delete(userController.deleteUser);

module.exports = router;
