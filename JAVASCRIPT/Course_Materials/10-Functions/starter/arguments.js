'use-strict';

const flight = 'LH123';
const gideon = {
	name: 'Gideon Nimoh',
	passport: 1234567890,
}

const checkIn = (flightNum, passenger) => {
	flightNum = 'LH999',
		passenger.name = 'Mr. ' + passenger.name;

	if (passenger.passport === 1234567890) {
		alert("Checked In");
	} else {
		alert("Wrong passport");
	}
}
checkIn(flight, gideon);
console.log(flight);
console.log(gideon);

// When an object is copied, the reference is what has been copied and the content stays the same
// which can be manipulated by the newly created variable.catch

// A function to change Passport Number

const changePassportNumber = (passenger) => {
	passenger.passport = Math.trunc(Math.random() * 10000000000);
}

changePassportNumber(gideon);
checkIn(flight, gideon);
console.log(gideon.passport);

// Parsing by Value && Parsing by reference :::: Javascript does not have Parsing by reference, only
// parse by a value

// First Class Functions
// - Javascript treats functions as firs
t - class citizens
// - This means that functions are simply values
// - Functions are just "type" of objects

// HIGHER-ORDER Functions
// - A function that recieves another function as an argument, that returns a new function or both
// - This is only possible becasue of first-class Functions