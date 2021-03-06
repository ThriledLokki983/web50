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

const props = Object.keys(restaurant.openingHours);
console.log(props);

let openStr = `We are open for ${props.length}-times in a week
days: `
console.log(openStr);

// Loopiong over an Array
for(let day of Object.keys(restaurant.openingHours)){
  openStr += `${day}, `;
}

console.log(openStr);

// Property values
const values = Object.values(restaurant.openingHours);
console.log(...values);


// Entries for Object
const entries = Object.entries(restaurant.openingHours);
console.log(entries);

for(let [key, {open, close}] of entries){
  console.log(`On ${key} we open at ${open}-hrs and close at ${close}-hrs`);
}
