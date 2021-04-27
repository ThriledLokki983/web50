console.log('CHALLENG 2');
console.log('===================================');
imageContainer = document.querySelector('.images');
// Create a func 'createImage

const createImage = function (imgPath) {
    return new Promise(function (resolve, reject) {
        let el = document.createElement('img');
        el.src = imgPath;

        el.addEventListener('load', function () {
            imageContainer.append(el);
            resolve(el);
        })

        el.addEventListener('error', function () {
            reject(new Error('Could not load image'))
        })
    });
}

// createImage('/img/img-1.jpg').then(res => console.log('Success')).catch(err => console.error(err));
// createImage('/Users/ogidi/Desktop/img/image2.jpeg');

const wait = function (section) {
    return new Promise(resolve => setTimeout(resolve, section * 1000));
}

wait(2).then(res => createImage('/img/img-1.jpg')).catch(err => console.log(err));