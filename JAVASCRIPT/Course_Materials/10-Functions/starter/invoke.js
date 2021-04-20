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