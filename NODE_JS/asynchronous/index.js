const fs = require("fs");
const superagent = require("superagent");

fs.readFile(`${__dirname}/starter/dog.txt`, (err, data) => {
  console.log(`Breed: ${data}`);

  // making an http request
  superagent
    .get(`https://dog.ceo/api/breed/${data}/images/random`)
    .then((res) => {
      if (err) return console.log(err.message);
      console.log(res.body.message);

      fs.writeFile("./starter/dog-img.txt", res.body.message, (err) => {
        console.log("Random image is saved");
      });
    });
});
