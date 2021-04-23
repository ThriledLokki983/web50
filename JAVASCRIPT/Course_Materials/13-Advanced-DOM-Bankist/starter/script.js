'use strict';

///////////////////////////////////////
// Modal window

const modal = document.querySelector('.modal');
const overlay = document.querySelector('.overlay');
const btnCloseModal = document.querySelector('.btn--close-modal');
const btnsOpenModal = document.querySelectorAll('.btn--show-modal');
const btnScrollTo = document.querySelector('.btn--scroll-to');
const section1 = document.querySelector('#section--1');
const tabs = document.querySelectorAll('.operations__tab');
const tabsContainer = document.querySelector('.operations__tab-container');
const tabsContent = document.querySelectorAll('.operations__content');
const nav = document.querySelector('.nav');


const openModal = function (e) {
	e.preventDefault();

	modal.classList.remove('hidden');
	overlay.classList.remove('hidden');
};

const closeModal = function () {
	modal.classList.add('hidden');
	overlay.classList.add('hidden');
};

btnsOpenModal.forEach(btn => btn.addEventListener('click', openModal));

// for (let i = 0; i < btnsOpenModal.length; i++)
// 	btnsOpenModal[i].addEventListener('click', openModal);

btnCloseModal.addEventListener('click', closeModal);
overlay.addEventListener('click', closeModal);

document.addEventListener('keydown', function (e) {
	if (e.key === 'Escape' && !modal.classList.contains('hidden')) {
		closeModal();
	}
});

// Button Scrolling
btnScrollTo.addEventListener('click', e => {
	const s1coords = section1.getBoundingClientRect();
	// console.log(s1coords);
	// console.log(e.target.getBoundingClientRect());
	//
	// console.log('Current Scroll X/Y', window.pageXOffset, window.pageYOffset);
	// console.log('Hight and Width ViewPort', document.documentElement.clientHeight, document.documentElement.clientWidth);

	// Scrolling
	// window.scrollTo(s1coords.left + window.pageXOffset, // current position + current scroll
	// 	s1coords.top + window.pageYOffset);

	// Old way of doing it
	// window.scrollTo({
	// 	left: s1coords.left + window.pageXOffset,
	// 	top: s1coords.top + window.pageYOffset,
	// 	behavior: 'smootInt
	// });

	section1.scrollIntoView({
		behavior: 'smooth'
	});
});

//  PAGE NAVIGATION

// document.querySelectorAll('.nav__link').forEach(function (el) {
// 	el.addEventListener('click', function (e) {
// 		e.preventDefault();
//
// 		const id = this.getAttribute('href');
// 		document.querySelector(id).scrollIntoView({
// 			bahaviour: 'smooth'
// 		})
// 		// console.log(id);
// 	});
// });
// ------ EVENT DELEGATION
// 1. Add event addEventListener to common parent element
// 2. Determin what element generated the event
document.querySelector('.nav__links').addEventListener('click', function (e) {
	e.preventDefault();

	// Matching strategy -- to ignore clicks that are not within the range we want
	if (e.target.classList.contains('nav__link')) {
		const id = e.target.getAttribute('href');
		document.querySelector(id).scrollIntoView({
			behavior: 'smooth'
		});
	};
});


//TABBED COMPONENT


// tabs.forEach(e => e.addEventListener('click', () => console.log('TAB'))); Not efficient

// USe event delegation -- attach the event handler to the parent element that contains all the elemtns we want to work with
tabsContainer.addEventListener('click', function (e) {
	const clicked = e.target.closest('.operations__tab');

	// Guard clause
	if (!clicked) return;

	// Clear the active class from all elements that already has it
	tabs.forEach(t => t.classList.remove('operations__tab--active'));
	// Add it to the one that was clicked
	clicked.classList.add('operations__tab--active');

	// Clear all content active class form the elements and then add it to the selcted button
	tabsContent.forEach(c => c.classList.remove('operations__content--active'))

	// Activate the content Area of the clicked button
	document.querySelector(`.operations__content--${clicked.dataset.tab}`)
		.classList.add('operations__content--active');

	// console.log(clicked.dataset.tab);
});


// MENU FADE ANIMATION
const handleHover = function (e) {
	console.log(this, e.currentTarget);

	if (e.target.classList.contains('nav__link')) {
		const navLink = e.target;

		// Select the sibling elements
		const sibling = navLink.closest('.nav').querySelectorAll('.nav__link');
		const logo = navLink.closest('.nav').querySelector('img');

		sibling.forEach(el => {
			if (el !== navLink) el.style.opacity = this;
		});

		logo.style.opacity = this;
	}
}

// -- select the parenet element
// nav.addEventListener('mouseover', function (e) {
// 	handleHover(e, 0.5);
// });
// Passing an arugument into a handler
nav.addEventListener('mouseover', handleHover.bind(0.5));


// nav.addEventListener('mouseout', function (e) {
// 	handleHover(e, 1);
// });
nav.addEventListener('mouseout', handleHover.bind(1));







////