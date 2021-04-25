'use strict';

// prettier-ignore
const months = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];

const form = document.querySelector('.form');
const containerWorkouts = document.querySelector('.workouts');
const inputType = document.querySelector('.form__input--type');
const inputDistance = document.querySelector('.form__input--distance');
const inputDuration = document.querySelector('.form__input--duration');
const inputCadence = document.querySelector('.form__input--cadence');
const inputElevation = document.querySelector('.form__input--elevation');

let map;
let mapEvent;

class App {
    constructor() {

    }

    _getPosition() {

    }

    _loadMap() {

    }

    _showForm() {

    }

    _toggleElevationField() {

    }

    _newWorkOut() {

    }
}

navigator.geolocation && navigator.geolocation.getCurrentPosition(function (pos) {
    const {
        latitude
    } = pos.coords;
    const {
        longitude
    } = pos.coords;
    // console.log(pos.coords);
    // console.log(`https://www.google.com/maps/@${latitude},${longitude}`);
    const coords = [latitude, longitude];

    map = L.map('map').setView(coords, 15);
    // console.log(map);

    L.tileLayer('https://{s}.tile.openstreetmap.fr/hot/{z}/{x}/{y}.png', {
        attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(map);

    // Handleclick on map
    map.on('click', function (mapE) {
        mapEvent = mapE;
        form.classList.remove('hidden');
        inputDistance.focus();
    })

}, function () {
    alert('Could not get your location')
});

form.addEventListener('submit', function (e) {
    e.preventDefault();

    //Clear input fields
    inputDistance.value = inputDuration.value = inputElevation.value = inputElevation.value = '';


    // Display Marker 
    const {
        lat,
        lng
    } = mapEvent.latlng;

    L.marker([lat, lng])
        .addTo(map)
        .bindPopup(L.popup({
            maxWidth: 250,
            minWidth: 100,
            autoClose: false,
            closeOnClick: false,
            className: 'running-popup',
        }))
        .setPopupContent('Workout')
        .openPopup();
});

inputType.addEventListener('change', function () {
    inputElevation.closest('.form__row').classList.toggle('form__row--hidden');
    inputCadence.closest('.form__row').classList.toggle('form__row--hidden');
})