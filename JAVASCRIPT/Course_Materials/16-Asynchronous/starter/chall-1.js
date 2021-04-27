'use strict';

const imageContainer = document.querySelector('.images');

const createImage = function (imgPath) {
  return new Promise(function (resolve, reject) {
    let el = document.createElement('img');
    el.src = imgPath;

    el.addEventListener('load', function () {
      imageContainer.append(el);
      resolve(el);
    });

    el.addEventListener('error', function () {
      reject(new Error(`Could not load Image`));
    });
  });
};

const wait = function (sec) {
  return new Promise(resolve => setTimeout(resolve, sec * 1000));
};

// write an async function for loadAll

const loadNPause = async function () {
  let theImage;
  try {
    // Load image 1
    let data = await createImage('/img/img-1.jpg');

    // Wait
    await wait(3);
    data.style.display = 'none';

    data = await createImage('/img/img-2.jpg');

    await wait(3);
    data.style.display = 'none';

    data = await createImage('/img/img-3.jpg');
  } catch (err) {
    console.error(err.message);
  }
};

// loadNPause();

//! PART 2

const loadAll = async function (imgArr) {
  try {
    const imgs = imgArr.map(async e => await createImage(e)); // get the elements ind
    // console.log(imgs);
    const data = await Promise.all(imgs);
    data.forEach(e => e.classList.add('parallel'));
    // console.log(data);
  } catch (error) {
    console.log(error.message);
  }
};

loadAll(['/img/img-1.jpg', '/img/img-2.jpg', '/img/img-3.jpg']);
