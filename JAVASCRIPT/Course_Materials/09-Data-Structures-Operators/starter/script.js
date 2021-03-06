'use strict';

// Data needed for a later exercise
const flights =
	'_Delayed_Departure;fao93766109;txl2133758440;11:25+_Arrival;bru0943384722;fao93766109;11:45+_Delayed_Arrival;hel7439299980;fao93766109;12:05+_Departure;fao93766109;lis2323639855;12:30';

// Data needed for first part of the section
const restaurant = {
	name: 'Classico Italiano',
	location: 'Via Angelo Tavanti 23, Firenze, Italy',
	categories: ['Italian', 'Pizzeria', 'Vegetarian', 'Organic'],
	starterMenu: ['Focaccia', 'Bruschetta', 'Garlic Bread', 'Caprese Salad'],
	mainMenu: ['Pizza', 'Pasta', 'Risotto'],

	openingHours: {
		thu: {
			open: 12,
			close: 22,
		},
		fri: {
			open: 11,
			close: 23,
		},
		sat: {
			open: 0, // Open 24 hours
			close: 24,
		},
	},

	order: function (starterIndex, mainIndex) {
		return [this.starterMenu[starterIndex], this.mainMenu[mainIndex]]
	},

	orderDelivery: function ({
		starterIndex,
		mainIndex,
		time,
		address
	}) {
		console.log(`Order Received: ${this.starterMenu[starterIndex]} - Starter
    ${this.mainMenu[mainIndex]} - Main
    will be delivered to ${address}
    at ${time}`);
	},

	orderPasta: function (ing1, ing2, ing3) {
		console.log(`Here is your delicious pasta with ${ing1}, ${ing2} and ${ing3}`);
	},

	orderPizza: function (mainIngredients, ...otherIngredients) {
		console.log(mainIngredients);
		console.log(otherIngredients);
	},
};

restaurant.numGuests = 0;
const guest1 = restaurant.numGuests ? restaurant.numGuests : 10;
console.log(guest1);

const guestCorrect = restaurant.numGuests ? ? 10;
console.log(guestCorrect);

console.log('--------------OR---------------');

console.log(3 || 'Gideon');
console.log('' || 'Gideon');
console.log(true || 0);
console.log(undefined || null);

console.log(undefined || 0 || '' || 'Gideon' || 23 || null);

restaurant.numGuests = 0;
const guest1 = restaurant.numGuests ? restaurant.numGuests : 10;
console.log(guest1);

const guest2 = restaurant.numGuests || 10;
console.log(guest2);

// console.log('--------------AND---------------');
// console.log(0 && 'Gideon'); // as soon it is false, it breaks
// console.log(7 && 'Gideon'); // if true, it continues and the last value if returned

// console.log('Gideon' && 23 && null && 'Hello');

// if (restaurant.orderPizza) {
//   restaurant.orderPizza('mushrooms', 'spinach');
// }

// restaurant.orderPizza && (restaurant.orderPizza('mushrooms', 'spinach'));
// const arr = [1, 2, ...[3, 4]];
// const [a, b, ...others] = [1, 2, 3, 4, 5];
// console.log(a, b, others);

// const [pizza, , rissoto, ...otherFood] = [...restaurant.mainMenu, ...restaurant.starterMenu]

// console.log(pizza, rissoto, otherFood);

// // objects
// const {
//   sat,
//   ...weekdays
// } = restaurant.openingHours;
// console.log(sat, weekdays);

// functions

// const add = function (...numbers) {
//   let sum = 0;
//   for (let i = 0; i < numbers.length; i++) {
//     sum += numbers[i];
//   }
//   return sum;
// }
// console.log(add(2, 3));
// console.log(add(5, 3, 7, 8));
// console.log(add(1, 2, 3, 4, 5, 6, 7, 8, 9));

// const x = [3, 8, 9, 4];
// console.log(add(...x));


// restaurant.orderPizza('mushrooms', 'spinach', 'onions', 'lettuce');
// restaurant.orderPizza('lettuce') // with one parameter, the rest will just be an empty array

// const arr = [7, 8, 9];
// const badArr = [1, 2, arr[0], arr[1], arr[2]];
// console.log(badArr);

// const newArr = [1, 2, ...arr];
// console.log(newArr);

// const another = [...badArr, ...newArr];
// console.log(another);
// console.log(...another);

// const newMenu = [...restaurant.mainMenu, 'Gnocci'];
// console.log(newMenu);

// // Copy Arrays
// const mainMenuCopy = [...restaurant.mainMenu];
// const menu = [...restaurant.mainMenu, ...restaurant.starterMenu];
// console.log(menu);
// console.log(...menu);

// const ingredients = [prompt("Let\'s make pasta! Ingredient 1?"), prompt("Let\'s make pasta! Ingredient 2?"), prompt("Let\'s make pasta! Ingredient 3?")];

// console.log(ingredients);
// restaurant.orderPasta(...ingredients);

// objects
// const newRestaurant = {
//   foundedIn: 1998,
//   ...restaurant,
//   founder: 'Gussepia'
// }

// console.log(newRestaurant);

// const restaurantCopy = {
//   ...restaurant
// };
// restaurantCopy.name = 'Restotante Aromatica';
// console.log(newRestaurant.name);
// console.log(restaurant.name);
// console.log(...newRestaurant);

// restaurant.orderDelivery({
//   time: '11:30',
//   address: 'Via del Sole, 21',
//   mainIndex: 2,
//   starterIndex: 2
// })

// // Destructuring objects
// const {
//   name,
//   openingHours,
//   categories
// } = restaurant;
// console.log(name, openingHours, categories);

// // Renaming the variables in the objects
// const {
//   name: restaurantName,
//   openingHours: hours,
//   categories: tags
// } = restaurant;
// console.log(restaurantName, hours, tags);

// // Setting default values
// const {
//   menu = [], starterMenu: starters = []
// } = restaurant;
// console.log(menu, starters);

// // Mutating variables while destructuring objects
// let a = 111;
// let b = 999;
// const obj = {
//   a: 23,
//   b: 7,
//   c: 14
// };

// ({
//   a,
//   b
// } = obj);
// console.log(a, b);

// // Nested Objects
// const {
//   fri: {
//     open: o,
//     close: c
//   }
// } = openingHours;
// console.log(o, c);


// Destructuring

// let [main, , , secondary] = restaurant.categories;
// console.log(main, secondary);

// // Switching main and secondary
// // const temp = main;
// // main = secondary;
// // secondary = temp;
// // console.log(main, secondary);

// [main, secondary] = [secondary, main];
// console.log(main, secondary);

// const [starter, mainCourse] = restaurant.order(2, 0);
// console.log(starter, mainCourse);

// // Nested Array of -- Destructuring

// const nested = [2, 4, [4, 5]];
// const [i, , g] = nested;
// console.log(i, g);

// const [a, , [c, k]] = nested;
// console.log(a, c, k);

// // Setting default values
// const [p = 1, q = 1, r = 1] = [3, 4];
// console.log(p, q, r);

// Challenge for Data Structure

const game = {
	team1: 'Bayern Munich',
	team2: 'Borrussia Dortmund',
	players: [
    [
      'Neuer',
      'Pavard',
      'Martinez',
      'Alaba',
      'Davies',
      'Kimmich',
      'Goretzka',
      'Coman',
      'Muller',
      'Gnarby',
      'Lewandowski',
    ],
    [
      'Burki',
      'Schulz',
      'Hummels',
      'Akanji',
      'Hakimi',
      'Weigl',
      'Witsel',
      'Hazard',
      'Brandt',
      'Sancho',
      'Gotze',
    ],
  ],
	score: '4:0',
	scored: ['Lewandowski', 'Gnarby', 'Lewandowski', 'Hummels'],
	date: 'Nov 9th, 2037',
	odds: {
		team1: 1.33,
		x: 3.25,
		team2: 6.5,
	},
};
// Q1
// const [players1] = [...game.players[0]];
// console.log(players1);

// const [players2] = [game.players[1]];
// console.log(players2);

// Ans
const [players1, players2] = game.players;
console.log(players1, players2);

// Q2
// const [gk, ...others] = [game.players[0][0], ...game.players[0]];
// console.log(`Goal Keeper: ${gk}
// Field Players: ${others}`);

// Answer
const [gk, ...fieldPlayers] = players1;
console.log(gk, fieldPlayers);

// Q3
// console.log(`All Players : ${players1 + ' ' + players2}`);

// Answers
const allPlayers = [...players1, ...players2];
console.log(allPlayers);

// Q4
const player1Final = [...players1, 'Thiago', 'Coutinho', 'Perisic'];
console.log(player1Final);

// Q5
const draw1 = game.odds.x;
console.log(draw1);
const team = game.odds.team1;
console.log(team);
const team3 = game.odds.team2;
console.log(team3);

// Answer
const {
	odds: {
		team1,
		x: draw,
		team2
	}
} = game;
console.log(team1, draw, team2);

// Q6
const printGoals1 = function (...numbers) { // Aggregate all incoming into one argument
	for (let i = 0; i < numbers.length; i++) {
		console.log(`${numbers[i]} scored ${i > 1 ? 'goals' : 'a goal'}`);
	}
}

// Answer
const printGoals = function (...numbers) {
	for (let i = 0; i < numbers.length; i++) {
		console.log(`${numbers.length} goals were scored`);
	}
}

console.log(printGoals('Davies', 'Muller'));
console.log(printGoals(...game.scored));

// Q7
console.log(team1 || team1);

// Answers

team1 > team2 || console.log('Team 1 is more likely to win!');
team2 > team1 && console.log('Team 2 is more likely to win!');
