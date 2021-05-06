// console.log(arguments);
// console.log(require("module").wrapper);

// Module.exports
const C = require("./test-module1");

const calc1 = new C();
console.log(calc1.add(2, 6));

// exports
const calc2 = require("./test-module2");
const { add, multiply, divide } = require("./test-module2");
console.log(calc2.add(2, 6));
console.log(calc2.multiply(2, 6));

console.log(add(1, 2));
