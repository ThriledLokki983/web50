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

// let cutFruit = (fruit) => {
//   return fruit * 4;
// }

// function fruitProcessor(apples, oranges) {
//   const applePieces = cutFruit(apples);
//   const orangePieces = cutFruit(oranges);
//   console.log(apples, oranges);
//   console.log(applePieces, orangePieces);
//   const juice = `Juice with ${applePieces} apples and ${orangePieces} oranges`;
//   return juice;
// }

// const calcAge = (birthYear) => 2037 - birthYear;

// const yearsUntilRetirement = (birthYear, firstName) => `${65 - calcAge(birthYear)}-years until ${firstName} goes on retirement.`;

// console.log(yearsUntilRetirement(1991, 'Gideon'))
// console.log(yearsUntilRetirement(2003, 'Jonas'))

// CHALLENGE:

const calcAverage = (score1, score2, score3) => (score1 + score2 + score3) / 3;

const dolphins = calcAverage(44, 23, 71);
const koalas = calcAverage(65, 54, 49);

const dolphins1 = calcAverage(85, 54, 41);
const koalas1 = calcAverage(23, 34, 27);

const checkWinner = (team1Score, team2Score) => team1Score > team2Score ? `Dolphins win (${team1Score + " vs. " + team2Score})` : `Koalas win (${team2Score + " vs. " + team1Score})`;

const checkWinner1 = (team1Score, team2Score) => {
  if ((team1Score > team2Score) && (team1Score > (team2Score * 2))) {
    console.log(`Dolphins win (${team1Score + " vs. " + team2Score})`);
  } else if ((team2Score > team1Score) && (team2Score > (team1Score * 2))) {
    console.log(`Koalas win (${team2Score + " vs. " + team1Score})`);
  } else {
    console.log(`no Winner`);
  }
}

console.log(checkWinner(dolphins, koalas));
console.log(checkWinner1(dolphins, koalas));
console.log(checkWinner(dolphins1, koalas1));
console.log(checkWinner1(dolphins1, koalas1));