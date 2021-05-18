const express = require('express');
const viewController = require('./../controllers/viewsController');

const router = express.Router();

/**
 * View Routes
 */
router.get('/', viewController.getOverview);
router.get('/tour/:slug', viewController.getTour);

module.exports = router;
