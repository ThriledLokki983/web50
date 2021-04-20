'use-strict';

const oneWord = (str) => {
	return str.replace(/ /g, '').toLowerCase();
}

const upperFirstWord = (str) => {
	const [first, ...others] = str.split(' ');
	return [first.toUpperCase(), ...others].join(' ');
};

// Higher-Order function
const transformer = (str, fnc) => {
	console.log(`${str}`);
	console.log(`Transformed string: ${fnc(str)}`);

	console.log(`Transformed by: ${fnc.name}`);
}

transformer('JavaScript is the best!', upperFirstWord);
transformer('JavaScript is the best!', oneWord);