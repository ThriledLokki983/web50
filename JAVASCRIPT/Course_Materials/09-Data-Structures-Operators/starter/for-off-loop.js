'use strict';

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

const menu = [...restaurant.starterMenu, ...restaurant.mainMenu];
console.log(menu);

for (let item of menu) {
  console.log(item);
}

// Getting an index element
for (const item of menu.entries()) {
  console.log(`${item[0] + 1}: ${item[1]}`);
}
//console.log([...menu.entries()]);


// Using the destructuring method
for (const [i, el] of menu.entries()) {
  console.log(`${i + 1}: ${el}`);
}

// Optional Chaining Method
if (restaurant.openingHours.mon) console.log(restaurant.openingHours.mon.open);

if (restaurant.openingHours.fri) console.log(restaurant.openingHours.fri.open);

// WITH Optional Chaining Method
console.log(restaurant.openingHours.mon?.open);
console.log(restaurant.openingHours?.mon?.open); // Prevent unexpected bugs


const weekdays = ['mon', 'tues', 'weds', 'thu', 'fri', 'sat', 'sun'];
for(let day of weekdays) {
  // console.log(day);
  const onday = restaurant.openingHours[day]?.open ?? 'closed'; // Nullish & Optional Chaining
  console.log(`On ${day}, we open at ${onday}`);
}

// METHODS
console.log(restaurant.order?.(0,1) ?? "Method not Found.....");
console.log(restaurant.rissoto?.(0,1) ?? "Method not Found......");

// ARRAYS
const users = [
  {name: 'Gideon',
email: 'gideon@email.com',
phone: '0626603494'},
]

console.log(users[1]?.name ?? "Does not exist...")
