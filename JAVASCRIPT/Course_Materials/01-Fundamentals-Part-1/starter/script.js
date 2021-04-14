/*
let js = 'amazing';
//if (js === 'amazing') alert("Javascript is FUN!")

console.log("Jonas");
console.log(34 + 25 - 10);
console.log(34);

let firstName = "Mathilda";
let lastName = "Nimoh";

let PI = 3.1314;

console.log(firstName + " " + lastName)
console.log(PI);

var country = 'Ghana';
var continent = 'Africa';
var population = 36000000;

console.log("Country: " + country);
console.log("Population: " + population);
console.log("Continent: " + continent);
*/

// DATA TYPES:
// Number: floating point numbers 
// String: Sequence of character 
// Boolean: Logical type that can only be true or false
// Undefine: Value taken by a variable that is not yet defined
// Null: ALso means an empty value
// Symbol: Value that is unique and cannot be change 
// BigInt: Larger integers than the number type can hold  
/*
true;
console.log(true);
console.log("-------")
let javascriptIsFun = true;
console.log(javascriptIsFun);
console.log("-------")
// Type of 
console.log(typeof true);
console.log(typeof javascriptIsFun);
console.log(typeof 23);
console.log(typeof "Gideon");

javascriptIsFun = "YES!";
console.log(javascriptIsFun);
console.log(typeof javascriptIsFun);

let year;
console.log(year);
console.log(typeof year);
year = 1991;
console.log('--------------');
console.log(year);
console.log(typeof year);

// Challenge for

let country = 'Ghana';
let continent = 'Africa';
let population = 36000000;
let isIsland = false;
let language;
console.log('--------------')
console.log(typeof isIsland);
console.log(typeof population);
console.log(typeof country);
*/

// let age = 30;
// age = 31; // Mutate the value of age

// const birthYear = 1990; // Immutable variable - it cannot be empty
// //const job; // will not work

// lastName = "Nimoh"; // Always declare variables properly
// console.log(lastName);

// OPERATORS //
// const now = 2037
// const ageGideon = now - 1990; //
// const ageSarah = now - 2018;

// // Math Operators
// console.log("Gideon is: " + ageGideon, "&  Sara is: " + ageSarah);
// console.log(ageGideon * 2, ageGideon / 10, 2 ** 3)

// Assignment operators
// let x = 12 + 10;
// x += 20;
// x *= 2;
// x /= 4;
// x++;
// x--;
// console.log(x);

// // Logical Operators
// console.log(ageGideon > ageSarah);
// console.log('----------------------------------------------------------------')
// console.log(now - 1991 > now - 2018);

// let b, y;
// b = y = 25 - 10 - 5;

// console.log(b, y);
// const averageAge = (ageGideon + ageSarah) / 2;
// console.log(ageGideon, ageSarah);
// console.log(averageAge)


// CODING CHALLENGE -
// let mass;
// let height;
// const BMI = mass / height ** 2;

// let markHeight = 1.69;
// let markMass = 78;
// let johnHeight = 1.95;
// let johnMass = 92;


// let markBmi = markMass / markHeight ** 2;
// let johnBmi = johnMass / johnHeight ** 2;


// console.log(markBmi, johnBmi);
// console.log(markBmi.toFixed(2) > johnBmi.toFixed(2))
// if (markBmi > johnBmi) {
//   console.log(`Mark's BMI ${markBmi.toFixed(2)} is higher than John's ${johnBmi.toFixed(2)}`);
// } else {
//   console.log(`John's BMI ${johnBmi.toFixed(2)} is higher than Mark's ${markBmi.toFixed(2)}`);
// }
// johnBmi = 85 / 1.76 ** 2;
// markBmi = 95 / 1.88 ** 2;
// console.log(markBmi.toFixed(2) > johnBmi.toFixed(2));

// if (markBmi < johnBmi) {
//   console.log(`John's BMI ${johnBmi.toFixed(2)} is higher than Mark's BMI ${markBmi.toFixed(2)}`);
// } else {
//   console.log(`Mark's BMI ${markBmi.toFixed(2)} is lower`);
// }


// const firstName = 'Gideon';
// const lastName = 'Student';
// const birthYear = 1990;
// const year = 2037;

// const gideon = "I'm " + firstName + ', a' + (year - birthYear) + " years and currently a " + lastName;

// //console.log(gideon);

// // template string 
// const gideonNew = `I'm ${firstName}, a ${year- birthYear} year old ${lastName}`;
// console.log(gideonNew);
// console.log(`Hello, world.....`)

// console.log(`This is a stinger
// with multiple
// lines`)

// const age = 16;
// const isOldEnough = age >= 18;

// if (age >= 18) {
//   console.log(`Ride on 🚖 !!!`);
// } else {
//   console.log(`You have to wait for ${18-age} more years: .....`);
// }


// const birthYear = 2012;
// let century;

// if (birthYear <= 2000) {
//   century = 20;
// } else {
//   century = 21;
// }

// console.log(`${century}st century`);

// const birthYear = '1990';
// console.log(birthYear);
// let newYear = Number(birthYear);
// console.log(Number(birthYear));
// console.log(newYear + 18);
// console.log('23' > '10' - 3 + '4');

// 5 Falsy values = 0, '', undefined, null, NaN

// console.log(Boolean(0));
// console.log(Boolean(undefined))
// console.log(Boolean('Gideon'))
// console.log(Boolean({}))
// console.log(Boolean(''))

// let money = 0;

// if (money) {
//   console.log("Don't spend it all")
// } else {
//   console.log("You should get a job")
// }

// let height = 0;

// if (height) {
//   console.log("Height is indeed DEFINED")
// } else {
//   console.log("No, Height is UNDEFINED")
// }

// const age = 18;

// if (age === 18) { // Strict equality === and Lose equality ==
//   console.log("This person is now an adult")
// } else {
//   console.log("This person is a MINOR")
// }

// let ans = Number(prompt("What is your name: "));
// console.log(ans);
// console.log(typeof ans);
// if (ans === 23) {
//   console.log(`Cool, ${ans} is correct!`);
// } else if (ans == 7) {
//   console.log("That is also correct");
// } else {
//   console.log("That is not an integer!");
// }

// const hasDriversLicense = true; // A
// const hasGoodVision = true; // B

// console.log(hasDriversLicense && hasGoodVision);
// console.log(hasDriversLicense || hasGoodVision);
// console.log(!hasDriversLicense && !hasGoodVision);
// console.log(hasDriversLicense && !hasGoodVision);
// console.log(!hasDriversLicense && !hasGoodVision);
// console.log(!hasDriversLicense || !hasGoodVision);


// const averageScoreDolphins = (97 + 112 + 101) / 3;
// const averageScoreKoalas = (109 + 95 + 123) / 3;
// console.log(averageScoreDolphins.toFixed(0), averageScoreKoalas.toFixed(0));

// const draw = averageScoreDolphins === averageScoreKoalas;

// // console.log(draw)

// if (averageScoreDolphins > averageScoreKoalas && averageScoreDolphins >= 100) {
//   console.log(`Dolphins won the game with a diff of ${averageScoreDolphins - averageScoreKoalas}pts`)
// } else if (averageScoreKoalas > averageScoreDolphins && averageScoreKoalas >= 100) {
//   console.log(`Koalas won with a diff of ${averageScoreKoalas-averageScoreDolphins}pts`);
// } else if (averageScoreDolphins === averageScoreKoalas && averageScoreKoalas >= 100 && averageScoreDolphins >= 100) {
//   console.log("Both wins the trophy")
// } else {
//   console.log("Draw")
// }

const day = 'Monday';
switch (day) {
  case 'Monday':
    console.log("condition is met")
    break;
  default:
    break;
}