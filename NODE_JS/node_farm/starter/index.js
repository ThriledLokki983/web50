const fs  = require('fs'); // objects with a lot of functions to be used

// const hello = 'Hello world';
// console.log(hello);

const textIn = fs.readFileSync('./txt/input.txt', 'utf-8');
console.log(textIn);

const textOut = `This is what we know about avocado: \n${textIn} \nCreated on: ${Date.now()}`
fs.writeFileSync('./txt/output.txt', textOut);
console.log('File written');