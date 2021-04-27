'use strict';

const whereIam = async function (country) {
    await fetch(`https://restcountries.eu/rest/v2/name/${country}`);
}