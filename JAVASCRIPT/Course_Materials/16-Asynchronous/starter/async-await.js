'use strict';

// only about consuming promises
const whereIam = async function () {
    try { // Geolocation
        const pos = await getPosition();
        const {
            latitude: lat,
            longitude: lng
        } = pos.coords;

        // Reverse Geocoding
        const resGeo = await fetch(`https://geocode.xyz/${lat},${lng}?geoit=json`);
        if (!resGeo.ok) throw new Error(`Problem getting location data`);
        const dataGeo = await resGeo.json();
        // console.log(dataGeo);

        // Country data
        const res = await fetch(`https://restcountries.eu/rest/v2/name/${dataGeo.country}`);
        if (!res.ok) throw new Error(`Problem getting country`);
        const data = await res.json();
        // console.log(data);
        renderCountry(data[0]) // renderCountry in in script.js
        return `You are in ${dataGeo.city}, ${dataGeo.country}`; // the resolved value of the promise
    } catch (err) {
        renderError(`${err.message}`);

        // reject promise from async function
        throw err;
    }
}
console.log(`1: Will get location`);
// const city = whereIam();
// console.log(city);
// whereIam()
//     .then(city => console.log(`2: ${city}`))
//     .catch(err => console.log(`2: ${err.message}`))
//     .finally(() => console.log(`3: Finished getting location`));

(async function () {
    try {
        const city = await whereIam();
        console.log(`2: ${city}`);
    } catch (err) {
        console.log(`2: ${err.message}`);
    }
    console.log(`3: Finished getting location`);
})();