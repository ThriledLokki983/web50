'use-strict';

const oneWord = (str) => {
	return str.replace(/ /g, '').toLowerCase();
}

const upperFirstWord = (str) => {
	const [first, ...others] = str.split(' ');
	return [first.toUpperCase(), ...others].join(' ');
};

// Higher-Order function // Function that takes another function
const transformer = (str, fnc) => {
	console.log(`${str}`);
	console.log(`Transformed string: ${fnc(str)}`);

	console.log(`Transformed by: ${fnc.name}`);
}

transformer('JavaScript is the best!', upperFirstWord);
transformer('JavaScript is the best!', oneWord);


// Higher-Order function // Function that returns another function
const greet = (greeting) => { // this works bcos of closures
	return function (name) {
		console.log(`${greeting} ${name}`)
	}
}
let name = (n) => console.log(`${n}`);

const greeter = greet('Hey');
greeter('Gideon');
greeter('Ama');

greet('Hello')('Gideon Nimoh')

// Rewrite the greet function only with Arrow function
const greet2 = (greeting) => (n) => console.log(`${greeting} ${n}`);

greet2('Hoi')('Gideon')