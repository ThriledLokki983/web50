'use strict';

/*
let hasDriversLicense = false;
const passTest = true;

if (passTest) hasDriversLicense = true;
if (hasDriversLicense) {
  console.log('I can drive :D');
}

// Functions

function logger() {
  console.log("hello, world to functions");
  console.log(56 * 56);
}
logger();

function fruitProcessor(apples, oranges) {
  console.log(apples, oranges);
  const juice = `Juice with ${apples} apples and ${oranges} oranges`;
  return juice;
}
let appleJuice = fruitProcessor(5, 2);
console.log(appleJuice);

const num = Number('23');

FUNCTIONS 

function calcAge(birthYear) {
  return 2037 - birthYear;
}

console.log(calcAge(1990))

let calcAge1 = function (birthYear) {
  return 2037 - birthYear;
}
*/

// let calcAge3 = birthYear => 2037 - birthYear;
// console.log(calcAge3(1990))

// const yearUntilRetirement = (birthYear, firstName) => {
//   return `${firstName} retires in ${65 - (2021 - birthYear)} years`;
// }

// console.log(yearUntilRetirement(1990, "Gideon"));
// console.log(yearUntilRetirement(2007, "John"));

let cutFruit = (fruit) => {
  return fruit * 4;
}

function fruitProcessor(apples, oranges) {
  const applePieces = cutFruit(apples);
  const orangePieces = cutFruit(oranges);
  console.log(apples, oranges);
  console.log(applePieces, orangePieces);
  const juice = `Juice with ${applePieces} apples and ${orangePieces} oranges`;
  return juice;
}