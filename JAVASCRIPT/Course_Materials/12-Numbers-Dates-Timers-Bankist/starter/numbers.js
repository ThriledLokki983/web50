'use strict';

console.log(23 === 23.0); // Numbers are stored in binary form in the computer's memory

// Base 10:  0 - 9
// Binary base 2: 0 - 1

console.log(0.1 + 0.2);

console.log(Number('23'));
console.log(+'23');

// Parsing
console.log(Number.parseInt('30px')); // only can parse string thatn befin with a number
console.log(Number.parseInt('30px', 10));

console.log(Number.parseInt(' 2.5rem')); // These are globale functions
console.log(Number.parseFloat(' 2.5rem'));

console.log(Number.isNaN(20))
console.log(Number.isNaN('20'))
console.log(Number.isNaN('20px'))
console.log(Number.isNaN(+'20px'))
console.log(Number.isNaN(20 / 0))

console.log('---------------------------')
console.log(Number.isFinite(20)); // The best option/ultimate method to check for a real number
console.log(Number.isFinite('20'))
console.log(Number.isFinite(+'20px'))
console.log(Number.isFinite(20 / 0))


console.log('---------------------------')
console.log(Number.isInteger(20));
console.log(Number.isInteger('20'));
console.log(Number.isInteger(+'20px'));
console.log(Number.isInteger('20px'));

console.log('---------------------------')

// MATH OPERATIONS
console.log(Math.sqrt(25));
console.log(25 ** (1 / 2));

console.log(Math.max(5, 18, 23, 6, 8, 9, 10));
console.log(Math.max(5, 18, '23', 6, 8, 9, 10)); // Type cohersion but not parsing

console.log(Math.min(5, 18, 23, 6, 8, 9, 10, 2));
console.log(Math.PI * Number(parseFloat('10px') ** 2)); // calc the radius

console.log(Math.trunc(Math.random() * 6) + 1);

const randomInt = (min, max) => Math.floor(Math.random() * (max - min) + 1) + min; // random number between a specified range of numbers
console.log('----------------------')
console.log(randomInt(10, 20));
console.log(randomInt(10, 20));
console.log(randomInt(10, 20));
console.log(randomInt(10, 20));
console.log(randomInt(10, 20));
console.log(randomInt(10, 20));

console.log('----------------------')
// Rounding Integers
console.log(Math.round(23.3));
console.log(Math.round(23.6));
console.log(Math.round(23.7));
console.log('----------------------')
console.log(Math.ceil(23.7));
console.log(Math.ceil(23.3));
console.log('----------------------')
console.log(Math.floor(23.3));
console.log(Math.floor(23.9));
console.log('----------------------')

// Floating points // Decimals
console.log(+(2.3).toFixed(0));








/////////////