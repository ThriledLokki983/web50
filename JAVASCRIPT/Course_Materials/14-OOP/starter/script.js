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

//? You can set other properties other than methods on prototypes which all instances will have access to
Person.prototype.species = 'Homo Sapiens';
console.log(per);
console.log(pat);

console.log(per.hasOwnProperty('name'));
console.log(per.hasOwnProperty('calcAge()'));

//////////////? OBJECT.prototype
console.log(per.__proto__.__proto__);

console.log(Person.prototype.constructor);

const arr = [1, 2, 3, 4, 5];
console.log(arr.__proto__);
console.log(arr.__proto__ === Array.prototype);
console.log(arr.__proto__.__proto__);
