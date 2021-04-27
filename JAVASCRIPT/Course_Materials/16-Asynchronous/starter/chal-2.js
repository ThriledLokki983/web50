// console.log('CHALLENG 2');
// console.log('===================================');
// imageContainer = document.querySelector('.images');
// // Create a func 'createImage

// const createImage = function (imgPath) {
//     return new Promise(function (resolve, reject) {
//         let el = document.createElement('img');
//         el.src = imgPath;

//         el.addEventListener('load', function () {
//             imageContainer.append(el);
//             resolve(el);
//         })

//         el.addEventListener('error', function () {
//             reject(new Error('Could not load image'))
//         })
//     });
// }

// // createImage('/img/img-1.jpg').then(res => console.log('Success')).catch(err => console.error(err));
// // createImage('/Users/ogidi/Desktop/img/image2.jpeg');

// const wait = function (section) {
//     return new Promise(resolve => setTimeout(resolve, section * 1000));
// }

// let image;
// createImage('/img/img-1.jpg')
//     .then(img => {
//         image = img;
//         return wait(4);
//     }).then(() => {
//         image.style.display = 'none';
//         return createImage('/img/img-2.jpg');
//     }).then((img) => {
//         image = img;
//         return wait(4);
//     }).then(() => {
//         image.style.display = 'none';
//         return createImage('/img/img-3.jpg')
//     })


const imgContainer = document.querySelector('.images')

const createImage = function (imgPath) {
    return new Promise(function (resolve, reject) {
        const img = document.createElement('img');
        img.src = imgPath;

        img.addEventListener('load', function () {
            imgContainer.append(img);
            resolve(img);
        })

        img.addEventListener('error', function () {
            reject(new Error("Image not found"));
        })
    })
}

const wait = function (section) {
    return new Promise(resolve => setTimeout(resolve, section * 1000));
}

let theImage;

createImage('/img/img-1.jpg').then(res => {
        console.log('image 1 loaded');
        theImage = res;
        return wait(2); // the next then don't have any argument bcos wait does not return any resolved value
    }).then(() => {
        theImage.style.display = 'none';
        return createImage('/img/img-2.jpg');
    }).then(res => {
        theImage = res;
        return wait(2);
    }).then(() => {
        theImage.style.display = 'none';
        return createImage('/img/img-3.jpg');
    }).then(res => {
        theImage = res;
        return wait(2);
    })
    .catch(err => console.error(err));