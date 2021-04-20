'use strict';

// Default Parameters
const bookings = [];

const createBooking = (flightNum, numPassengers = 1, price = 199 * numPassengers) => {
	// numPassengers = numPassengers || 1;
	// price = price || 1.99; // ES5 version

	const booking = {
		flightNum,
		numPassengers,
		price
	}
	console.log(booking);
	bookings.push(booking);
}

createBooking('LH123')
createBooking('H123', 2, 800);
createBooking('LH123', 5)
createBooking('LH123', undefined, 1000); // how to skip a parameter in the function