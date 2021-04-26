// 'use strict';
const btn = document.querySelector('.btn-country');
const countriesContainer = document.querySelector('.countries');


// const getCountryData = function (country) {
//     const btn = document.querySelector('.btn-country');
//     const countriesContainer = document.querySelector('.countries');

//     ///////////////////////////////////////

//     // Old-school way of doing AJAX call 
//     const request = new XMLHttpRequest();
//     request.open('GET', `https://restcountries.eu/rest/v2/name/${country}`);
//     // data = request.send(); cannot do this because the data is not there yet
//     request.send();

//     request.addEventListener('load', function () {
//         // console.log(this.responseText); // JSON
//         const [data] = JSON.parse(this.responseText);
//         console.log(data);

//         const html = `
//     <article class="country">
//     <img class="country__img" src="${data.flag}" />
//     <div class="country__data">
//       <h3 class="country__name">${data.name}</h3>
//       <h4 class="country__region">${data.region}</h4>
//       <p class="country__row"><span>👫</span>${(+data.population/1000000).toFixed(1)}M people </p>
//       <p class="country__row"><span>🗣️</span>${data.languages[0].name}</p>
//       <p class="country__row"><span>💰</span>${data.currencies[0].name}</p>
//     </div>
//   </article>`;
//         countriesContainer.insertAdjacentHTML('beforeend', html);
//         countriesContainer.style.opacity = 1;
//     });
// };

// // getCountryData('netherlands');
// // getCountryData('usa');
// getCountryData('ghana');

//! 2nd Part

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
    countriesContainer.style.opacity = 1;
}

// const getCountryAndNeighbour = function (country) {

//     // AJAX call country (1)
//     const request = new XMLHttpRequest();
//     request.open('GET', `https://restcountries.eu/rest/v2/name/${country}`);
//     request.send();

//     request.addEventListener('load', function () {
//         const [data] = JSON.parse(this.responseText);
//         console.log(data);
//         // Render the country
//         renderCountry(data);

//         // Get neighbour country  (2)
//         const [neighbour] = data.borders;

//         if (!neighbour) return;

//         // AJAX call (2)
//         const request2 = new XMLHttpRequest();
//         request2.open('GET', `https://restcountries.eu/rest/v2/alpha/${neighbour}`);
//         request2.send();

//         request2.addEventListener('load', function () {
//             const data1 = JSON.parse(this.responseText);
//             console.log(data1)

//             renderCountry(data1, 'neighbour');
//         })
//     });
// };

// getCountryAndNeighbour('mexico');

fetch()