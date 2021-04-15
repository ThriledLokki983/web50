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

// const calcAverage = (a, b, c) => (a + b + c) / 3;

// const dolphins = calcAverage(44, 23, 71);
// const koalas = calcAverage(65, 54, 49);

// const dolphins1 = calcAverage(85, 54, 41);
// const koalas1 = calcAverage(23, 34, 27);

// const checkWinner = (team1Score, team2Score) => team1Score >= (team2Score * 2) ? `Dolphins win (${team1Score + " vs. " + team2Score})` : `Koalas win (${team2Score + " vs. " + team1Score})`;

// const checkWinner1 = (team1Score, team2Score) => {
//   if ((team1Score >= (team2Score * 2))) {
//     console.log(`Dolphins win (${team1Score + " vs. " + team2Score})`);
//   } else if ((team2Score >= (team1Score * 2))) {
//     console.log(`Koalas win (${team2Score + " vs. " + team1Score})`);
//   } else {
//     console.log(`No team wins`);
//   }
// }

// console.log(checkWinner(dolphins, koalas));
// console.log(checkWinner(dolphins1, koalas1));
// checkWinner1(dolphins, koalas);
// checkWinner1(dolphins1, koalas1);

// ARRAYS:

// const friends = ["Gideon", "Kwame", "Jonas"];
// console.log(friends);
// console.log(friends.length);
// console.log(friends.reverse());
// console.log(friends[friends.length - 1]);

// const calcAge = (birthYear) => 2037 - birthYear;
// const years = [1990, 1967, 2002, 2010, 2018];

// const age1 = calcAge(years[0]);
// const age2 = calcAge(years[1]);
// const age3 = calcAge(years[2]);
// const age4 = calcAge(years[3]);
// const age5 = calcAge(years[years.length - 1]);
// console.log(age1, age2, age3, age4, age5);

// const ages = [calcAge(years[0])];
// console.log(ages);

// for (let i = 0; i < years.length; i++) {
//   const newLength = ages.push(calcAge(years[i]));
//   const another = ages.unshift(newLength);
//   ages.unshift(another);
// }
// console.log(ages);
// console.log(ages.pop()); // delete from the end
// console.log(ages.shift()); // delete from beginning
// console.log(ages.indexOf(19));
// console.log(ages.includes(27));

// CHALLENGE

// const calcTip = (bill) => ((bill >= 50) && (bill <= 300)) ? bill * 0.15 : bill * 0.20;
// const calcTotal = (bill) => calcTip(bill) + bill;

// console.log(calcTotal(100));

// const bill = [125, 555, 44];
// let tips = [];
// let total = [];

// for (let i = 0; i < bill.length; i++) {
//   tips.push(calcTip(bill[i]));
//   total.push(calcTotal(bill[i]));
// }
// console.log(tips);
// console.log(total);

// Objects

// const object = {
//   firstName: 'Gideon',
//   lastName: 'Nimoh',
//   age: 31,
//   job: 'App Support Analyst',
//   friends: ['Michael', 'Peter', 'Steven', 'John', 'Adam']
// };

// const nameKey = 'Name';

// object.location = 'Netherlands'
// object['twitter'] = '@nimoh_gideon'
// console.log(object);

// console.log(`${object.firstName} has ${object.friends.length} friends, and his best friend is ${object.friends[0]}`)

// const ans = prompt('Make a choice: ');
// if (object[ans]) {
//   console.log(object[ans])
// } else {
//   console.log("Invalid")
// };

const object = {
  firstName: 'Gideon',
  lastName: 'Nimoh',
  birthYear: 1990,
  job: 'App Support Analyst',
  friends: ['Michael', 'Peter', 'Steven', 'John', 'Adam'],
  hasDriversLicense: true,

  //calcAge: () => this.age = 2037 - this.birthYear, //Method of an object
  calcAge1: function () {
    this.age = 2037 - this.birthYear;
    return this.age;
  },

  getSummary: function () {
    return `${this.firstName} is a ${this.calcAge1()}-year old ${this.job} and has ${this.hasDriversLicense ? 'a' : 'no'} driver's licence.`;
  }
};

console.log(object.getSummary());