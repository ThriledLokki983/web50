'use strict';


// const months = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];

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

    _setDescription(){
        // prettier-ignore
        const months = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];

        this.description = `${this.type[0].toUpperCase()}${this.type.slice(1)} on ${months[this.date.getMonth()]} ${this.date.getDate()}`
    }
}

class Running extends Workout{
    type = 'running';
    constructor(coords, distance, duration, cadense){
        super(coords, distance, duration);
        this.cadense = cadense;

        this.calcPace();
        this._setDescription();
    }

    calcPace(){
        // min/km
        this.pace = this.duration / this.distance;
        return this.pace;
    }
}

class Cycling extends Workout{
    type = 'cycling'
    constructor(coords, distance, duration, elevationGained){
        super(coords, distance, duration);
        this.elevationGained = elevationGained;

        this.calcSpeed();
        this._setDescription();
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
    #workouts = [];

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

        // console.log(this);
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
        const validateInputs = (...inputs) => inputs.every(inp => Number.isFinite(inp));
        const allPositives = (...inputs) => inputs.every(inp => inp > 0);

        e.preventDefault();

        // Get data from the from
        const type = inputType.value;
        const distance = +inputDistance.value; // converts to number
        const duration = +inputDuration.value;
        const {
            lat,
            lng
        } = this.#mapEvent.latlng;
        let workout;


        // if workout is running, create a running object
        if(type === 'running'){
            const cadence = +inputCadence.value;

            // Check if the data is valid
            if(!validateInputs(distance, duration, cadence) || !allPositives(distance, duration, cadence)) return alert('Input must be a Number');

            workout = new Running([lat, lng], distance, duration, cadence);
        }

        // if workout is cycling, create a cycling object
        if (type === 'cycling') {
            const elevation = +inputElevation.value;

            // Check if the data is valid
            if(!validateInputs(distance, duration, elevation) || !allPositives(distance, duration)) return alert('Input must be a Number');

            workout = new Cycling([lat, lng], distance, duration, elevation);
        }

        // Add new object to workout array
        this.#workouts.push(workout);
        console.log(workout);

        // Render workout on Map master
        this._renderWorkoutMarker(workout);

        // Render workout on list
        this._renderWorkout(workout);

        //Clear input fields
        inputDistance.value = inputDuration.value = inputElevation.value = inputElevation.value = '';

    }

    _renderWorkoutMarker(workout){
        // Display Marker 
        L.marker(workout.coords)
        .addTo(this.#map)
        .bindPopup(L.popup({
            maxWidth: 250,
            minWidth: 100,
            autoClose: false,
            closeOnClick: false,
            className: `${workout.type}-popup`,
        }))
        .setPopupContent("Workout")
        .openPopup();
    }

    _renderWorkout(workout){
        let html = `
        li class="workout workout--${workout.type}" data-id="${workout.id}">
          <h2 class="workout__title">${workout.description}</h2>
          <div class="workout__details">
            <span class="workout__icon">${workout.type === 'running' ? '🏃‍♂️' : '🚴🏾‍♂️'}</span>
            <span class="workout__value">${workout.distance}</span>
            <span class="workout__unit">km</span>
          </div>
          <div class="workout__details">
            <span class="workout__icon">⏱</span>
            <span class="workout__value">${workout.duration}</span>
            <span class="workout__unit">min</span>
          </div>
        `;

        if(workout.type === 'running'){
            html += `
            <div class="workout__details">
            <span class="workout__icon">⚡️</span>
            <span class="workout__value">${workout.pace.toFixed(1)}</span>
            <span class="workout__unit">min/km</span>
          </div>
          <div class="workout__details">
            <span class="workout__icon">🦶🏼</span>
            <span class="workout__value">${workout.cadense}</span>
            <span class="workout__unit">spm</span>
          </div>
        </li>
        `;
        }

        if(workout.type === 'cycling'){
            html += `
            <div class="workout__details">
            <span class="workout__icon">⚡️</span>
            <span class="workout__value">${workout.speed.toFixed(1)}</span>
            <span class="workout__unit">km/h</span>
          </div>
          <div class="workout__details">
            <span class="workout__icon">⛰</span>
            <span class="workout__value">${workout.elevationGained}</span>
            <span class="workout__unit">m</span>
          </div>
        </li> 
        `;

        form.insertAdjacentHTML('afterend', html);
        console.log(workout);
        }
    }
}

const app = new App();