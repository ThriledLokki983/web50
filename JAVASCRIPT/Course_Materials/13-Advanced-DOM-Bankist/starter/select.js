'use strict';

// How to select ELEMENTS
console.log(document.documentElement); // selectiong the entire html document
console.log(document.head);
console.log(document.body);

// QUESTION:
const header = document.querySelector('.header');
const nodeList = Array.from(document.querySelectorAll('.section'))
console.log(nodeList);

document.getElementById('section--1')
const btns = document.getElementsByTagName('button') // returns HTMLCollections // Live
console.log(btns);

const clas = document.getElementsByClassName('btn'); // also returns an HTMLCollections
console.log(clas);

// Creating and INserting Elements
// .inserAdjacentHTML -- create an HTML elements

const msg = document.createElement('div') // returns a DOM element
msg.classList.add('cookie-message');
msg.textContent = 'We use Cookies for Improving the user experience';
msg.innerHTML = 'We use Cookies for Improving the user experience<button class="btn btn--close--cookie">Got it!</button>';
header.prepend(msg);
header.append(msg); // There can only be one element ata time .
// header.append(msg.cloneNode(true));
header.before(msg);
// header.after(msg)
console.log(msg);

// Deleting elements
document.querySelector('.btn--close--cookie').addEventListener('click', function () {
	msg.remove();
	// msg.parentElement.removeChild(msg); // Old way of doing it -- DOM Traversing
});