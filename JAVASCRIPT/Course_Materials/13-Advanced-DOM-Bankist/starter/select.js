'use strict';

// How to select ELEMENTS
console.log(document.documentElement); // selecting the entire html document
console.log(document.head);
console.log(document.body);

// QUESTION:
const header = document.querySelector('.header');
const nodeList = Array.from(document.querySelectorAll('.section'));
console.log(nodeList);

document.getElementById('section--1');
const btns = document.getElementsByTagName('button'); // returns HTMLCollections // Live
console.log(btns);

const clas = document.getElementsByClassName('btn'); // also returns an HTMLCollections
console.log(clas);

// Creating and INserting Elements
// .insertAdjacentHTML -- create an HTML elements

const msg = document.createElement('div'); // returns a DOM element
msg.classList.add('cookie-message');
msg.textContent = 'We use Cookies for Improving the user experience';
msg.innerHTML =
  'We use Cookies for Improving the user experience<button class="btn btn--close--cookie">Got it!</button>';
// header.prepend(msg);
// header.append(msg); // There can only be one element ata time .
// header.append(msg.cloneNode(true));
// header.before(msg);
// header.after(msg)
console.log(msg);

// Deleting elements
// document.querySelector('.btn--close--cookie').addEventListener('click', function () {
// 	msg.remove();
// 	// msg.parentElement.removeChild(msg); // Old way of doing it -- DOM Traversing
// });

// Styles
msg.style.backgroundColor = '#37383d';
msg.style.width = '120%';

console.log(msg.style.color);
console.log(msg.style.backgroundColor);

console.log(getComputedStyle(msg).color);
console.log(getComputedStyle(msg).height);

msg.style.height =
  Number.parseFloat(getComputedStyle(msg).height, 10) + 40 + 'px';
console.log(getComputedStyle(msg).height);

// CSS Custom Properties
// document.documentElement.style.setProperty('--color-primary', 'yellow')

// SET-ATTRIBUTES // e.g. src, alt, class, id // standard attributes
const logo = document.querySelector('.nav__logo');
console.log(logo.alt);
console.log(logo.src);
console.log(logo.className);

// Set attributes
logo.alt = 'Beautiful minimalistic logo';

// Non standard attributes
logo.setAttribute('designer', 'Gideon');
logo.setAttribute('designer', 'Nimoh');
console.log(logo.designer);
console.log(logo.getAttribute('designer'));

const link = document.querySelector('.twitter-link');
console.log(link.href);
console.log(link.getAttribute('href'));

// Data Attributes

console.log(logo.dataset.versionNumber);

// CLASSES
logo.classList.add();
logo.classList.remove();
// logo.classList.toggle()
// logo.classList.contains()

// Don't use this, it overrides the already existing class
// logo.className = '..'

// EVENTS & EVENT HANDLERS
const h1 = document.querySelector('h1');

const alertH1 = e => {
  // function called when a mouse hovers over an element
  alert('addEventListener: Got ya');

  // h1.removeEventListener('mouseenter', alertH1);
};

h1.addEventListener('mouseenter', alertH1);

setTimeout(() => h1.removeEventListener('mouseenter', alertH1), 3000);

// h1.onmouseenter = function (e) {
// 	alert('addEventListener: Got ya')
// }

// Event Propagation
// BUBBLING

const randomInt = (min, max) => Math.floor(Math.random() * (max - min) + min);
const randomColor = () =>
  `rgb(${randomInt(0, 255)}, ${randomInt(0, 255)}, ${randomInt(0, 255)})`;
// console.log(randomColor(0, 255));

// document.querySelector('.nav__links').addEventListener('click', function (e) {
// 	this.style.backgroundColor = randomColor();
// 	console.log('CONTAINER', e.target, e.currentTarget);
// 	console.log(e.currentTarget === this);
// 	console.log(e.target === this);
//
//
// });
//
// document.querySelector('.nav__link').addEventListener('click', function (e) {
// 	this.style.backgroundColor = randomColor();
// 	console.log('LINK', e.target, e.currentTarget); // TARGET not the element but where the event happened
// 	console.log(e.currentTarget === this);
// 	console.log(e.target === this);
//
// 	// Stopping the event Propagation
// 	e.stopPropagation(); // In practice, this is not ideal/ good idea
// });
//
// document.querySelector('.nav').addEventListener('click', function (e) {
// 	this.style.backgroundColor = randomColor();
// 	console.log('NAV', e.target, e.currentTarget);
// 	console.log(e.currentTarget === this);
// 	console.log(e.target === this);
// });

// DOM-TRAVERSING

console.log(h1.querySelectorAll('.highlight'));
console.log(h1.childNodes);
console.log(h1.children); // only for direct children
// h1.firstElementChild.style.color = 'white'
// h1.lastElementChild.style.color = 'orangered';
console.log(h1.firstElementChild);

// Going Upwards
console.log(h1.parentNode);
console.log(h1.parentElement);
console.log(h1.closest('.header'));
// h1.closest('.header').style.background = 'white'

// h1.closest('h1').style.background = 'yellow'

// Going Sideways == selecting siblings

console.log(h1.previousElementSibling);
console.log(h1.nextElementSibling);

console.log(h1.previousSibling);
console.log(h1.nextSibling);

console.log(h1.parentElement.children);

[...h1.parentElement.children].forEach(function (el) {
  if (el === h1) {
    // el.style.transform = 'scale(0.5)'
  }
});

//LAZY LOADING OF IMAGES

// LIFE CYCLE OF WEB PAGES
// DOM Content Loader

document.addEventListener('DOMContentLoaded', function (e) {
  console.log(e);
});

window.addEventListener('load', function (e) {
  console.log(e);
});

// window.addEventListener('beforeunload', function (e) {
//   e.preventDefault();
//   console.log(e);
//   e.returnValue = '';
// });

// Efficient ways of Loading script into the HTML file

// REGULAR
// Script src = "script.js">

// NEVER Include a script in the HEAD
// it causes the Parsing of the HTML to wait for [Fetching and executing the script] before it continues with Finishing the Parsing of the HTML document (DOMContentLoaded) -- However, when put at the end of the HTML file, the process is like this: PARSING HTML ==> FETCH SCRIPT ==> EXECUTE: (also not an ideal option bcos we could have fetched the script while parsing the html)

// ASYNC  																			<script async src="script.js"></script>
// Process when done like this
// HEAD: PARSING HTML ==> WAIT ==> FINISH PARSING HTML (Here, while the html is being parsed, the script is fetched asynchronously, when done, it will have to be executed before html can finish parsing)

// DEFER																			<script defer src="script.js"></script>
// HEAD: PARSING HTML ==> EXECUTE (Here, Html code is parsed and finished while asynchronously fetched the script but only executed when HTML is done parsing)
