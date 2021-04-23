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



// Styles
msg.style.backgroundColor = '#37383d';
msg.style.width = '120%'

console.log(msg.style.color);
console.log(msg.style.backgroundColor);

console.log(getComputedStyle(msg).color);
console.log(getComputedStyle(msg).height);

msg.style.height = Number.parseFloat(getComputedStyle(msg).height, 10) + 40 + 'px'
console.log(getComputedStyle(msg).height);

// CSS Custom Properties
document.documentElement.style.setProperty('--color-primary', 'yellow')

// STTRIBUTES // e.g. src, alt, class, id // standard attributes
const logo = document.querySelector('.nav__logo');
console.log(logo.alt);
console.log(logo.src);
console.log(logo.className);

// Set attributes
logo.alt = 'Beautiful minimalistic logo'


// Non standard attributes
logo.setAttribute('desiner', 'Gideon');
logo.setAttribute('desinger', 'Nimoh');
console.log(logo.desinger);
console.log(logo.getAttribute('desinger'));

const link = document.querySelector('.twitter-link');
console.log(link.href);
console.log(link.getAttribute('href'));


// Data Attributes

console.log(logo.dataset.versionNumber);


// CLASSES
logo.classList.add()
logo.classList.remove()
// logo.classList.toggle()
// logo.classList.constains()

// Don't use this, it overrides the already existing class
// logo.className = '..'







//////