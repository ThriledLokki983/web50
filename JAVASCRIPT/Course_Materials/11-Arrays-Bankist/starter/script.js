'use strict';

/////////////////////////////////////////////////
/////////////////////////////////////////////////
// BANKIST APP

// Data
const account1 = {
	owner: 'Jonas Schmedtmann',
	movements: [200, 450, -400, 3000, -650, -130, 70, 1300],
	interestRate: 1.2, // %
	pin: 1111,
};

const account2 = {
	owner: 'Jessica Davis',
	movements: [5000, 3400, -150, -790, -3210, -1000, 8500, -30],
	interestRate: 1.5,
	pin: 2222,
};

const account3 = {
	owner: 'Steven Thomas Williams',
	movements: [200, -200, 340, -300, -20, 50, 400, -460],
	interestRate: 0.7,
	pin: 3333,
};

const account4 = {
	owner: 'Sarah Smith',
	movements: [430, 1000, 700, 50, 90],
	interestRate: 1,
	pin: 4444,
};

const accounts = [account1, account2, account3, account4];

// Elements
const labelWelcome = document.querySelector('.welcome');
const labelDate = document.querySelector('.date');
const labelBalance = document.querySelector('.balance__value');
const labelSumIn = document.querySelector('.summary__value--in');
const labelSumOut = document.querySelector('.summary__value--out');
const labelSumInterest = document.querySelector('.summary__value--interest');
const labelTimer = document.querySelector('.timer');

const containerApp = document.querySelector('.app');
const containerMovements = document.querySelector('.movements');

const btnLogin = document.querySelector('.login__btn');
const btnTransfer = document.querySelector('.form__btn--transfer');
const btnLoan = document.querySelector('.form__btn--loan');
const btnClose = document.querySelector('.form__btn--close');
const btnSort = document.querySelector('.btn--sort');

const inputLoginUsername = document.querySelector('.login__input--user');
const inputLoginPin = document.querySelector('.login__input--pin');
const inputTransferTo = document.querySelector('.form__input--to');
const inputTransferAmount = document.querySelector('.form__input--amount');
const inputLoanAmount = document.querySelector('.form__input--loan-amount');
const inputCloseUsername = document.querySelector('.form__input--user');
const inputClosePin = document.querySelector('.form__input--pin');


const displayTransactions = function (transactions) { // pass the data into the function rather than using directly a global variable
	containerMovements.innerHTML = '';
	transactions.forEach(function (mov, i) {
		const type = mov > 0 ? 'deposit' : 'withdrawal';
		const html = `
    <div class="movements__row">
      <div class="movements__type movements__type--${type}">${i+1} ${type} </div>
      <div class="movements__value">${mov}€</div>
    </div>`;
		containerMovements.insertAdjacentHTML('afterbegin', html) // afterbegin & beforeend
	})
}
// displayTransactions(account1.movements);

const calcDisplayTransactions = acc => {
	acc.balance = acc.movements.reduce((initial, current) => initial + current, 0);
	labelBalance.textContent = `${acc.balance}€`;
};
calcDisplayTransactions(account1);

const createUser = function (accs) {
	accs.forEach(function (ac) {
		ac.username = ac.owner
			.toLowerCase()
			.split(' ')
			.map((name) => name[0]).join('');
	})
}
createUser(accounts);
// console.log(accounts);

//Update UI
const updateUI = (acc) => {
	// display Transactions
	calcDisplayTransactions(acc);
	// Display Balance
	displayTransactions(acc.movements);

	// Display Summary
	calcDisplaySummary(acc);
}

const calcDisplaySummary = (acc) => {
	const deposits = acc.movements
		.filter(curr => curr > 0)
		.reduce((acc, current) => acc + current, 0);
	const withdrawals = acc.movements
		.filter((curr) => curr < 0)
		.reduce((acc, current) => acc + current, 0);
	const interest = acc.movements
		.filter((item) => item > 0)
		.map((deposit) => deposit * acc.interestRate / 100)
		.filter((curr) => curr >= 1)
		.reduce((acc, int) => acc + int, 0);

	labelSumIn.textContent = `${deposits} €`;
	labelSumOut.textContent = `${Math.abs(withdrawals)} €`;
	labelSumInterest.textContent = `${(Math.abs(interest)).toFixed(2)} €`;
}
// calcDisplaySummary(account1.movements);

// Event Listeners
let currentAccount;

btnLogin.addEventListener('click', e => {
	// Prevents form from submitting
	e.preventDefault();

	currentAccount = accounts.find(acc => acc.username === inputLoginUsername.value);

	// console.log(currentAccount);

	// Using optional Chaining to check if user account exist or not before checking the PIN
	// currentAccount?.pin === Number(inputLoginPin.value) ? console.log('LOGIN') : console.log('WRONG');
	if (currentAccount?.pin === Number(inputLoginPin.value)) {
		// display UI and message
		labelWelcome.textContent = `Welcome back, ${currentAccount.owner.split(' ')[0]}`

		containerApp.style.opacity = 100;

		// Clear input fields
		inputLoginUsername.value = inputLoginPin.value = '';
		inputLoginPin.blur();

		//UPDATING UI
		updateUI(currentAccount);

	}
});

btnTransfer.addEventListener('click', e => {
	e.preventDefault();
	const amount = Number(inputTransferAmount.value);
	const receiverAccount = accounts.find(acc => acc.username === inputTransferTo.value);
	// console.log(amount, receiverAccount);

	inputTransferAmount.value = inputTransferTo.value = '';

	// check for errors
	if (amount > 0 && receiverAccount && currentAccount.balance >= amount && receiverAccount?.username !== currentAccount.username) {
		currentAccount.movements.push(-amount);
		receiverAccount.movements.push(amount);
	}
	// UPDATING UI
	updateUI(currentAccount);
});


btnLoan.addEventListener('click', e => {
	e.preventDefault();

	const amount = Number(inputLoanAmount.value);
	let currAmount = currentAccount.movements;

	if (amount > 0 && currAmount.some(mov => mov >= (amount * 0.1))) {
		// Add transaction
		currAmount.push(amount);

		// Update UI
		updateUI(currentAccount);
	}
	inputLoanAmount.value = '';
});


btnClose.addEventListener('click', e => {
	e.preventDefault();
	const user = inputCloseUsername.value;
	const pin = Number(inputClosePin.value);

	// checking for credentials
	if (user === currentAccount.username && pin === currentAccount.pin) {
		const index = accounts.findIndex(acc => acc.username === currentAccount.username);
		// console.log(index);

		// Delete Account
		accounts.splice(index, 1);

		// Hide UI
		containerApp.style.opacity = 0;
	}
	// Clear the fields
	inputClosePin.value = inputCloseUsername.value = '';
});