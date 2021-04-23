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
  // 	behavior: 'smooth
  // });

  section1.scrollIntoView({
    behavior: 'smooth',
  });
});

//  PAGE NAVIGATION

// document.querySelectorAll('.nav__link').forEach(function (el) {
// 	el.addEventListener('click', function (e) {
// 		e.preventDefault();
//
// 		const id = this.getAttribute('href');
// 		document.querySelector(id).scrollIntoView({
// 			behaviour: 'smooth'
// 		})
// 		// console.log(id);
// 	});
// });
// ------ EVENT DELEGATION
// 1. Add event addEventListener to common parent element
// 2. Determine what element generated the event
document.querySelector('.nav__links').addEventListener('click', function (e) {
  e.preventDefault();

  // Matching strategy -- to ignore clicks that are not within the range we want
  if (e.target.classList.contains('nav__link')) {
    const id = e.target.getAttribute('href');
    document.querySelector(id).scrollIntoView({
      behavior: 'smooth',
    });
  }
});

//TABBED COMPONENT

// tabs.forEach(e => e.addEventListener('click', () => console.log('TAB'))); Not efficient

// USe event delegation -- attach the event handler to the parent element that contains all the elements we want to work with
tabsContainer.addEventListener('click', function (e) {
  const clicked = e.target.closest('.operations__tab');

  // Guard clause
  if (!clicked) return;

  // Clear the active class from all elements that already has it
  tabs.forEach(t => t.classList.remove('operations__tab--active'));
  // Add it to the one that was clicked
  clicked.classList.add('operations__tab--active');

  // Clear all content active class form the elements and then add it to the selected button
  tabsContent.forEach(c => c.classList.remove('operations__content--active'));

  // Activate the content Area of the clicked button
  document
    .querySelector(`.operations__content--${clicked.dataset.tab}`)
    .classList.add('operations__content--active');

  // console.log(clicked.dataset.tab);
});

// MENU FADE ANIMATION
const handleHover = function (e) {
  // console.log(this, e.currentTarget);

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
};

// -- select the parent element
// nav.addEventListener('mouseover', function (e) {
// 	handleHover(e, 0.5);
// });
// Passing an argument into a handler
nav.addEventListener('mouseover', handleHover.bind(0.5));

// nav.addEventListener('mouseout', function (e) {
// 	handleHover(e, 1);
// });
nav.addEventListener('mouseout', handleHover.bind(1));

// STICKY NAVIGATION
// const initCoords = section1.getBoundingClientRect();
// console.log(initCoords);

// bad for performance esp - on mobile
// window.addEventListener('scroll', function (e) {
// 	console.log(window.scrollY);
// 	if (window.scrollY > initCoords.top) nav.classList.add('sticky')
// 	else nav.classList.remove('sticky');
// });

// Using the Intersection Observer API to implement the sticky navigation
// const obsCallback = function (entries, observer) {
// 	entries.forEach(t => {
// 		console.log(t);
// 	});
// };
//
// const obsOptions = {
// 	// first is the root property
// 	root: null,
// 	threshold: [0, 0.2],
// };
//
// const observer = new IntersectionObserver(obsCallback, obsOptions);
// observer.observe(section1);

const header1 = document.querySelector('.header');
const navHeight = nav.getBoundingClientRect().height;
// console.log(navHeight);

const stickyNav = function (entries) {
  const [entry] = entries;
  // console.log(entry);

  if (!entry.isIntersecting) nav.classList.add('sticky');
  else nav.classList.remove('sticky');
};

const headerObserver = new IntersectionObserver(stickyNav, {
  root: null,
  threshold: 0,
  rootMargin: `-${navHeight}px`,
});

headerObserver.observe(header1);
