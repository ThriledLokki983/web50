// Remember, we're gonna use strict mode in all scripts now!
'use strict';

const temperature = [3, -2, -6, -1, 'error', 9, 13, 17, 15, 14, 9, 5];
// Calculate the temperature amplitude (difference between highest and lowest temperature)
// 1.) Understanding the Problem
// How to compute min and max temperature from an array?
// what is a sensor error?

// 2.) Breaking up the Problem into Sub-problems
// - How to ignore the sensor error
// - Find Min value from the array
// - FInd Max value from the array
// - Subtract min from max and return item

// write our function to

// const calcTempAmplitude = (temp) => {
//   let max = temp[0];
//   let min = temp[0];
//   for (let i = 1; i < temp.length; i++) {
//     const currentTemp = temp[i];
//     if (typeof currentTemp !== 'number') {
//       continue;
//     }
//     if (currentTemp > max) {
//       max = currentTemp;
//     }
//     if (currentTemp < min) {
//       min = currentTemp;
//     }
//   }
//   //console.log(max, min);
//   return max - min;
// }

// calcTempAmplitude([9, 16, 6, 8, 3])
// const amplitude = console.log(calcTempAmplitude(temperature));

// const measureKelvin = () => {
//   const measurement = {
//     type: 'temp',
//     unit: 'celsius',
//     value: Number(prompt('Degrees celsius: '))
//   };

//   const kelvin = measurement.value + 273;
//   return kelvin;
// }

// console.log(measureKelvin());
//console.log('\u00B0');

const test1 = [17, 21, 23];
const test2 = [12, 5, -5, 0, 4];

const printForecast = (arr) => {
  for (let i = 0; i < arr.length; i++) {
    console.log(`${arr[i] + '\u00B0' + 'C'} in ${i+1} ${(i+1) > 1 ? 'days ...' : 'day ...'}`);
  }
}

printForecast(test1);
console.log("=====================");
printForecast(test2);