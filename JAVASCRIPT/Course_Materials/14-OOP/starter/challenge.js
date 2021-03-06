'use strict';

const Car = function (make, speed) {
  this.make = make;
  this.speed = speed;
};

Car.prototype.accelerate = function () {
  this.speed += 10;
  console.log(`${this.speed}km/h`);
  return this;
};

Car.prototype.break = function () {
  this.speed -= 5;
  console.log(`${this.speed}km/h`);
  return this;
};

const bmw = new Car('BMW', 120);
const mercedes = new Car('Mercedes', 95);

bmw.accelerate();
bmw.break();

mercedes.accelerate();
mercedes.break();

////////////////////////////////////////////////
//TODO -- CHALLENGE-2
class Car1 {
  constructor(make, speed) {
    this.make = make;
    this.speed = speed;
  }

  accelerate() {
    this.speed += 10;
    console.log(`Speed: ${this.speed}km/h`);
  }

  break () {
    this.speed -= 5;
    console.log(`Break: ${this.speed}km/h`);
    return this;
  }

  get speedUS() {
    return `SpeedUS: ${Math.trunc(this.speed / 1.6)}m/h`;
  }

  set speedUS(speed) {
    this.speed = speed * 1.6;
  }
}

const ford = new Car1('Ford', 120);
// const mercedes1 = new Car1('Mercedes', 95);
console.log(ford.speedUS);
ford.accelerate();
ford.accelerate();
ford.break();
ford.accelerate();
console.log(ford.speedUS);
ford.speedUS = 50;
console.log(ford);

//TODO: CHALLENGE-3

const Ev = function (make, speed, charge) {
  Car.call(this, make, speed);
  this.charge = charge;
}

// Link the prototype of Car to Ev
Ev.prototype = Object.create(Car.prototype);

Ev.prototype.chargeBatteryTo = function (chargeTo) {
  this.charge = chargeTo;
}

Ev.prototype.accelerate = function () {
  this.speed += 20;
  this.charge--;

  console.log(`${this.make} going at ${this.speed}km/h, with a charge of ${Math.trunc(this.charge)}%`);
}

const tesla = new Ev('Tesla', 120, 23);
console.log(tesla);
tesla.accelerate();
console.log(tesla);
tesla.break();
console.log(tesla);
tesla.chargeBatteryTo(90);
console.log(tesla);
tesla.accelerate();



/// Unisng The ES6 method 

class Evcl extends Car1 {

  constructor(make, speed, charge) {
    super(make, speed);
    this._charge = charge;
  }

  accelerate() {
    this.speed += 20;
    this._charge--;

    console.log(`${this.make} going at ${this.speed}km/h, with a charge of ${this._charge}%`);
    return this;
  }

  chargeBatteryTo(chargeTo) {
    this._charge = chargeTo;
    return this;
  }
}


const evcl = new Evcl('Rivian', 120, 23);
console.log(evcl);
evcl.accelerate().accelerate().accelerate().break().break().chargeBatteryTo(50).break().accelerate();
console.log(evcl.speedUS);