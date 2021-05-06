const express = require('express');
const fs = require('fs');

const app = express();
app.use(express.json()); // Middleware: this can modify the incoming request

// app.get('/', (req, res) => {
//   //   res.status(200).send('Hello from the Server side');
//   res
//     .status(200)
//     .json({ message: 'Hello from the Server side', app: 'Natours' });
// });

// app.post('/', (req, res) => {
//   res.send('You can post to this endpoint.....');
// });

const tours = JSON.parse(
  fs.readFileSync(`${__dirname}/dev-data/data/tours-simple.json`)
);

app.get('/api/v1/tours', (req, res) => {
  res.status(200).json({
    status: 'success',
    results: tours.length, // when the array has multiple objects in theres
    data: {
      tours, // tours: tours
    },
  });
});

app.post('/api/v1/tours', (req, res) => {
  console.log(req.body);
  res.send('Done'); // always have to send something in order to finish the request/response cycle
});

const port = 4000;
app.listen(port, () => {
  console.log(`App running on port:\t${port}`);
});

// Routing
