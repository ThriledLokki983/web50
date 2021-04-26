'use strict';

// Create a function whereAmI which takes inputs lat & lng 
// let info = [];
// const getMyPosition = function () {
//     navigator.geolocation.getCurrentPosition(pos => {
//         const {
//             latitude,
//             longitude
//         } = pos.coords;
//         info.push(latitude);
//         info.push(longitude);
//         return info;
//         // console.log(latitude, longitude);
//     }, function () {
//         alert('location not found')
//     });
// }
// console.log(getMyPosition());

// const getPos = function (url, errMsg = 'Please wait 3sec before reload') {
//     return fetch(url).then(response => {
//         if (response.status === 403) throw new Error(`${errMsg} (${response.status})`)
//         return response.json();
//     })
// }

// const whereAmI = function (lat, lng) {
//     getPos(`https://geocode.xyz/${lat},${lng}?geoit=json`)
//         .then(data => console.log(`You are in ${data.city}, ${data.country}`))
//         .catch(err => {
//             console.error(`${err}: Position not found`);
//         })
//         .finally(() => {})
// }

// whereAmI(53.198498199999996, 6.584374599999999);
// whereAmI(52.508, 13.381);
// whereAmI(19.037, 72.873);
// whereAmI(-33.933, 18.474);

const whereAmI = function (lat, long) {
    fetch(`https://geocode.xyz/${lat},${long}?geoit=json`)
        .then(res => {
            if (!res.ok) throw new Error(`Problem with Geocoding ${res.status}`)
            return res.json()
        })
        .then(data => {
            console.log(data);
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

whereAmI(52.508, 13.381);
whereAmI(19.037, 72.873);
whereAmI(-33.933, 18.474);