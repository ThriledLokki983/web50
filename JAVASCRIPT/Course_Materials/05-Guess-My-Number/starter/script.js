'use strict';

// console.log(document.querySelector('.label-score').textContent);

// document.querySelector('.message').textContent = 'Correct Number 🎁'
// console.log(document.querySelector('.message').textContent = 'Correct Number 🎁');
// document.querySelector('.score').textContent = 'Scoring'
// document.querySelector('.number').textContent = '13'
// document.querySelector('.guess').value = 23;
// console.log(document.querySelector('.guess').value);

const number = Math.trunc(Math.random() * 20 + 1);

document.querySelector('.number').textContent = number;


document.querySelector('.check').addEventListener('click', () => {
  const guess = Number(document.querySelector('.guess').value);

  if (!guess) {
    document.querySelector('.message').textContent = '🛑 No Number'
    console.log("No value entered")
  }
  console.log(guess);
})