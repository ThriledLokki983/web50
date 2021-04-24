const Car = function (make, speed) {
  this.make = make;
  this.speed = speed;
};

Car.prototype.accelerate = function () {
  console.log(`${this.speed * 10}km/h`);
};

Car.prototype.break = function () {
  console.log(`${this.speed - 5}km/h`);
};

const bmw = new Car('BMW', 120);
const mercedes = new Car('Mercedes', 95);

bmw.accelerate();
bmw.break();

mercedes.accelerate();
mercedes.break();
