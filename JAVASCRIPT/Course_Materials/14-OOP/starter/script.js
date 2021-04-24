'use strict';

const Person = function (name, year) {
  // Instance Properties
  this.name = name;
  this.year = year;

  //? Check Notes -- Something very important there
};

const per = new Person('Gideon', 1991);
const mat = new Person('Matilda', 2003);
const pat = new Person('Patricia', 1995);
console.log(per);
console.log(mat);
console.log(pat);
console.log(pat instanceof Person);

// Prototypes
Person.prototype.calcAge = function () {
  console.log(2037 - this.year);
};

console.log(Person.prototype);

per.calcAge();
pat.calcAge();
console.log(per.__proto__);
console.log(per.__proto__ === Person.prototype);
console.log(Person.prototype.isPrototypeOf(per));
console.log(Person.prototype.isPrototypeOf(Person));
