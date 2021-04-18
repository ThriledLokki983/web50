'use strict';

// const gideon = {
//   firstName: 'Gideon',
//   year: 1990,

//   calcAge: function () {
//     return `You are ${2060 - this.year}`

//     const isMillenial = function () {
//       console.log(this);
//       console.log(this.year >= 1981 && this.year <= 1996);
//     };
//     isMillenial();
//   },

//   greet: () => {
//     console.log(`Hey ${this.firstName}`);
//   }
// }
// gideon.greet();
// gideon.calcAge();

// console.log(gideon.calcAge());

// const matilda = {
//   name: 'Matilda',
//   year: 2004
// }

// matilda.calcAge = gideon.calcAge;
// console.log(matilda.calcAge());

// const f = gideon.calcAge;

const gideon = {
  firstName: 'Gideon',
  year: 1990,

  calcAge: function () {
    console.log(2037 - this.year);


    //   const self = this;
    //   const isMillenial = function () {
    //     console.log(self);
    //     console.log(self.year >= 1981 && self.year <= 1996);
    //   };
    //   isMillenial();
    // },

    const isMillenial = () => {
      console.log(this);
      console.log(this.year >= 1981 && this.year <= 1996);
    };
    isMillenial();
  },

  greet: () => {
    console.log(`Hey ${this.firstName}`);
  }
}
gideon.greet();
gideon.calcAge();

// Argument keyword is

const addExpr = function (a, b) {
  console.log(arguments);
  return a + b;
}
console.log(addExpr(2, 5, 9, 8, 3));

var addArrow = (a, b) => {
  console.log(arguments);
  return a + b;
};
// addArrow(3, 5, 6, 9);