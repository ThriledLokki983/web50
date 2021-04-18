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
  }
};

// Destructuring objects
const {
  name,
  openingHours,
  categories
} = restaurant;
console.log(name, openingHours, categories);

// Renaming the variables in the objects
const {
  name: restaurantName,
  openingHours: hours,
  categories: tags
} = restaurant;
console.log(restaurantName, hours, tags);

// Setting default values
const {
  menu = [], starterMenu: starters = []
} = restaurant;
console.log(menu, starters);

// Mutating variables while destructuring objects 



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