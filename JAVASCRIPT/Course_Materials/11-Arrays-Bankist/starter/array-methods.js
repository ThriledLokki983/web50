'use strict';

// Methods on Arrays
let arr = ['a', 'b', 'c', 'd', 'e'];
let arr2 = [...arr];
console.log(arr2)

// Slice Method -- returns a new array with the extracted parts
console.log(arr.slice(2));
console.log(arr.slice(2, 4)); // the end parameter is not included in the returned array
console.log(arr.slice(-2)); // from the end of the original array
console.log(arr.slice(-1));
console.log(arr.slice(1, -2));

// Making a shallow copy of the Arrays
console.log(arr.slice());
console.log([...arr]);

// Splice Method -- this method mutates the original array
// console.log(arr.splice(2)); // takes part of the array and returns it while the original array loses the spliced Data
arr.splice(-1)
console.log(arr)
console.log(arr.splice(1, 2));
console.log(arr);

// Reverse Method -- Mutates the array
console.log(arr2.reverse());
console.log(arr2);

// Concat Method -- does not mutate the original array
const letters = arr.concat(arr2); // console.log([...arr, ...arr2])
console.log(letters);

// Join Method ---
console.log(letters.join(' - '));
//////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
const movements = [200, 450, -400, 3000, -650, -130, 70, 1300];

// MAP Method -- for looping (just like the forEach Method) but this one creates
// a brand new array
// Maps the value of the original array into a new array (e.g * 4);
// Returns a NEW ARRAY Containing the results of applying an operation on all the original array elements
// current  * 2
const eurosToUsd = 1.1;
// const movementsUsd = movements.map(function (currentElement) {
// 	return Number((currentElement * eurosToUsd).toFixed(0));
// });
//
const movementsUsd =
	movements.map(currentElement => Number((currentElement * eurosToUsd).toFixed(0)));

console.log(movements);
console.log(movementsUsd);

const newMove = movements.map((mov, i) => `Movement ${i + 1}: You ${mov > 0 ? 'deposited' : 'withdrew'} ${Math.abs(mov)}`);
console.log(newMove);



// FILTER
// Filter for an element in the original array which satisfies a particular condition
// Returns a NEW ARRAY Containing the array elements that passed a specified TEST CONDITION
// Curernt > 2

const deposits = movements.filter(function (mov) {
	return mov > 0; // return a boolean value
});

const deposit = [];
const withdrawals = [];
for (let mov of movements) {
	mov > 0 ? deposit.push(mov) : withdrawals.push(mov);
}


console.log(deposits);
console.log(deposit);
console.log(withdrawals);


// REDUCE
// Reduce (boils) all the array elements of the original array down to a single value
// (e.g -- aadding all the elements together)
// accumulator + current === One single Value which is finally returned
// Accumulator -> SNOWBALL
console.log(movements);
const balance = movements.reduce(function (acc, element, index, arr) {
	console.log(`Iteration ${index + 1}:\t${acc}`)
	return acc + element;
}, 0);
console.log(balance);

const balance3 = movements.reduce((acc, curr) => acc + curr, 0);
console.log(balance3);

let balance2 = 0;
for (let i of movements) {
	balance2 += i;
}
console.log(balance2);

// Maximum Value of the movements
const max = movements.reduce((acc, curr) => acc > curr ? acc : curr, movements[0]);
console.log(max);

// Chaining of Array Methods
const totalDeposits =
	movements.filter(mov => mov > 0)
	.map((mov) => mov * eurosToUsd)
	.reduce((initial, current) => initial + current, 0);

console.log(totalDeposits);