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

class Workout{
    date = new Date();
    id = (Date.now() + 1 + '').slice(-10);

    constructor(coords, distance, duration){
        this.coords = coords; // [lattitude, longitude]
        this.distance = distance; // in km
        this.duration = duration; // in minutes
    }
}

class Running extends Workout{
    constructor(coords, distance, duration, cadense){
        super(coords, distance, duration);
        this.cadense = cadense;

        this.calcPace();
    }

    calcPace(){
        // min/km
        this.pace = this.duration / this.distance;
        return this.pace;
    }
}

class Cycling extends Workout{
    constructor(coords, distance, duration, elevationGained){
        super(coords, distance, duration);
        this.elevationGained = elevationGained;

        this.calcSpeed();
    }

    calcSpeed(){
    // km/h
        this.speed = this.distance / (this.duration / 60);
        return this.speed;
    }
}

// const run1 = new Running([36, 45], 5.3, 24, 178);
// const cycl1 = new Cycling([36, 45], 15, 87, 569);
// console.log(run1);
// console.log(cycl1);



///////////////////////////////////////////////////////////////////
//! APPLICATION ARCHITECTURE

class App {
    #map;
    #mapEvent;

    constructor() {
        this._getPosition();
        form.addEventListener('submit', this._newWorkOut.bind(this));
        inputType.addEventListener('change', this._toggleElevationField);
    }

    _getPosition() {
        navigator.geolocation && navigator.geolocation.getCurrentPosition(this._loadMap.bind(this), function () {
            alert('Could not get your location')
        });
    }

    _loadMap(pos) {
        const {
            latitude
        } = pos.coords;
        const {
            longitude
        } = pos.coords;

        console.log(this);
        const coords = [latitude, longitude];
        this.#map = L.map('map').setView(coords, 15);

        L.tileLayer('https://{s}.tile.openstreetmap.fr/hot/{z}/{x}/{y}.png', {
            attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
        }).addTo(this.#map);

        // Handleclick on map
        this.#map.on('click', this._showForm.bind(this))
    }

    _showForm(mapE) {
        this.#mapEvent = mapE;
        form.classList.remove('hidden');
        inputDistance.focus();
    }

    _toggleElevationField() {
        inputElevation.closest('.form__row').classList.toggle('form__row--hidden');
        inputCadence.closest('.form__row').classList.toggle('form__row--hidden');
    }

    _newWorkOut(e) {
        e.preventDefault();

        //Clear input fields
        inputDistance.value = inputDuration.value = inputElevation.value = inputElevation.value = '';

        // Display Marker 
        const {
            lat,
            lng
        } = this.#mapEvent.latlng;

        L.marker([lat, lng])
            .addTo(this.#map)
            .bindPopup(L.popup({
                maxWidth: 250,
                minWidth: 100,
                autoClose: false,
                closeOnClick: false,
                className: 'running-popup',
            }))
            .setPopupContent('Workout')
            .openPopup();
    }
}

const app = new App();