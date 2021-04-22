'use strict';

// Data
const account5 = {
	owner: 'Jonas Schmedtmann',
	movements: [200, 450, -400, 3000, -650, -130, 70, 1300],
	interestRate: 1.2, // %
	pin: 1111,
};

const account6 = {
	owner: 'Jessica Davis',
	movements: [5000, 3400, -150, -790, -3210, -1000, 8500, -30],
	interestRate: 1.5,
	pin: 2222,
};

const account7 = {
	owner: 'Steven Thomas Williams',
	movements: [200, -200, 340, -300, -20, 50, 400, -460],
	interestRate: 0.7,
	pin: 3333,
};

const account8 = {
	owner: 'Sarah Smith',
	movements: [430, 1000, 700, 50, 90],
	interestRate: 1,
	pin: 4444,
};

const accounts1 = [account5, account6, account7, account8];

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
// 1. the current element
// 2. the current index
// 3. the entire array we are lopping over
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
// 1. the current element
// 2. the current index
// 3. the entire array we are lopping over

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
// 1. the current element
// 2. the current index
// 3. the entire array we are lopping over
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

// Chaining of Array Methods -- disadvantage -- Hard to Debug
const totalDeposits = movements
	.filter(mov => mov > 0)
	.map((mov) => mov * eurosToUsd)
	.reduce((initial, current) => initial + current, 0);

console.log(Number(totalDeposits.toFixed(0)));

// The FIND Method -- returns an element from an array based on a CONDITION
const first = movements.find(mov => mov < 0);
console.log(movements);
console.log(first);

console.log(accounts1);

const account = accounts1.find(acc => acc.owner === 'Jessica Davis');
console.log(account)

for (let acc of accounts1) {
	acc.owner === 'Jessica Davis' ? console.log(acc) : '';
}


// SOME METHOD
console.log(movements);
console.log(movements.includes(-130)); // check only for equality

// check if our transaction has a deposit or a withdrawal
const anyDeposit = movements.some(mov => mov > 500); // check for condition
console.log(anyDeposit);


// EVERY METHOD -- returns true if every element satisfies the condition provide in the callback function

console.log(movements.every(mov => mov > 0));


//Separate callback
const deposit2 = mov => mov < 0;
console.log(movements.some(deposit2));
console.log(movements.every(deposit2));
console.log(movements.filter(deposit2));


// FLAT -- consolidates all newsted arrays into a single array, hence the name FLAT
// Goes only one level deep during the flatening of the array
const arr5 = [1, 2, 3, [4, 5, 6], [7, 8], 8];
console.log(arr5.flat());

// Specify the depth of levels
const arrDeep = [1, 2, 3, [4, [5, 6]], [[7], 8], 8];
console.log(arrDeep.flat());

const arrDeep1 = [1, 2, 3, [4, [5, 6]], [[7], 8], 8];
console.log(arrDeep1.flat(2));


console.log(accounts1);

const accountMove = accounts1.map(acc => acc.movements);
console.log(accountMove);
const allMove = accountMove.flat();
console.log(allMove);
const totalBalance = allMove.reduce((acc, amt) => acc + amt, 0);
console.log(totalBalance);

const totalBalance1 = accounts1
	.map((item) => item.movements)
	.flat()
	.reduce((init, amt) => init + amt, 0);

console.log(totalBalance1);


// FLATMAP METHOD -- maps the array and right afterwards, flattens it
const totalBalance2 = accounts1
	.flatMap(item => item.movements) // goes only one level deep
	.reduce((init, amt) => init + amt, 0);
console.log(totalBalance2);


// Sorting Arrays -- javascript built-in sort methods

// Strings
const owners = ['Gideon', 'Jonas', 'Martha'];
console.log(owners.sort()); // mutates the original array -- so check befor euse
console.log(owners);


//Numbers --
console.log(movements);
// console.log(movements.sort()); //The sort method converts to strings first and the sorts


// Return < 0, A before B // Keep Order
// Return > 0, B before A // Switch Order
// Ascending
movements.sort((a, b) => { // Sort in Ascending Order
	if (a > b) return 1;
	if (a < b) return -1;
});
console.log(movements);

// Same but simplier
movements.sort((a, b) => a - b);
console.log(movements);


// Descending
movements.sort((a, b) => { // Sort in Decending Order
	if (a > b) return -1;
	if (a < b) return 1;
});
console.log(movements);

// Same but simplier
movements.sort((a, b) => b - a)
console.log(movements);

console.log('===================================================')

// Programmatically creating and filling Arrays
const arr8 = [1, 2, 3, 4, 5, 6, 7, 8, 9];
console.log(new Array(1, 2, 3, 4, 5, 6, 7, 8, 9));

const x = new Array(7);
console.log(x);
// console.log(x.map((item) => item * 5));
console.log(x.fill(1)); // Will mutate the entire array
console.log(x.fill(5, 3, 6));
console.log(x.fill(23, 6, 7));

// Array.from Method
const y = Array.from({
	length: 7
}, () => 1);
console.log(Array.from(y));

const z = Array.from({
	length: 7
}, (_, i) => i / 2.5);
console.log(z);

// Simulate a 100 dice rolls
// const diceRoll = Array.from({
// 	length: 100
// }, (_, i) => Math.trunc((Math.random() * i / 6)));
// console.log(diceRoll);
const labelBalance1 = document.querySelector('.balance__value');


labelBalance1.addEventListener('click', ev => {
	const movementsUI = Array.from(document.querySelectorAll('.movements__value'),
		(item) => Number(item.textContent.replace('€', '')));


	console.log(movementsUI);

	const movementsUI2 = [...document.querySelectorAll('.movements__value')];
	console.log(movementsUI2);
});


console.log('======================= Practice Array Methods =============================')
// EX -1
// const bankDepositSum = accounts1
// 	.map((item) => item.movements)
// 	.flat()
const bankDepositSum = accounts1
	.flatMap((item) => item.movements)
	.filter((item) => item > 0)
	.reduce((init, amt) => init + amt, 0)

console.log(bankDepositSum);

// EX -2
// Count all deposits over 1000
const numDeposits = accounts1
	.flatMap(item => item.movements)
	.filter((item) => item >= 1000)
	.length

const numDeposits1 = accounts1
	.flatMap(item => item.movements)
	.reduce((count, amt) => amt >= 1000 ? ++count : count, 0) // Prefixed ++

console.log(numDeposits);
console.log(numDeposits1);


// EX - 3
// Create an object which contains the sum of the deposits and withdrawals with the reduce method
const depo = accounts1
	.flatMap(acc => acc.movements)
	.reduce((sum, curr) => {
		curr > 0 ? sum.deposits += curr : sum.withdrawals += curr;
		return sum;
	}, {
		deposits: 0,
		withdrawals: 0
	})

console.log(depo);

const depo1 = accounts1
	.flatMap(acc => acc.movements)
	.reduce((sum, curr) => {
		// curr > 0 ? sum.deposits += curr : sum.withdrawals += curr;
		sum[curr > 0 ? 'deposits' : 'withdrawals'] += curr;
		return sum;
	}, {
		deposits: 0,
		withdrawals: 0
	})

console.log(depo1);

// Hello