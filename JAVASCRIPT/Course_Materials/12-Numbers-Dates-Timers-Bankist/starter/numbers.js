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

console.log('----------- Remainder Operations -----------')

console.log(5 % 2);
console.log(5 / 2); // 5 = 2 * 2 + 1



// BIGINT
console.log('----------- BIGINT Operations -----------')
console.log(2 ** 53 - 1)
console.log(Number.MAX_SAFE_INTEGER); // Largest positive Number

console.log(457937927302475802748970249075983947283923802479232);
console.log(457937927302475802748970249075983947283923802479232n);
console.log(BigInt(45793792730247580274897024907598394728398698957867923802479232));

console.log(1000n + 1999n);
console.log(1879086870n * 7569087875679n); // Cannot mix BigInt with other types

// Exceptions for BigInt
console.log(20n > 15);
console.log(20n === 20); // will not work bcos the strict equal operator does not do type cohersion
console.log(typeof 20n);
console.log(20n == 20);
console.log(20n == '20');


// Division

console.log(14n / 3n);
console.log(10 / 3);



// CREATING DATES AND TIMES
// Createa a date == 4 ways to do it with new Date

const now = new Date(); // 1
console.log(now);

// Parsing a date from a date string
console.log(new Date('Apr 22 2021 15: 05: 25')); // 2
console.log(new Date('January 13, 1990')); // this can be quite unreliable unless created by javascript itself
// console.log(new Date(account1.movementsDates[0]));

console.log(new Date(1990, 0, 13, 15, 23, 5))
console.log(new Date(1990, 0, 33))

console.log('===============================')
console.log(new Date(0));
console.log(new Date(3 * 24 * 60 * 60 * 1000)); //convert days into milliseconds

console.log('===============================')
// WOrking with DATES
const future = new Date(2037, 10, 19, 15, 23);
console.log(future);
console.log(future.getFullYear());
console.log(future.getMonth());
console.log(future.getDate()); // day of the Month
console.log(future.getDay()); // day of week (sun-0, mon-1, tues-2, wed-3, thurs-4, fri-5, sat-6)
console.log(future.getHours());
console.log(future.getMinutes());
console.log(future.getSeconds());
console.log(future.toISOString()); // very useful conver date and store somewhere
console.log(future.getTime()); // time passed since 1970


console.log(new Date(2142253380000));

console.log(Date.now());
console.log(new Date(Date.now()));

future.setFullYear(2040);
console.log(future);
console.log('....')
console.log('....')
console.log('....')
console.log('....')
console.log('....')
console.log('....')
console.log('....')
console.log('....')
console.log('....')
console.log('....')
console.log('....')
console.log('....')
console.log('....')


// DOing calculations with dates
const future1 = new Date(2037, 3, 14);
const future2 = new Date(2037, 3, 14);
console.log(+future);

// A function that takes 2 dates and return the difference btn the two dates
const calcDaysPassed = (date1, date2) => Math.abs(date2 - date1) / (1000 * 60 * 60 * 24);
const days = calcDaysPassed(future1, future2)
console.log(days);


// Internationalization API
const num = 4986.34;

const options = {
	style: 'unit', // percent, currency
	unit: 'mile-per-hour', // celcius
	// useGrouping: false
}

console.log('US:  ', new Intl.NumberFormat('en-US', options).format(num));
console.log('DE:  ', new Intl.NumberFormat('de-DE', options).format(num));
console.log('AR:  ', new Intl.NumberFormat('ar-SY').format(num));
console.log(navigator.language, new Intl.NumberFormat(navigator.language).format(num));



// TIMERS / SET-TIMEOUT / SET-INTERVAL in JAVASCRIPT
setTimeout(() => console.log(`Here is your pizza 🍕`), 3000) // callback func is the first argument for the timeOut method
// console.log('Waiting...')

// Passing in arguments to the timeout func
// const ing = ['olives', 'spinach']
// setTimeout((arg1, arg2) => console.log(`Here is your pizza with ${arg1} and ${arg2} 🍕`), 5000, 'olives', 'spinach')
// console.log('Waiting...');

const ing = ['olives', 'spinach']
const pizza = setTimeout((arg1, arg2) => console.log(`Here is your pizza with ${arg1} and ${arg2} 🍕`), 5000, ...ing)
console.log('Waiting...');

if (ing.includes('lettuce')) {
	clearTimeout(pizza);
}

// setTimeout
setInterval(function () {
	const now = new Date();
	const min = now.getMinutes();
	const sec = now.getSeconds();
	console.log(`${now.getHours()}:${now.getMinutes()}:${sec}`);
}, 1000);







/////////////