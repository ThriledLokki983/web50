const fs = require('fs');
const mongoose = require('mongoose');
const dotenv = require('dotenv');
const Tour = require('./../../model/tourModel');
const User = require('./../../model/userModel');
const Review = require('./../../model/reviewModel');

dotenv.config({ path: './config.env' });

/**
 * ENVIRONMENT VARIABLES
 * CONNECTING to the online DB and putting in the right info from .env
 */
const DB = process.env.DATABASE.replace('<PASSWORD>', process.env.DATABASE_PASSWORD);

mongoose
  .connect(DB, {
    useNewUrlParser: true,
    useCreateIndex: true,
    useFindAndModify: false,
    useUnifiedTopology: true,
  })
  .then((con) => {
    console.log('DB Connection successful');
  });

/**
 * READ JSON FILE
 */
const tours = JSON.parse(fs.readFileSync(`${__dirname}/tours.json`, 'utf-8'));
const users = JSON.parse(fs.readFileSync(`${__dirname}/users.json`, 'utf-8'));
const reviews = JSON.parse(fs.readFileSync(`${__dirname}/reviews.json`, 'utf-8'));

/**
 * IMPORT DATA INTO DB
 * This will import data from a file into our data. the data in the file should have the structure specified in the schema
 */
const importData = async function () {
  try {
    await Tour.create(tours);
    await User.create(users, { validateBeforeSave: false });
    await Review.create(reviews);
    console.log('Data loaded Successfully ');
  } catch (err) {
    console.log(err);
  }
  process.exit();
};

/**
 * DELETE ALL DATA FROM COLLECTIONS
 * delete all data in the tours collections
 */
const deleteData = async function () {
  try {
    await Tour.deleteMany();
    await User.deleteMany();
    await Review.deleteMany();
    console.log('Data Successfully  deleted');
  } catch (err) {
    console.log(err);
  }
  process.exit();
};

/**
 * Deciding what to do when called. --delete to delete everything and --import to populate our db with some data
 */
if (process.argv[2] === '--import') {
  importData();
} else if (process.argv[2] === '--delete') {
  deleteData();
}
