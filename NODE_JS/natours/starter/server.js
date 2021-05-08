const dotenv = require('dotenv');
const app = require('./app');

dotenv.config({ path: './config.env' });
// ENVIRONMENT VARIABLES

console.log(app.get('env')); // current environment: Development
// console.log(process.env);

// STARTING SERVER
const port = process.env.PORT || 4000;
app.listen(port, () => {
  console.log(`App running on port:\t${port}`);
});
