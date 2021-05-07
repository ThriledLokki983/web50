const app = require('./app');

// STARTING SERVER
const port = 4000;
app.listen(port, () => {
  console.log(`App running on port:\t${port}`);
});
