'use strict';

// Selecting elements
const player0El = document.querySelector('.player--0');
const score0El = document.getElementById('score--0');
const current0El = document.getElementById('current--0');
const score1El = document.getElementById('score--1');
const current1El = document.getElementById('current--1');
const player1El = document.querySelector('.player--1');
const diceEl = document.querySelector('.dice');
const btnNew = document.querySelector('.btn--new');
const btnRoll = document.querySelector('.btn--roll');
const btnHold = document.querySelector('.btn--hold');

// Global variables
let scores, currentScore, activePlayer, isPlaying;

const init = () => {
  scores = [0, 0];
  currentScore = 0;
  activePlayer = 0;
  isPlaying = true;

  score0El.textContent = 0;
  score1El.textContent = 0;
  current0El.textContent = 0;
  current1El.textContent = 0;

  diceEl.classList.add('hidden');
  player0El.classList.remove('player--winner');
  player1El.classList.remove('player--winner');
  player0El.classList.add('player--active');
  player1El.classList.remove('player--active');
};
init();

const switchPlayer = () => {
  document.getElementById(`current--${activePlayer}`).textContent = 0;
  currentScore = 0;
  activePlayer = activePlayer === 0 ? 1 : 0;
  player0El.classList.toggle("player--active"); // check if active is already there or not and decide accordingly whether to add it or not
  player1El.classList.toggle("player--active");
}

// Starting Game conditions
score0El.textContent = 0;
score1El.textContent = 0;
diceEl.classList.add('hidden');



// Rolling of the Dice Functionality
btnRoll.addEventListener('click', () => {
  if (isPlaying) {
    // Generate a Random dice roll and display the dice and then check if roll is 1. if so, switch player
    const dice = Math.trunc(Math.random() * 6) + 1;
    diceEl.classList.remove('hidden');
    diceEl.src = `dice-${dice}.png`;
    if (dice !== 1) {
      // Add dice roll to player's score
      currentScore += dice;
      document.getElementById(`current--${activePlayer}`).textContent = currentScore;
    } else {
      // Switch player
      switchPlayer();
    }
  }
})

btnHold.addEventListener("click", () => {
  // 1. Add current score to active player's score and 2. check if score is >= 100, 3. finish the game or switch player
  if (isPlaying) {
    scores[activePlayer] += currentScore;
    document.getElementById(`score--${activePlayer}`).textContent = scores[activePlayer];
    if (scores[activePlayer] >= 20) {
      isPlaying = false;
      document.querySelector(`.player--${activePlayer}`).classList.add('player--winner');
      document.querySelector(`.player--${activePlayer}`).classList.add('player--active');
      diceEl.classList.add('hidden');
    } else {
      switchPlayer();
    }
  }
})

btnNew.addEventListener('click', init)