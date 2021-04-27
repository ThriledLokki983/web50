'use strict';

// only about consuming promises
const whereIam = async function () {
  try {
    // Geolocation
    const pos = await getPosition();
    const { latitude: lat, longitude: lng } = pos.coords;

    // Reverse Geocoding
    const resGeo = await fetch(`https://geocode.xyz/${lat},${lng}?geoit=json`);
    if (!resGeo.ok) throw new Error(`Problem getting location data`);
    const dataGeo = await resGeo.json();
    // console.log(dataGeo);

    // Country data
    const res = await fetch(
      `https://restcountries.eu/rest/v2/name/${dataGeo.country}`
    );
    if (!res.ok) throw new Error(`Problem getting country`);
    const data = await res.json();
    // console.log(data);
    renderCountry(data[0]); // renderCountry in in script.js
    return `You are in ${dataGeo.city}, ${dataGeo.country}`; // the resolved value of the promise
  } catch (err) {
    renderError(`${err.message}`);

    // reject promise from async function
    throw err;
  }
};
// console.log(`1: Will get location`);
// const city = whereIam();
// console.log(city);
// whereIam()
//     .then(city => console.log(`2: ${city}`))
//     .catch(err => console.log(`2: ${err.message}`))
//     .finally(() => console.log(`3: Finished getting location`));

// (async function () {
//     try {
//         const city = await whereIam();
//         console.log(`2: ${city}`);
//     } catch (err) {
//         console.log(`2: ${err.message}`);
//     }
//     console.log(`3: Finished getting location`);
// })();

const get3Countries = async function (c1, c2, c3) {
  try {
    // const [data1] = await getJSON(`https://restcountries.eu/rest/v2/name/${c1}`);
    // const [data2] = await getJSON(`https://restcountries.eu/rest/v2/name/${c2}`);
    // const [data3] = await getJSON(`https://restcountries.eu/rest/v2/name/${c3}`);

    // This will short circuit when one promise rejects
    const data = await Promise.all([
      // receives an array and returns an array
      getJSON(`https://restcountries.eu/rest/v2/name/${c1}`),
      getJSON(`https://restcountries.eu/rest/v2/name/${c2}`),
      getJSON(`https://restcountries.eu/rest/v2/name/${c3}`),
    ]);

    // console.log([data1.capital, data2.capital, data3.capital]);
    // console.log(data);
    console.log(data.map(d => d[0].capital));
  } catch (err) {
    console.log(err.message);
  }
};
get3Countries('ghana', 'portugal', 'netherlands');
