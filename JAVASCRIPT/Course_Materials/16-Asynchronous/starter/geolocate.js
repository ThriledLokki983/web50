// const btn = document.querySelector('.btn-country');
// const countriesContainer = document.querySelector('.countries');


// navigator.geolocation.getCurrentPosition(pos => { // this function offloads its work to the Web API and then moves to the next line.
//     console.log(pos);
// }, err => {
//     console.log(err);
// });
// console.log('Getting Position');

const getPosition = function () {
    return new Promise(function (resolve, reject) {
        // navigator.geolocation.getCurrentPosition(
        //     (position) => resolve(position), // this is the fulfilled value in case we successfully get the positions
        //     err => reject(err)
        // );
        navigator.geolocation.getCurrentPosition(resolve, reject);
    })
}

// getPosition().then(pos => console.log(pos));

const whereAmI = function () {
    getPosition().then(pos => {
            const {
                latitude: lat,
                longitude: long
            } = pos.coords
            return fetch(`https://geocode.xyz/${lat},${long}?geoit=json`)
        })
        .then(res => {
            if (!res.ok) throw new Error(`Problem with Geocoding ${res.status}`)
            return res.json()
        })
        .then(data => {
            // console.log(data);
            console.log(`You are in ${data.city}, ${data.country}`);
            return fetch(`https://restcountries.eu/rest/v2/name/${data.country}`)
        })
        .then(res => {
            if (!res.ok) throw new Error(`Could not foun ${res.status}`);
            return res.json();
        })
        .then(data => renderCountry(data[0]))
        .catch(err => console.log(`${err.message} 🛑`));
}

// btn.addEventListener('click', whereAmI);