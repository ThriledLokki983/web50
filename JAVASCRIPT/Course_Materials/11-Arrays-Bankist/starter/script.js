'use strict';

/////////////////////////////////////////////////
/////////////////////////////////////////////////
// BANKIST APP

// Data
const account1 = {
	owner: 'Jonas Schmedtmann',
	movements: [200, 450, -400, 3000, -650, -130, 70, 1300],
	interestRate: 1.2, // %
	pin: 1111,
};

const account2 = {
	owner: 'Jessica Davis',
	movements: [5000, 3400, -150, -790, -3210, -1000, 8500, -30],
	interestRate: 1.5,
	pin: 2222,
};

const account3 = {
	owner: 'Steven Thomas Williams',
	movements: [200, -200, 340, -300, -20, 50, 400, -460],
	interestRate: 0.7,
	pin: 3333,
};

const account4 = {
	owner: 'Sarah Smith',
	movements: [430, 1000, 700, 50, 90],
	interestRate: 1,
	pin: 4444,
};

const accounts = [account1, account2, account3, account4];

// Elements
const labelWelcome = document.querySelector('.welcome');
const labelDate = document.querySelector('.date');
const labelBalance = document.querySelector('.balance__value');
const labelSumIn = document.querySelector('.summary__value--in');
const labelSumOut = document.querySelector('.summary__value--out');
const labelSumInterest = document.querySelector('.summary__value--interest');
const labelTimer = document.querySelector('.timer');

const containerApp = document.querySelector('.app');
const containerMovements = document.querySelector('.movements');

const btnLogin = document.querySelector('.login__btn');
const btnTransfer = document.querySelector('.form__btn--transfer');
const btnLoan = document.querySelector('.form__btn--loan');
const btnClose = document.querySelector('.form__btn--close');
const btnSort = document.querySelector('.btn--sort');

const inputLoginUsername = document.querySelector('.login__input--user');
const inputLoginPin = document.querySelector('.login__input--pin');
const inputTransferTo = document.querySelector('.form__input--to');
const inputTransferAmount = document.querySelector('.form__input--amount');
const inputLoanAmount = document.querySelector('.form__input--loan-amount');
const inputCloseUsername = document.querySelector('.form__input--user');
const inputClosePin = document.querySelector('.form__input--pin');

/////////////////////////////////////////////////
/////////////////////////////////////////////////
// LECTURES

// const currencies = new Map([
//   ['USD', 'United States dollar'],
//   ['EUR', 'Euro'],
//   ['GBP', 'Pound sterling'],
// ]);

// const movements = [200, 450, -400, 3000, -650, -130, 70, 1300];

/////////////////////////////////////////////////

const movements = [200, 450, -400, 3000, -650, -130, 70, 1300];

for (let move of movements) {
	move > 0 ? console.log(`You deposited ${move}`) : console.log(`You withdrew ${Math.abs(move)}`);
}
console.log('================ FOR-EACH METHOD ====================')

// Using the foreach Method -- it uses an Anonymous function as a callback function to tell the higher order function what to do
movements.forEach(function (move) {
	move > 0 ? console.log(`You deposited ${move}`) : console.log(`You withdrew ${Math.abs(move)}`);
})

console.log('================ FOR-EACH METHOD + the index ====================')
// Getting the current index == the parameter names don't matter but the ORDER does ==>
// 1. the current element
// 2. the current index
// 3. the entire array we are lopping over
movements.forEach(function (move, i, arr) {
	move > 0 ? console.log(`Movement ${i + 1}: You deposited ${move}`) : console.log(`Movement ${i + 1}: You withdrew ${Math.abs(move)}`);
});

// When to use the forEach and when to use for of loop
// You cannot break out from forEach loop but you can in the for-of loop

console.log('================ FOR-EACH METHOD + MAPS ====================')
// ForEach in Maps
// 1. the current Value
// 2. the current key
// 3. the entire Map we are lopping over
const currencies = new Map([
  ['USD', 'United States dollar'],
  ['EUR', 'Euro'],
  ['GBP', 'Pound sterling'],
]);

currencies.forEach(function (value, key, entireMap) {
	console.log(`${key}: ${value}`);
})

console.log('================ FOR-EACH METHOD + SETS ====================')
// ForEach in Sets
// 1. the current Value
// 2. the current key == same as value
// 3. the entire Map we are lopping over

const currenciesUnique = new Set(['USD', 'GBP', 'USD', 'EUR', 'EUR']);
// console.log(currenciesUnique);
currenciesUnique.forEach(function (value, _, set) {
	console.log(`${value}: ${value}`);
})