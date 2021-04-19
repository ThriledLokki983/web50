'use strict';

const restaurant = {
  name: 'Classico Italiano',
  location: 'Via Angelo Tavanti 23, Firenze, Italy',
  categories: ['Italian', 'Pizzeria', 'Vegetarian', 'Organic'],
  starterMenu: ['Focaccia', 'Bruschetta', 'Garlic Bread', 'Caprese Salad'],
  mainMenu: ['Pizza', 'Pasta', 'Risotto'],

  openingHours: {
    thu: {
      open: 12,
      close: 22,
    },
    fri: {
      open: 11,
      close: 23,
    },
    sat: {
      open: 0, // Open 24 hours
      close: 24,
    },
  },

  order: function (starterIndex, mainIndex) {
    return [this.starterMenu[starterIndex], this.mainMenu[mainIndex]]
  },

  orderDelivery: function ({
    starterIndex,
    mainIndex,
    time,
    address
  }) {
    console.log(`Order Received: ${this.starterMenu[starterIndex]} - Starter
    ${this.mainMenu[mainIndex]} - Main
    will be delivered to ${address}
    at ${time}`);
  },

  orderPasta: function (ing1, ing2, ing3) {
    console.log(`Here is your delicious pasta with ${ing1}, ${ing2} and ${ing3}`);
  },

  orderPizza: function (mainIngredients, ...otherIngredients) {
    console.log(mainIngredients);
    console.log(otherIngredients);
  },
};


const airline = 'TAP Air Portugal';
const plane = 'A320';

console.log(plane.length);
console.log('B087H'.length);

console.log(airline.indexOf('r')); // first occurrence of a char
console.log(airline.lastIndexOf('r')); // last occurrence of a char


console.log(airline.slice(8)); // Starting parameter
console.log(airline.slice(4, 7)); // declare a start and end parameter

// When we do not know the string Received
console.log(airline.slice(0, airline.indexOf(' ')));
console.log(airline.slice(airline.lastIndexOf(' ') + 1));

console.log(airline.slice(-2));
console.log(airline.slice(1, -1));

const checkMiddleSeat = function (seat) {
const s = seat.slice(-1);
s === 'B' || s === 'E' ? console.log('You got the Middle Seat 😬') : console.log('You got luck 😏')
}
checkMiddleSeat('11B');
checkMiddleSeat('23C');
checkMiddleSeat('3E');

console.log(airline.toUpperCase());
console.log(airline.toLowerCase());

// Fix Capitalization in name
const passenger = 'gIdeOn';
const passengerLower = passenger.toLowerCase();
const passengerCorrect = passengerLower[0].toUpperCase()+passengerLower.slice(1);
console.log(passengerCorrect);

const correctPasshengerName = function (string){
  let stringLower = string.toLowerCase();
  return stringLower[0].toUpperCase()+stringLower.slice(1);
}

console.log(correctPasshengerName('jOnAS'))

// comparing user input email
const email = 'hello@gideon.io';
const loginEmail = ' HelLo@GideON.Io \n';

const checkEmail = function (string) {
  const email = 'hello@gideon.io';
  let emailString = string.toLowerCase().trim();
  console.log(email === emailString);
}

checkEmail(' HelLo@GideON.Io \n');


// Replacing parts of String
const priceGB = '288,97£'
const priceUS = priceGB.replace('£', '$').replace(',', '.');
console.log(priceUS);

const announcement = 'All passengers should come to boarding door 23. Boarding door 23!';
console.log(announcement.replaceAll('door', 'gate'));

// Booleans
const plane1 = 'Airbus A320neo';
console.log(plane1.includes('A320'));
console.log(plane1.includes('Boeing'));
console.log(plane1.startsWith('Airb'));

if (plane1.startsWith('Airbus') && plane1.endsWith('neo')) {
  console.log('Indeed, it is part of the Airbus Family of Planes')
}


// SPlit and Join

console.log('a+very+nice+string'.split('+')); // returns an array of strings
console.log('Gideon Nimoh'.split(' '));
const [firstName, lastName] = 'Gideon Nimoh'.split(' ');
console.log(firstName, lastName);
const newName = ['Mr', firstName, lastName.toUpperCase()].join(' ');
console.log(newName);

const capitalizeName = function (name){
  const names = name.split(' ');
  let namesCap = [];
  for(let n of names){
    // namesCap.push(n[0].toUpperCase() + n.slice(1));
    namesCap.push(n.replace(n[0], n[0].toUpperCase())) // Another way of doing it
  }
  console.log(namesCap.join(' '));
}

capitalizeName('jessica ann smith davies')
capitalizeName('gidoen agyin nimoh')

const padding = 'Go to gate 23';
console.log(padding.padStart(25, '+').padEnd(30, '+'));
console.log('gideon'.padStart(25, '+')); // length of the entire string and the padding element
console.log('Kwame'.padEnd(25, '+'));

const maskCreditcard = function (cardNumber) {
  const str = String (cardNumber); // cardNumber + '';
  const last4 = str.slice(-4);
  return last4.padStart(str.length, '*')
}

console.log(maskCreditcard(123456789123456));
console.log(maskCreditcard('457827648567365'))


// Repeat Method for string // repeat the same string multiple times

const repeat = 'Bad weather... All Departures Delayed -- \n';
console.log(repeat.repeat(5))

const planesInLine = function (n) {
  console.log(`There are ${n} planes in line ${'✈️'.repeat(n)}`);
}

planesInLine(5);
planesInLine(12);
