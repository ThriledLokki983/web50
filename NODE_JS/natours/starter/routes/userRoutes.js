const express = require('express');
const userController = require('./../controllers/userController');
// ROUTE HANDLERS

const router = express.Router();

router
  .route('/')
  .get(userController.getAllUsers)
  .post(userController.createUser);
router
  .route('/:id')
  .get(userController.getUser)
  .patch(userController.updateUserInfo)
  .delete(userController.deleteUser);

module.exports = router;