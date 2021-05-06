const fs = require("fs");
const superagent = require("superagent");

const readFilePro = (file) => {
  return new Promise((resolve, reject) => {
    fs.readFile(file, (err, data) => {
      if (err) reject(`File NOT Found`);
      resolve(data);
    });
  });
};

readFilePro(`${__dirname}/starter/dog.txt`).then((result) => {
  console.log(`Breed: ${result}`);
  superagent
    .get(`https://dog.ceo/api/breed/${result}/images/random`)
    .then((res) => {
      console.log(res.body.message);

      fs.writeFile("./starter/dog-img.txt", res.body.message, (err) => {
        console.log("Random image is saved");
      });
    })
    .catch((err) => {
      console.log(err.message);
    });
});

// fs.readFile(`${__dirname}/starter/dog.txt`, (err, data) => {
//   console.log(`Breed: ${data}`);

//   // making an http request
// });
