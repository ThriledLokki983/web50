const express = require('express');

const app = express();

app.get('/', (req, res) => {
  //   res.status(200).send('Hello from the Server side');
  res
    .status(200)
    .json({ message: 'Hello from the Server side', app: 'Natours' });
});

app.post('/', (req, res) => {
  res.send('You can post to this endpoint.....');
});

const port = 4000;
app.listen(port, () => {
  console.log(`App running on port:\t${port}`);
});

// Routing