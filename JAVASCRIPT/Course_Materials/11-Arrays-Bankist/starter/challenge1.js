'use strict';

// Coding Challenge #1

/*
Julia and Kate are doing a study on dogs. So each of them asked 5 dog owners
 about their dog's age, and stored the data into an array (one array for each).
  For now, they are just interested in knowing whether a dog is an adult or a
  puppy. A dog is an adult if it is at least 3 years old, and it's a puppy if
  it's less than 3 years old.

Create a function 'checkDogs', which accepts 2 arrays of dog's ages ('dogsJulia'
and 'dogsKate'), and does the following things:

1. Julia found out that the owners of the FIRST and the LAST TWO dogs actually
have cats, not dogs! So create a shallow copy of Julia's array, and remove the
cat ages from that copied array (because it's a bad practice to mutate function
parameters)
2. Create an array with both Julia's (corrected) and Kate's data
3. For each remaining dog, log to the console whether it's an adult ("Dog number
1 is an adult, and is 5 years old") or a puppy ("Dog number 2 is still a puppy 🐶")
4. Run the function for both test datasets

HINT: Use tools from all lectures in this section so far 😉

TEST DATA 1: Julia's data [3, 5, 2, 12, 7], Kate's data [4, 1, 15, 8, 3]
TEST DATA 2: Julia's data [9, 16, 6, 8, 3], Kate's data [10, 5, 6, 1, 4]

GOOD LUCK 😀
*/

const checkDogs = function (array1, array2) {
	const array1Copy = array1.slice(1, -2);
	const corretData = [...array1Copy, ...array2];
	corretData.forEach(function (value, index) {
		const check = value >= 3 ? 'adult 🐕' : 'puppy 🐶';
		const art = check === 'adult' ? 'an' : 'a';
		const year = value > 1 ? 'years' : 'year';
		console.log(`Dog number ${index + 1} is ${art} ${check}, and is ${value} ${year} old`)
	})
}
console.log('================== TEST DATA-1 ================')
checkDogs([3, 5, 2, 12, 7], [4, 1, 15, 8, 3]);
console.log('================== TEST DATA-2 ================')
checkDogs([9, 16, 6, 8, 3], [10, 5, 6, 1, 4]);


console.log('================== Challeng - 2 ================')

// Q-1
const calcAverageHumanAge = function (arr) {
	const humanAges = arr.map(curr => curr <= 2 ? curr * 2 : 16 + (curr * 4));
	const newArr = humanAges.filter((curr) => curr >= 18);
	const total = newArr.reduce((initial, current) => initial + current, 0);
	return Number((total / newArr.length).toFixed(0));
}
console.log(calcAverageHumanAge([5, 2, 4, 1, 15, 8, 3]));
console.log(calcAverageHumanAge([16, 6, 10, 5, 6, 1, 4]));

// // Q-2
// const newArr = calcAverageHumanAge([5, 2, 4, 1, 15, 8, 3]);
// const newArr1 = calcAverageHumanAge([16, 6, 10, 5, 6, 1, 4]);
// const atLeast18 = newArr.filter(curr => curr >= 18);
// const atLeast181 = newArr1.filter(curr => curr >= 18);
// console.log(atLeast18);
// console.log(atLeast181);
//
// // Q-3
// let sum = 0;
// const allAdults = [...atLeast18, ...atLeast181];
// for (let i of allAdults) {
// 	sum += i;
// }
// console.log(Number((sum / allAdults.length).toFixed(0)));
//
// calcAverageHumanAge([5, 2, 4, 1, 15, 8, 3]);