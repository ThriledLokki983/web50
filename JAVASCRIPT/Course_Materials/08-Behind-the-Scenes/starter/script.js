'use strict';

const gideon = {
  firstName: 'Gideon',
  year: 1990,

  calcAge: function () {
    return `You are ${2060 - this.year}`
  },

  greet: () => console.log(`Hey ${this.firstName}`)
}
gideon.greet();

console.log(gideon.calcAge());

const matilda = {
  name: 'Matilda',
  year: 2004
}

matilda.calcAge = gideon.calcAge;
console.log(matilda.calcAge());

const f = gideon.calcAge;