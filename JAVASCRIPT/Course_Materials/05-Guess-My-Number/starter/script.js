'use strict';

// console.log(document.querySelector('.label-score').textContent);

// document.querySelector('.message').textContent = 'Correct Number 🎁'
// console.log(document.querySelector('.message').textContent = 'Correct Number 🎁');
// document.querySelector('.score').textContent = 'Scoring'
// document.querySelector('.number').textContent = '13'
// document.querySelector('.guess').value = 23;
// console.log(document.querySelector('.guess').value);

let randomNumber = Math.trunc(Math.random() * 20 + 1);
let score = 20;
let highScore = 0;

const displayMessage = (message) => {
  document.querySelector('.message').textContent = message;
}


document.querySelector('.check').addEventListener('click', () => {
  const guess = Number(document.querySelector('.guess').value);

  if (!guess) {
    displayMessage('🛑 No Number');
    console.log("No value entered")

    // When there is a correct guess
  } else if (guess === randomNumber) {
    displayMessage('Correct Number!');
    score++;
    document.querySelector('body').style.backgroundColor = '#60b347';
    document.querySelector('.number').style.width = '45rem'
    document.querySelector('.number').textContent = 'Winner!'

    if (score > highScore) {
      highScore = score;
      document.querySelector('.highscore').textContent = highScore;
    }

    // When the answer is too high
  } else if (guess !== randomNumber) {
    if (score > 1) {
      document.querySelector('.message').textContent = (guess > randomNumber) ? '📈 Too High!' : 'Too Low!'
      score--;
      document.querySelector('.score').textContent = score;
    } else {
      document.querySelector('.score').textContent = 0;
      displayMessage('🔥 Game Over');
    }
    document.querySelector('body').style.backgroundColor = 'red';
  }

  // else if (guess > randomNumber) {

  //   // When the guess is too low
  // } else if (guess < randomNumber) {
  //   if (score > 1) {
  //     document.querySelector('.message').textContent = '📉 Too Low!'
  //     score--;
  //     document.querySelector('.score').textContent = score;
  //   } else {
  //     document.querySelector('.score').textContent = 0;
  //     document.querySelector('.message').textContent = '🔥 Game Over'
  //   }
  //   document.querySelector('body').style.backgroundColor = 'red';
  // }
});

document.querySelector('.again').addEventListener('click', () => {
  randomNumber = Math.trunc(Math.random() * 20 + 1);
  score = 20
  displayMessage('Start guessing...');
  document.querySelector('.score').textContent = score;
  document.querySelector('body').style.backgroundColor = '#222';
  document.querySelector('.guess').value = '';
  document.querySelector('.number').style.width = '15rem';
  document.querySelector('.number').textContent = '?';
});