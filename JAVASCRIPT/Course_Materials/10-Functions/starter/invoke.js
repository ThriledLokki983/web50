'use-strict';

// A function which will disappear right after it is called

const runOnce = function () {
	console.log(`This will never run again`);
}
runOnce();

// this is how it is done
(function () {
	console.log(`This will never run again`);
})(); // Immideately invoked function // IIFI

// Similar for Arraow Functions
(() => console.log(`Similar but just for Arrow Functions`))();

// Importance
// - All data/variable defined within a specific scope is private/encapsulated to that scope area

console.log("=============================================================")


// CLOSURES -- makes that returned function remember all variables at the birthplace of that function
// A function has access to the variable environment (VE) of the execution context inwhich it was created
// CLosure ==> VE attached to the function, exactly as it was at the time and place the function was created
let passengerCount = 10;

const secureBooking = function () {
	let passengerCount = 5;

	return function () {
		passengerCount++;
		console.log(`${passengerCount}: Passengers`)
	}
}

const booker = secureBooking();
booker();
booker();
booker();
console.dir(booker);

let f;

const g = function () {
	const a = 23;
	f = function () {
		console.log(a * 2);
	}
}

const h = function () {
	const b = 777;
	f = function () {
		console.log(b * 2);
	}
}

g();
f();

console.dir(f);

// Reassigning f function
h();
f();

console.dir(f);

// Example 2

const boardPassengers = function (n, wait) {
	const perGroup = n / 3;
	setTimeout(function () {
		console.log(
			`We are now boarding all ${n} passengers`);
		console.log(`There are 3 groups, each with ${perGroup} passengers`)
	}, wait * 1000); // callback fn after 1sec


	console.log(`Will start boarding in ${wait} seconds`)
}

boardPassengers(180, 3);