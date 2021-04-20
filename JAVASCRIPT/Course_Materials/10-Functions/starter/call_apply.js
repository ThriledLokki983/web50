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
const bookEW = book.bind(eurowings); // const book = lufthansa.book;
const bookLH = book.bind(lufthansa);
const bookLX = book.bind(swiss);

bookEW(234, 'Stephen, Williams');
book.bind(eurowings)(456, 'Brandon Spears');
console.log(eurowings);

const bookEW23 = book.bind(eurowings, 23);
bookEW23('Gideon Agyin-Nimoh');
bookEW23('Johnspon Asiedu-Nkatiah');
bookEW23('Rosemond Brown')
console.log(eurowings.bookings);


// With Event Listeners
lufthansa.planes = 300;
lufthansa.buyPlane = function () {
	console.log(this);
	this.planes += 3;
	console.log(this.planes);
};

eurowings.planes = 10;
swiss.planes = 5;
// lufthansa.buyPlane();

document.querySelector('.buy').addEventListener('click', lufthansa.buyPlane.bind(lufthansa));


// Partial Application // THIS keyword is sometimes not neccessary but we still use the bind Method

const addtax = (rate, value) => value + (value * rate);
console.log(addtax(0.1, 200));

const addVAT = addtax.bind(null, 0.23); // addVAT = value => value * 0.23;
console.log(addVAT(100));
console.log(addVAT(23));

// Rewrite a fn to return the AddVAT Function

const calcTax = function (rate, value) {
	return function (value1) {
		console.log(`Ans: ${rate * value1}`)
	}
};

calcTax(0.23, 100)(200);

const addTaxRate = function (rate) {
	return function (value) {
		return value + (value * rate);
	}
}

const addVAT2 = addTaxRate(0.23);
console.log(addVAT2(100));
console.log(addVAT2(23));