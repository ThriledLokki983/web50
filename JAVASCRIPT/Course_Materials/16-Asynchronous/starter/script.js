// 'use strict';
const btn = document.querySelector('.btn-country');
const countriesContainer = document.querySelector('.countries');

//! 2nd Part

const renderError = function (err) {
    countriesContainer.insertAdjacentText('beforeend',
        err);
    // countriesContainer.style.opacity = 1;
}

const getJSON = function (url, errMsg = 'Something went wrong') {
    return fetch(url).then(response => {
        if (!response.ok)
            throw new Error(`${errMsg}, (${response.status})`);
        return response.json();
    });
}

const renderCountry = function (data, className = '') {
    const html = `
    <article class="country ${className}">
    <img class="country__img" src="${data.flag}" />
    <div class="country__data">
      <h3 class="country__name">${data.name}</h3>
      <h4 class="country__region">${data.region}</h4>
      <p class="country__row"><span>👫</span>${(+data.population/1000000).toFixed(1)}M people </p>
      <p class="country__row"><span>🗣️</span>${data.languages[0].name}</p>
      <p class="country__row"><span>💰</span>${data.currencies[0].name}</p>
    </div>
  </article>`;
    countriesContainer.insertAdjacentHTML('beforeend', html);
    // countriesContainer.style.opacity = 1;
}


const getCountryData = function (country) {
    // Country (1)
    getJSON(`https://restcountries.eu/rest/v2/name/${country}`, 'Country Not found')
        .then(data => {
            renderCountry(data[0]);
            const neighbour = data[0].borders[0];
            if (!neighbour) throw new Error('No neighbouring country');
            // Country (2)
            return getJSON(`https://restcountries.eu/rest/v2/alpha/${neighbour}`, 'Country not found');
        })
        .then(data => renderCountry(data, 'neighbour'))
        .catch(err => {
            console.error(`${err} 🔥🔥🔥`);
            renderError(`✋🏽- ${err.message}.`)
        })
        .finally(() => {
            countriesContainer.style.opacity = 1;
        });
};

btn.addEventListener('click', function () {
    getCountryData('ghana');
});