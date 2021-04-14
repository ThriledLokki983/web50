'use strict';

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