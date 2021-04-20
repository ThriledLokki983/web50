'use-strict';

// Coding Challenge #1

/*
Let's build a simple poll app!

A poll has a question, an array of options from which people can choose, and an array with the
number of replies for each option. This data is stored in the starter object below.

Here are your tasks:

1. Create a method called 'registerNewAnswer' on the 'poll' object. The method does 2 things:
  1.1. Display a prompt window for the user to input the number of the selected option.
  The prompt should look like this:
        What is your favourite programming language?
        0: JavaScript
        1: Python
        2: Rust
        3: C++
        (Write option number)

  1.2. Based on the input number, update the answers array. For example, if the option is 3,
  increase the value AT POSITION 3 of the array by 1. Make sure to check if the input is a number and
  if the number makes sense (e.g answer 52 wouldn't make sense, right?)
2. Call this method whenever the user clicks the "Answer poll" button.
3. Create a method 'displayResults' which displays the poll results. The method takes a string as an
input (called 'type'), which can be either 'string' or 'array'. If type is 'array', simply display the
results array as it is, using console.log(). This should be the default option. If type is 'string',
display a string like "Poll results are 13, 2, 4, 1".
4. Run the 'displayResults' method at the end of each 'registerNewAnswer' method call.

HINT: Use many of the tools you learned about in this and the last section 😉

BONUS: Use the 'displayResults' method to display the 2 arrays in the test data. Use both the
'array' and the 'string' option. Do NOT put the arrays in the poll object! So what shoud the this
keyword look like in this situation?

BONUS TEST DATA 1: [5, 2, 3]
BONUS TEST DATA 2: [1, 5, 3, 9, 6, 1]

GOOD LUCK 😀
*/

const poll = {
	question: 'What is your favourite programming language?',
	options: ['0: Javascript', '1: Python', '2: Rust', '3: C++'],
	answers: new Array(4).fill(0), // creates an array[0,0,0,0]

	registerNewAnswer() {
		// Get answer
		const answer = Number(prompt(`${this.question}\n${this.options.join('\n')}\n(Write option number)`));
		console.log(answer);

		// Register answers
		typeof answer === 'number' && answer < this.options.length && this.answers[answer]++; // use of short circuiting
		this.displayResults();
		this.displayResults('string');
	},

	displayResults(type = 'array') {
		type === 'array' ? console.log(this.answers) : console.log(`Poll results are ${this.answers.join(', ')}`)
	}

};

document.querySelector('.poll').addEventListener('click', poll.registerNewAnswer.bind(poll));

poll.displayResults.call({
	answers: [5, 2, 3]
}, 'string');

poll.displayResults.call({
	answers: [1, 5, 3, 9, 6, 1]
}, 'string');

poll.displayResults.call({
	answers: [1, 5, 3, 9, 6, 1]
});

// BONUS TEST DATA 1: [5, 2, 3]
// BONUS TEST DATA 2: [1, 5, 3, 9, 6, 1]
// registerNewAnswer() {
// 	let str = '';
// 	for (let [index, answer] of this.options.entries()) {
// 		const [i, ans] = answer.split(' ');
// 		str += `${index}: ${ans} \n`;
// 	}
// 	const ans = Number(prompt(`${this.question} \n${str}(Write option number)`))
// 	typeof ans === 'number' && ans < this.answers.length ? console.log(`${this.answers[ans] = this.answers[ans]+1}`) : console.log(`Incorrect Selection`);
// 	console.log(ans, this.answers);
// },
//
// displayResults(type) {
// 	// displays the poll results.
// 	typeof type === 'Arrays' ? console.log(`Array`) : console.log(`...type`);
//
// },