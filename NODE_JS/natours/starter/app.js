const express = require('express');
const fs = require('fs');

const app = express();
app.use(express.json()); // Middleware: this can modify the incoming request

const tours = JSON.parse(
  fs.readFileSync(`${__dirname}/dev-data/data/tours-simple.json`)
);

const getAllTours = (req, res) => {
  res.status(200).json({
    status: 'success',
    results: tours.length, // when the array has multiple objects in theres
    data: {
      tours, // tours: tours
    },
  });
};

const getTour = (req, res) => {
  // specify optional param as :id?
  console.log(req.params);
  const id = +req.params.id;
  const tour = tours.find((el) => el.id === id);

  //   if (id > tours.length)
  if (!tour)
    return res.status(404).json({
      status: 'fail',
      message: 'Invalid ID',
    });

  res.status(200).json({
    status: 'success',
    data: {
      tour, // tours: tour
    },
  });
};

const createTour = (req, res) => {
  //   console.log(req.body);
  const newId = tours[tours.length - 1].id + 1;
  const newTour = Object.assign({ id: newId }, req.body);

  tours.push(newTour);
  fs.writeFile(
    `${__dirname}/dev-data/data/tours-simple.json`,
    JSON.stringify(tours),
    (err) => {
      res.status(201).json({
        status: 'success',
        data: {
          tour: newTour,
        },
      });
    }
  );

  //   res.send('Done'); // always have to send something in order to finish the request/response cycle
};

const updateTour = (req, res) => {
  if (+req.params.id > tours.length)
    return res.status(404).json({
      status: 'fail',
      message: 'Invalid ID',
    });
  res.status(200).json({
    status: 'success',
    data: {
      tour: '<Updated tour here>',
    },
  });
};

const deleteTour = (req, res) => {
  if (+req.params.id > tours.length)
    return res.status(404).json({
      status: 'fail',
      message: 'Invalid ID',
    });
  res.status(204).json({
    status: 'success',
    data: null,
  });
};

// app.get('/api/v1/tours', getAllTours);
// app.get('/api/v1/tours/:id', getTour);
// app.post('/api/v1/tours', createTour);
// app.patch('/api/v1/tours/:id', updateTour);
// app.delete('/api/v1/tours/:id', deleteTour);

app.route('/api/v1/tours').get(getAllTours).post(createTour);

app
  .route('/api/v1/tours/:id')
  .get(getTour)
  .patch(updateTour)
  .delete(deleteTour);

const port = 4000;
app.listen(port, () => {
  console.log(`App running on port:\t${port}`);
});
