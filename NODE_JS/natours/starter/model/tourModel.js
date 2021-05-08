const mongoose = require('mongoose');

// Mongoose - MODEL for crud
const tourSchema = new mongoose.Schema({
  name: {
    type: String,
    required: [true, 'A tour must have a Name'],
    unique: true,
  },
  rating: {
    type: Number,
    default: 4.5,
  },
  price: {
    type: Number,
    required: [true, 'A tour must have a Price'],
  },
});

const Tour = mongoose.model('Tour', tourSchema); // Capitalize a model name

module.exports = Tour;

// const testTour = new Tour({
//   name: 'The Park Camper',
//   price: 497,
// });

// testTour
//   .save()
//   .then((doc) => {
//     console.log(doc);
//   })
//   .catch((err) => {
//     console.log(err.message);
//   });
