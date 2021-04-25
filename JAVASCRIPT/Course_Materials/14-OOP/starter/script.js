'use strict';

const Person = function (name, year) {
  // Instance Properties
  this.name = name;
  this.year = year;

  //? Check Notes -- Something very important there
};

const per = new Person('Gideon', 1991);
const mat = new Person('Matilda', 2003);
const pat = new Person('Patricia', 1995);
console.log(per);
console.log(mat);
console.log(pat);
console.log(pat instanceof Person);

// Prototypes
Person.prototype.calcAge = function () {
  console.log(2037 - this.year);
};

console.log(Person.prototype);

per.calcAge();
pat.calcAge();
console.log(per.__proto__);
console.log(per.__proto__ === Person.prototype);
console.log(Person.prototype.isPrototypeOf(per));
console.log(Person.prototype.isPrototypeOf(Person));

//? You can set other properties other than methods on prototypes which all instances will have access to
Person.prototype.species = 'Homo Sapiens';
console.log(per);
console.log(pat);

console.log(per.hasOwnProperty('name'));
console.log(per.hasOwnProperty('calcAge()'));

//////////////? OBJECT.prototype
console.log(per.__proto__.__proto__);

console.log(Person.prototype.constructor);

const arr = [1, 2, 3, 4, 5, 5, 1, 1, 4]; //! new Array === []
console.log(arr.__proto__);
console.log(arr.__proto__ === Array.prototype);
console.log(arr.__proto__.__proto__);

Array.prototype.unique = function () {
  //! Adding a new function to the array object
  return [...new Set(this)];
};

console.log(arr.unique());

const h1 = document.querySelector('h1');
console.log(h1);
console.dir(h1);

console.dir(x => x + 1);

// ES6 Classes
//
class PersonCl {
  constructor(fullName, year) {
    this.fullName = fullName;
    this.year = year;
  }

  // Methods will be added to .prototype
  calcAge() {
    console.log(2037 - this.year);
  }

  greet() {
    console.log(`Hey! ${this.name}`);
  }

  get age() {
    return 2037 - this.year;
  }
  // be careful of the _ below, it help when setting the variable that the constructor is already ataking care of.
  set fullName(name) {
    if (name.includes(' ')) this._fullName = name;
    else alert(`The name ${name} is invalid`);
  }

  get fullName() {
    return this._fullName;
  }

  //! Static Method to a Class
  static hey() {
    console.log(`Hey there! 🙉👋🏾`);
    console.log(this);
  }
}

const jes = new PersonCl('Jesicca Davies', 1989);
jes.calcAge();
console.log(jes);

console.log(jes.__proto__ === PersonCl.prototype);

// PersonCl.prototype.greet = function () {
//   console.log(`Hey! ${this.name}`);
// }

jes.greet();

const walter = new PersonCl('Walter White', 1969);

//! Setters & Getters

const account = {
  owner: 'Gideon',
  transactions: [200, 345, 89, -75, 34],

  get latest() {
    return this.transactions.slice(-1).pop();
  },

  set latest(tran) {
    this.transactions.push(tran);
  },
};

console.log(account.latest);

account.latest = 50;

console.log(account.transactions);

console.log(jes.age);

//TODO: STSTIC METHODS
//! Static methods are attached to the Constructor intself and no on its prototypes. Therefore, all instances created from that class will NOT have access to this method.

// Addint a static Method
Person.hey = function () {
  console.log('Hey! there 👋🏾');
  console.log(this);
};

Person.hey();

PersonCl.hey();

// Using the Object.create() Method

const PersonProto = {
  calcAge() {
    console.log(2037 - this.year);
  },

  init(firstName, year) {
    this.firstName = firstName;
    this.year = year;
  },
};

const gideon = Object.create(PersonProto);
console.log(gideon);
gideon.name = 'Gideon';
gideon.year = 1990;
gideon.calcAge();
console.log(gideon.__proto__);
console.log(gideon.__proto__ === PersonProto);

const sara = Object.create(PersonProto);
sara.init('Sarah', 1993);
sara.calcAge();

// INHERITANCE

// Using COnstructors for Inheritance between classes
const Student = function (name, year, course) {
  Person.call(this, name, year);
  this.course = course;
};

// Linking Prototypes
Student.prototype = Object.create(Person.prototype);

Student.prototype.introduce = function () {
  console.log(`My name is ${this.name} and I study ${this.course}`);
};

const mike = new Student('Mike', 2020, 'Computer Science');
mike.introduce();
mike.calcAge();
console.log(mike.__proto__);
console.log(mike.__proto__.__proto__);

console.log(mike instanceof Student);
console.log(mike instanceof Person);

Student.prototype.constructor = Student;
console.dir(Student.prototype.constructor);

// Using ES6 for Inheritance Between classes
class StudentCl extends PersonCl {
  constructor(name, year, course) {
    // Always call the super() first in order to have access to the THIS keyword on this class
    super(name, year);
    this.course = course;
  }

  introduce() {
    console.log(`My name is ${this.fullName} and I study ${this.course}`);
  }

  calcAge() {
    console.log(
      `I am ${2037 - this.year} years old, but as a student I feel more like ${
        2037 - this.year + 10
      }`
    );
  }
}

// const martha = new StudentCl('Martha Jones', 2002);
const martha = new StudentCl('Martha Jones', 2012, 'Computer Science');
martha.introduce();
martha.calcAge();

// Using Object.create()
const StudentProto = Object.create(PersonProto);
StudentProto.init = function (name, year, course) {
  PersonProto.init.call(this, name, year); // first call the init form the Person proto to assign the THIS keyword to this very object's instances created.
  this.course = course;
};

StudentProto.introduce = function () {
  console.log(`My name is ${this.firstName} and I study ${this.course}`);
};

const jay = Object.create(StudentProto);
jay.init('Jayson', 1992, 'Computer Science');
jay.introduce();
jay.calcAge();

// Another Class Example
class Account {
  constructor(owner, currency, pin) {
    this.owner = owner;
    this.currency = currency;
    // Protected data
    this._pin = pin;
    // Protected data
    this._movements = [];
    this.locale = navigator.language;

    console.log(`Welcome to NumberOne Bank, ${owner}...🍻`);
  }

  // Public Interface for this class

  getMovements() {
    return this._movements;
  }

  deposit(amount) {
    this._movements.push(amount);
    return this;
  }

  withdrawal(amount) {
    this.deposit(-amount);
    return this;
  }

  _approveLoan(val) {
    return true;
  }

  requestLoan(value) {
    this._approveLoan(value) && this.deposit(value);
    console.log('Loan approved');
    return this;
  }
}

const acc1 = new Account('Gideon', 'USD', 1111);
console.log(acc1);

// Deposits & withdarwals
// acc1.movements.push(200);
// acc1.movements.push(-120); // it is not a good idea to directly interract with inner properties like this. Instead, create a method that interracts with these properties to avoidn bugs

acc1.deposit(200);
acc1.withdrawal(78);

console.log(acc1);

acc1.requestLoan(500);
console.log(acc1);

//? Making some properties Inaccessible to the user
//? Encapsulation & Data Privacy

// _movements -- convention

console.log(acc1.getMovements());

// Public Fields
// Private Fields
// Public Methods
// Private methods
// There is also the static format for all the 4 above -- which is also only available to the class itself and not on its instances300

//! /////////////////////////////////////////////////!!
class Account1 {
  // Public fields
  locale = navigator.language;

  // Private Fields
  #
  movements = []; // can be tested in Google Chrome
  #
  pin;

  constructor(owner, currency, pin) {
    this.owner = owner;
    this.currency = currency;
    this.#pin = pin;
  }

  // Private Methods
  getMovements() {
    // return this.#movements;
  }

  deposit(amount) {
    // this.#movements.push(amount);
  }

  withdrawal(amount) {
    this.deposit(-amount);
  }

  // # approveLoan(val) {
  //   return true;
  // }

  requestLoan(value) {
    // this.#approveLoan(value) && this.deposit(value);
    console.log('Loan approved');
  }
}

const jay1 = new Account1('Kwame', 'EUR', 2568);
console.log(jay1);
// console.log(jay1.#movements);
// console.log(jay1.#pin);

console.log(jay1.requestLoan(500));
console.log(jay1);

/// Chaining Methods
// To chain methods, return (this) the object itslef in your individual methods to allow this chaining techinique
acc1.deposit(300).deposit(400).withdrawal(50).requestLoan(1000).withdrawal(20);
console.log(acc1);
console.log(acc1.getMovements());