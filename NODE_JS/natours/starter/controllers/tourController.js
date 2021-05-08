const Tour = require('./../model/tourModel');

// exports.checkID = (req, res, next, val) => {
//   console.log(`Tour id is:\t${val}`);
//   if (+req.params.id > tours.length)
//     return res.status(404).json({
//       status: 'fail',
//       message: 'Invalid ID',
//     });
//   next();
// };

exports.checkBody = (req, res, next) => {
  if (!req.body.name || !req.body.price)
    return res.status(400).json({
      status: 'fail',
      message: 'Missing name or Price',
    });
  next();
};

exports.getAllTours = (req, res) => {
  console.log(req.requestTime);
  res.status(200).json({
    status: 'success',
    requestedAt: req.requestTime,
    // results: tours.length, // when the array has multiple objects in theres
    // data: {
    //   tours, // tours: tours
    // },
  });
};

exports.getTour = (req, res) => {
  console.log(req.params);
  const id = +req.params.id;
  // const tour = tours.find((el) => el.id === id);

  // res.status(200).json({
  //   status: 'success',
  //   data: {
  //     tour, // tours: tour
  //   },
  // });
};

exports.createTour = (req, res) => {
  res.status(201).json({
    status: 'success',
    //
  });

  //   res.send('Done'); // always have to send something in order to finish the request/response cycle
};

exports.updateTour = (req, res) => {
  res.status(200).json({
    status: 'success',
    data: {
      tour: '<Updated tour here>',
    },
  });
};

exports.deleteTour = (req, res) => {
  res.status(204).json({
    status: 'success',
    data: null,
  });
};
