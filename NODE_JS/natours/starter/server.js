const mongoose = require('mongoose');
const dotenv = require('dotenv');
const app = require('./app');

dotenv.config({ path: './config.env' });
// ENVIRONMENT VARIABLES

const DB = process.env.DATABASE.replace(
  '<PASSWORD>',
  process.env.DATABASE_PASSWORD
);

// Connecting to the local DB
// mongoose.connect(process.env.DATABASE_LOCAL, {
//   useNewUrlParser: true,
//   useCreateIndex: true,
//   useFindAndModify: false,
//   useUnifiedTopology: true,
// }).then(() => console.log("DB Connection successful"));

mongoose
  .connect(DB, {
    useNewUrlParser: true,
    useCreateIndex: true,
    useFindAndModify: false,
    useUnifiedTopology: true,
  })
  .then((con) => {
    // console.log(con.connections);
    console.log('DB Connection successful');
  });

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

const testTour = new Tour({
  name: 'The Park Camper',
  price: 497,
});

testTour
  .save()
  .then((doc) => {
    console.log(doc);
  })
  .catch((err) => {
    console.log(err.message);
  });

console.log(app.get('env')); // current environment: Development
// console.log(process.env);

// STARTING SERVER
const port = process.env.PORT || 4000;
app.listen(port, () => {
  console.log(`App running on port:\t${port}`);
});
