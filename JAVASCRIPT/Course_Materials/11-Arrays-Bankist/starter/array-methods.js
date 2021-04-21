'use strict';

// Methods on Arrays
let arr = ['a', 'b', 'c', 'd', 'e'];
let arr2 = [...arr];
console.log(arr2)

// Slice Method -- returns a new array with the extracted parts
console.log(arr.slice(2));
console.log(arr.slice(2, 4)); // the end parameter is not included in the returned array
console.log(arr.slice(-2)); // from the end of the original array
console.log(arr.slice(-1));
console.log(arr.slice(1, -2));

// Making a shallow copy of the Arrays
console.log(arr.slice());
console.log([...arr]);

// Splice Method -- this method mutates the original array
// console.log(arr.splice(2)); // takes part of the array and returns it while the original array loses the spliced Data
arr.splice(-1)
console.log(arr)
console.log(arr.splice(1, 2));
console.log(arr);

// Reverse Method -- Mutates the array
console.log(arr2.reverse());
console.log(arr2);

// Concat Method -- does not mutate the original array
const letters = arr.concat(arr2); // console.log([...arr, ...arr2])
console.log(letters);

// Join Method ---
console.log(letters.join(' - '));