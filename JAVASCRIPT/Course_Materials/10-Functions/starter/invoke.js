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