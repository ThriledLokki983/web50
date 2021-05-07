const express = require('express');
const morgan = require('morgan');

const tourRouter = require('./routes/tourRoutes');
const userRouter = require('./routes/userRoutes');

const app = express();

// MIDDLEWARE
app.use(morgan('dev'));
app.use(express.json()); // Middleware: this can modify the incoming request

// creating our own middleware function
app.use((req, res, next) => {
  console.log('Hello from the middleware 👋');
  next(); // to avoid blocking the app
});

app.use((req, res, next) => {
  req.requestTime = new Date().toISOString();
  next();
});

// ROUTES
app.use('/api/v1/tours', tourRouter);
app.use('/api/v1/users', userRouter);

// STARTING SERVER
const port = 4000;
app.listen(port, () => {
  console.log(`App running on port:\t${port}`);
});
