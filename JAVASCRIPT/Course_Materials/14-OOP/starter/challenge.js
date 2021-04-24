'use strict';

const Car = function (make, speed) {
  this.make = make;
  this.speed = speed;
};

Car.prototype.accelerate = function () {
  this.speed += 10;
  console.log(`${this.speed}km/h`);
};

Car.prototype.break = function () {
  this.speed -= 5;
  console.log(`${this.speed}km/h`);
};

const bmw = new Car('BMW', 120);
const mercedes = new Car('Mercedes', 95);

bmw.accelerate();
bmw.break();

mercedes.accelerate();
mercedes.break();
