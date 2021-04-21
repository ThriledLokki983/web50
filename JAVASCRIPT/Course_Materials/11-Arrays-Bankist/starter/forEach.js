'use strict';

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