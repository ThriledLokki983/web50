'use strict';

///////////////////////////////////////
// Modal window

const modal = document.querySelector('.modal');
const overlay = document.querySelector('.overlay');
const btnCloseModal = document.querySelector('.btn--close-modal');
const btnsOpenModal = document.querySelectorAll('.btn--show-modal');

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

const btnScrollTo = document.querySelector('.btn--scroll-to');
const section1 = document.querySelector('#section--1');

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