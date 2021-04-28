// Importing module
// import './shoppingCart.js';
// import { addToCart } from './shoppingCart.js'; // importing name imports
// import { totalPrice as price, qt } from './shoppingCart.js'; // rename the variables
import * as ShoppingCart from './shoppingCart.js'; // import everything

import add from './shoppingCart.js'; // import the default from the module
import * as Modern from './modern.js';

// console.log('Importing Module');
// addToCart('bread', 10);
// console.log(price, qt);

// ShoppingCart.addToCart('bread', 10);
// console.log(ShoppingCart.totalPrice);

add('pizza', 4);
// console.log(Modern);

// Common JS Modules

// import cloneDeep from './node_modules/lodash-es/cloneDeep.js';
import cloneDeep from 'lodash-es'; // much better way to import 

const state = {
  cart: [{
      product: 'bread',
      quantity: 7
    },
    {
      product: 'pizza',
      quantity: 5
    },
  ],
  user: {
    loggedIn: true
  },
};

const stateClone = Object.assign({}, state);
const stateDeepClone = cloneDeep(state);

console.log(stateClone);

state.user.loggedIn = false;

console.log(stateClone);

console.log(stateDeepClone);

// will keep the browser in the same state. 
if (module.hot) {
  module.hot.accept()
}
// let greeting;

class Person {
  constructor(name) {
    this.name = name;
    console.log(`Hey, ${this.name}`);
  }
}

const gid = new Person('Gideon');

Promise.resolve('TEST').then(res => console.log(res));

import 'core-js/stable';
import 'core-js/stable/array/find';
import 'regenerator-runtime/runtime'