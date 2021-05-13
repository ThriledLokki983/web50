const mongoose = require('mongoose');
const dotenv = require('dotenv');
dotenv.config({ path: './config.env' });

// Uncalled exceptions
process.on('uncaughtException', (err) => {
  console.log('UNCAUGHT EXCEPTION!: Shutting down...');
  console.log(err.name, err.message);
  process.exit(1); // 0 - success, 1 - uncalled exception
});

const app = require('./app');
// ENVIRONMENT VARIABLES

const DB = process.env.DATABASE.replace(
  '<PASSWORD>',
  process.env.DATABASE_PASSWORD
);

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
// .catch((err) => console.log('ERROR'));

console.log(app.get('env')); // current environment: Development
// console.log(process.env);

// STARTING SERVER
const port = process.env.PORT || 4000;
const client = app.listen(port, () => {
  console.log(`App running on port:\t${port}`);
});

// Global Safety Net for all unhandled errors
process.on('unhandledRejection', (err) => {
  console.log('UNHANDLED REJECTION!: Shutting down...');
  console.log(err.name, err.message);
  client.close(() => {
    process.exit(1); // 0 - success, 1 - uncalled exception
  });
});
