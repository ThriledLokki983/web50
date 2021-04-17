'use strict';

const modal = document.querySelector('.modal');
const overlay = document.querySelector('.overlay');
const btnCloseModal = document.querySelector('.close-modal');
const openModal = document.querySelectorAll('.show-modal');

const closeModal = () => {
  modal.classList.add('hidden');
  overlay.classList.add('hidden');
}

const openTheModal = () => {
  modal.classList.remove('hidden');
  overlay.classList.remove('hidden');
}

for (let i = 0; i < openModal.length; i++) {
  openModal[i].addEventListener('click', openTheModal)
}

btnCloseModal.addEventListener('click', closeModal);
overlay.addEventListener('click', closeModal);