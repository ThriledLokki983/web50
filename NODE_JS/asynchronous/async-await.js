const fs = require("fs");
const superagent = require("superagent");

const readFilePro = (file) => {
  return new Promise((resolve, reject) => {
    fs.readFile(file, (err, data) => {
      if (err) reject(`File NOT Found 😬`);
      resolve(data);
    });
  });
};

const writeFilePro = (file, data) => {
  return new Promise((resolve, reject) => {
    fs.writeFile(file, data, (err) => {
      if (err) reject(`Could NOT write file 🥲`);
      resolve("Success!!");
    });
  });
};

const getDogPic = async function () {
  try {
    const data = await readFilePro(`${__dirname}/starter/dog.txt`);
    console.log(`Breed: ${data}`);

    const res = await superagent.get(`https://dog.ceo/api/breed/${data}/images/random`);
    console.log(res.body.message);

    await writeFilePro("./starter/dog-img.txt", res.body.message);
    console.log("Random image is now saved!! 🥰");
  } catch (err) {
    console.log(err);
  }
};
getDogPic();
