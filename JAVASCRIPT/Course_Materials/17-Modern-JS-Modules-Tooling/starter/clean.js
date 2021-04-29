'use strict';
// prettier-ignore
const budget = Object.freeze([
  { value: 250, description: 'Sold old TV 📺', user: 'jonas' },
  { value: -45, description: 'Groceries 🥑', user: 'jonas' },
  { value: 3500, description: 'Monthly salary 👩‍💻', user: 'jonas' },
  { value: 300, description: 'Freelancing 👩‍💻', user: 'jonas' },
  { value: -1100, description: 'New iPhone 📱', user: 'jonas' },
  { value: -20, description: 'Candy 🍭', user: 'matilda' },
  { value: -125, description: 'Toys 🚂', user: 'matilda' },
  { value: -1800, description: 'New Laptop 💻', user: 'jonas' },
]);

// budget[0].value = 1000;
// budget[9] = 'jona' this will not work

const getLimit = user => spendingLimits?.[user] ?? 0;

let spendingLimits = Object.freeze({
  jonas: 1500,
  matilda: 100,
}); // make this immutable

// spendingLimits.jay = 200; not extensible

const addExpense = function (state, limit, value, description, user = 'jonas') { // this func has a side effect on our budget object // impure function bcos it manipulates an object outside of it
  // if (!user) user = 'jonas';
  const cleanUser = user.toLowerCase(); // now a pure function
  return value <= getLimit(cleanUser) ? [...state, { value: -value, description, cleanUser}] : state;
    
};

const newBudget1 = addExpense(budget, spendingLimits, 10, 'Pizza 🍕');
// console.log(newBudget1);
const newBudget2 = addExpense(newBudget1, spendingLimits, 100, 'Going to movies 🍿', 'Matilda');
const newBudget3 = addExpense(newBudget2, spendingLimits, 200, 'Stuff', 'Jay');
// console.log(budget);

const checkExpenses = function () {
  for (const entry of budget) 
    if (entry.value < -getLimit[entry.user]) 
      entry.flag = 'limit';
};
checkExpenses();

// console.log(budget);

var logBigExpenses = function (bigLimit) {
  var output = '';
  for (var entry of budget)
    output += entry.value <= -bigLimit ? `${entry.description.slice(-2)} /` : '';

  output = output.slice(0, -2); // Remove last '/ '
  console.log(output);
};
// logBigExpenses(500)

console.log(newBudget1);
console.log(newBudget2);
console.log(newBudget3);
