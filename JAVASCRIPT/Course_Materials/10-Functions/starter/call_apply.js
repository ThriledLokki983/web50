'use-strict';

const lufthansa = {
	airline: 'Lufthansa',
	code: 'LH',
	bookings: [],
	// book function ()
	book(flightNum, name) {
		// Tell Javascript what the THIS keyword should look like when called
		console.log(`${name} booked a seat on ${this.airline} flight ${this.code}${flightNum}`);
		this.bookings.push({
			flight: `${this.code}${flightNum}`,
			name
		});
	},
};



lufthansa.book(238, 'Gideon Nimoh');
lufthansa.book(635, 'John Smith');
console.log(lufthansa);

const eurowings = {
	airline: 'Eurowings',
	code: 'EW',
	bookings: [],
}
const book = lufthansa.book;

// book(23, 'Sarah Williams');  Does not work
// Call Method
book.call(eurowings, 23, 'Sara Williams'); // use the call method on the book
console.log(eurowings);

book.call(lufthansa, 239, 'Anokye Emmanuel');
console.log(lufthansa);

const swiss = {
	airline: 'Swiss Air Lines',
	code: 'LX',
	bookings: [],
}

book.call(swiss, 239, 'Mary Cooper');
book.call(swiss, 458, 'Debra van-Klienwee');
console.log(swiss);


// Apply Methods
const flightData = [583, 'Gideon Boakye'];
const flightData1 = [763, 'Edward Owusu'];
book.apply(swiss, flightData);
book.call(swiss, ...flightData1);
console.log(swiss);


// Bind Method == it returns a new function where the THIS keyword is bound