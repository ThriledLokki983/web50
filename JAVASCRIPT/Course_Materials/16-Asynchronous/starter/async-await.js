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
    } catch (err) {
        console.log(err.message);
        renderError(`${err.message}`);
    }
}
whereIam();
whereIam();
whereIam();
whereIam();
whereIam();
whereIam();
console.log("called first")