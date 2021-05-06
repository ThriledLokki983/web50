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

    const res1Pro = superagent.get(`https://dog.ceo/api/breed/${data}/images/random`);
    const res2Pro = superagent.get(`https://dog.ceo/api/breed/${data}/images/random`);
    const res3Pro = superagent.get(`https://dog.ceo/api/breed/${data}/images/random`);

    const all = await Promise.all([res1Pro, res2Pro, res3Pro]);
    const imgs = all.map((element) => element.body.message);
    console.log(imgs);

    await writeFilePro("./starter/dog-img1.txt", imgs.join("\n"));
    await writeFilePro("./starter/dog-img.txt", res.body.message);
    console.log("Random image is now saved!! 🥰");
  } catch (err) {
    console.log(err);
    throw err;
  }

  return "2: \tREADY🐶";
};
(async () => {
  try {
    console.log("1: \tStep 1 will get dog pic");
    const x = await getDogPic();
    console.log(x);
    console.log("3: \tDone");
  } catch (err) {
    console.log("ERROR! 💥");
  }
})();

/*
console.log("1: \tStep 1 will get dog pic");
getDogPic()
  .then((x) => {
    console.log(x);
    console.log("3: \tDone");
  })
  .catch((err) => {
    console.log("ERROR! 💥");
  });

  */
