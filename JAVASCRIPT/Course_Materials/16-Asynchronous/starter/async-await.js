'use strict';

// only about consuming promises
const whereIam = async function () {
    // fetch(`https://restcountries.eu/rest/v2/name/${country}`).then(res => console.log(res));

    // Geolocation
    const pos = await getPosition();
    const {
        latitude: lat,
        longitude: lng
    } = pos.coords;

    // Reverse Geocoding
    const resGeo = await fetch(`https://geocode.xyz/${lat},${lng}?geoit=json`);
    const dataGeo = await resGeo.json();
    // console.log(dataGeo);

    // Country data
    const res = await fetch(`https://restcountries.eu/rest/v2/name/${dataGeo.country}`);
    const data = await res.json();
    // console.log(data);
    renderCountry(data[0]) // renderCountry in in script.js
}
whereIam();
console.log("called first")