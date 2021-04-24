'use strict';

const Person = function (name, year) {
  this.name = name;
  this.year = year;
};

const per = new Person('Gideon', 1991);
console.log(per);

// 1. New {} is created
// 2. function is called, this = {}
// 3. {} linked to a prototype
// 4. function automatically returns the {} from the beginning
