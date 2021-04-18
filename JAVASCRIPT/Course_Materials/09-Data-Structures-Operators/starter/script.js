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
};

const arr = [7, 8, 9];
const badArr = [1, 2, arr[0], arr[1], arr[2]];
console.log(badArr);

const newArr = [1, 2, ...arr];
console.log(newArr);

const another = [...badArr, ...newArr];
console.log(another);
console.log(...another);

const newMenu = [...restaurant.mainMenu, 'Gnocci'];
console.log(newMenu);

// Copy Arrays
const mainMenuCopy = [...restaurant.mainMenu];
const menu = [...restaurant.mainMenu, ...restaurant.starterMenu];
console.log(menu);
console.log(...menu);

// const ingredients = [prompt("Let\'s make pasta! Ingredient 1?"), prompt("Let\'s make pasta! Ingredient 2?"), prompt("Let\'s make pasta! Ingredient 3?")];

// console.log(ingredients);
// restaurant.orderPasta(...ingredients);

// objects
const newRestaurant = {
  foundedIn: 1998,
  ...restaurant,
  founder: 'Gussepia'
}

console.log(newRestaurant);

const restaurantCopy = {
  ...restaurant
};
restaurantCopy.name = 'Restotante Aromatica';
console.log(newRestaurant.name);
console.log(restaurant.name);
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