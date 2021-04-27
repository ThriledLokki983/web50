const shoppingCart2 = (function () {
  const cart = [];
  const shoppingCart = 10;
  const totalPrice = 237;
  const totalQty = 23;

  const addToCart = function (prod, qty) {
    cart.push({ prod, qty });
    console.log(`${qty} ${prod} has been added to the cart`);
  };

  const orderStock = function (prod, qty) {
    cart.push({ prod, qty });
    console.log(`${qty} ${prod} ordered from supplier`);
  };

  // Things that are exposed outside
  return {
    addToCart,
    cart,
    totalPrice,
    totalQty,
  };
})();

shoppingCart2.addToCart('apple', 4);
shoppingCart2.addToCart('pizza', 2);
// console.log(shoppingCart2);
// console.log(shoppingCart2.addToCart);
