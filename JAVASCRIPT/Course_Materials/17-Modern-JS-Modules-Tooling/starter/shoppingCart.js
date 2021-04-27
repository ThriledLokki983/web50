// Exporting module
console.log('Exporting Module');

const shippingCost = 10;
const cart = [];

export const addToCart = function (prod, qty) {
  cart.push({ prod, qty });
  console.log(`${qty} ${prod} has been added to the cart`);
};

const totalPrice = 237;
const totalQty = 23;

export { totalPrice, totalQty as qt };
