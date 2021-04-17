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

const changeColor = (color) => {
  document.querySelector('body').style.backgroundColor = color;
}

const displayWinners = (widthSize, message) => {
  document.querySelector('.number').style.width = widthSize;
  document.querySelector('.number').textContent = message;
}

const changeScore = (score) => {
  document.querySelector('.score').textContent = score;
}


document.querySelector('.check').addEventListener('click', () => {
  const guess = Number(document.querySelector('.guess').value);
  if (!guess) {
    displayMessage('🛑 No Number');
    // When there is a correct guess
  } else if (guess === randomNumber) {
    displayMessage('Correct Number!');
    score++;
    changeColor('#60b347')
    displayWinners('45rem', 'Winner');

    if (score > highScore) {
      highScore = score;
      document.querySelector('.highscore').textContent = highScore;
    }

    // When the answer is too high
  } else if (guess !== randomNumber) {
    if (score > 1) {
      displayMessage((guess > randomNumber) ? '📈 Too High!' : 'Too Low!');
      score--;
      changeScore(score);
    } else {
      changeScore(0);
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
  changeScore(score);
  document.querySelector('body').style.backgroundColor = '#222';
  document.querySelector('.guess').value = '';
  displayWinners('15rem', '?')
});