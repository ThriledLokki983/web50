'use-strict';

const flight = 'LH123';
const gideon = {
	name: 'Gideon Nimoh',
	passport: 1234567890,
}

const checkIn = (flightNum, passenger) => {
	flightNum = 'LH999',
		passenger.name = 'Mr. ' + passenger.name;

	if (passenger.passport === 1234567890) {
		alert("Checked In");
	} else {
		alert("Wrong passport");
	}
}
checkIn(flight, gideon);
console.log(flight);
console.log(gideon);