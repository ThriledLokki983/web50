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

// CHALLENGE 3
const calcAverageHumanAge = function (arr) {
	const humanAges = arr.map(curr => curr <= 2 ? curr * 2 : 16 + (curr * 4))
		.filter((curr) => curr >= 18)
		.reduce((initial, current, i, arr) => initial + current / arr.length, 0);
	return Number(humanAges.toFixed(0));
}
console.log(calcAverageHumanAge([5, 2, 4, 1, 15, 8, 3]));
console.log(calcAverageHumanAge([16, 6, 10, 5, 6, 1, 4]));

const calcAverageHumanAge1 = arr => arr
	.map(curr => curr <= 2 ? curr * 2 : 16 + (curr * 4))
	.filter((curr) => curr >= 18)
	.reduce((init, current, i, arr) => init + current / arr.length, 0).toFixed(0);

console.log(calcAverageHumanAge1([5, 2, 4, 1, 15, 8, 3]));
console.log(calcAverageHumanAge1([16, 6, 10, 5, 6, 1, 4]));

console.log('================== Challeng - 4 ================')

//TEST Data
const dogs = [
	{
		weight: 22,
		curFood: 250,
		owners: ['Alice', 'Bob']
	},
	{
		weight: 8,
		curFood: 200,
		owners: ['Matilda']
	},
	{
		weight: 13,
		curFood: 275,
		owners: ['Sarah', 'John']
	},
	{
		weight: 8,
		curFood: 340,
		owners: ['Michiel']
	}
]

// Loop over the array containing the dog objects and for each dog, calculate
// the recommended food portion and add it to the object as a new array,

// Q- 1
//const newDogs = dogs.map(item => item.recFood = Number(((item.weight / 1000) ** 0.75 * 28).toFixed(2)));
for (let dog of dogs) {
	dog.recFood = Math.trunc((dog.weight) ** 0.75 * 28);
}
console.log(dogs);


// Q - 2
// Find Sara's dog
for (let dog of dogs) {
	let str = dog.curFood > dog.recFood ? ' much' : ' little';
	dog.owners.includes('Sarah') ? console.log(`${dog.owners[0]}'s dog is eating too ${str}`) : '';
}

// const dogSarah = dogs.find(dog => dog.owners.includes('Sarah'));
// console.log(dogSarah);

// Q -3
const high = item => item.curFood > item.recFood ? item.owners : '';
const low = item => item.curFood < item.recFood ? item.owners : '';
const ownersEatTooMuch = dogs.flatMap(high).filter((item) => item !== '');
const ownersEatTooLittle = dogs.flatMap(low).filter((item) => item !== '');
const ownersEatTooMuch1 = dogs.filter((item) => item.curFood > item.recFood).flatMap((item) => item.owners)
const ownersEatTooLittle1 = dogs.filter((item) => item.curFood < item.recFood).flatMap((item) => item.owners);

console.log(ownersEatTooMuch1)
console.log(ownersEatTooMuch)

console.log(ownersEatTooLittle)
console.log(ownersEatTooLittle1)

// console.log(`Owners eat too little: ${ownersEatTooLittle}`);

// Q - 4
console.log(`${ownersEatTooMuch.join(' and ')}'s dogs eat too much`);
console.log(`${ownersEatTooLittle.join(' and ')}'s dogs eat too littel`);

// Q -5
console.log(dogs.some(item => item.curFood === item.recFood));


// Q - 6
const checkEatingOk = item =>
	item.curFood > item.recFood * 0.9 &&
	item.curFood < item.recFood * 1.1;

console.log(dogs.some(checkEatingOk));

// Q -7
console.log(dogs.filter(checkEatingOk));

// Q - 8
const dogsCopy = dogs.slice().sort((a, b) => a.recFood - b.recFood);
console.log(dogsCopy);








// end of functions challenge4