'use strict';

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

const rest = new Map();
rest.set('name', 'Classico Italliano'); // Add new member to the Maps
rest.set(1, 'Firenze, Italy');
console.log(rest.set(2, 'Lisbon, Portugal'));

rest.set('categories', ['Italian', 'Pizzeria', 'Vegetarian', 'Organic'],)
rest.set('open', 11);
rest.set('close', 23).set(true, 'We are open').set(false, 'We are closed');
console.log(rest.get("name"));
console.log(rest.get(true));
console.log(rest.get(1));

const time = 21;
console.log(rest.get(time > rest.get('open') && time < rest.get('close')));

// Check if a map contains a key
console.log(rest.has('categories')) // Check if it exist based on the KEY
console.log(rest.delete(2)) // delete a key from the map
console.log(rest.size); //  Check the size of the Map
// rest.clear(); // delete everything in the map
console.log(rest);

// Arrays as mapKeys
const arr = [1,2];
rest.set(arr, 'Test');
console.log(rest)
console.log(rest.size);

console.log(rest.get(arr));

rest.set(document.querySelector('h1'), 'Heading');
console.log(rest);
