'use strict';

const Person = function (name, year) {
  // Instance Properties
  this.name = name;
  this.year = year;

  // Never create a method inside a constructor function - if not, every instance will be carrying around this method with this as soon as they are created
  this.calcAge = function () {
    console.log(2037 - this.year);
  };
};

const per = new Person('Gideon', 1991);
const mat = new Person('Matilda', 2003);
const pat = new Person('Patricia', 1995);
console.log(per);
console.log(mat);
console.log(pat);
console.log(pat instanceof Person);

// 1. New {} is created
// 2. function is called, this = {}
// 3. {} linked to a prototype
// 4. function automatically returns the {} from the beginning
