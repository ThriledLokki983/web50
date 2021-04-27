// Importing module
// import './shoppingCart.js';
// import { addToCart } from './shoppingCart.js'; // importing name imports
// import { totalPrice as price, qt } from './shoppingCart.js'; // rename the variables
import * as ShoppingCart from './shoppingCart.js'; // import everything

console.log('Importing Module');
// addToCart('bread', 10);
// console.log(price, qt);

ShoppingCart.addToCart('bread', 10);
console.log(ShoppingCart.totalPrice);
