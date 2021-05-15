const fs = require('fs');
const mongoose = require('mongoose');
const dotenv = require('dotenv');
const Tour = require('./../../model/tourModel');

dotenv.config({ path: './config.env' });
// ENVIRONMENT VARIABLES

/**
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

/**
 * IMPORT DATA INTO DB
 * This will import data from a file into our data. the data in the file should have the structure specified in the schema
 */
const importData = async function () {
  try {
    await Tour.create(tours);
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
    console.log('Data Successfully  deleted');
  } catch (err) {
    console.log(err);
  }
  process.exit();
};

if (process.argv[2] === '--import') {
  importData();
} else if (process.argv[2] === '--delete') {
  deleteData();
}
