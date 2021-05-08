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

console.log(app.get('env')); // current environment: Development
// console.log(process.env);

// STARTING SERVER
const port = process.env.PORT || 4000;
app.listen(port, () => {
  console.log(`App running on port:\t${port}`);
});
