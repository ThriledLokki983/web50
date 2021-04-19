const game = {
  team1: 'Bayern Munich',
  team2: 'Borrussia Dortmund',
  players: [
    [
      'Neuer',
      'Pavard',
      'Martinez',
      'Alaba',
      'Davies',
      'Kimmich',
      'Goretzka',
      'Coman',
      'Muller',
      'Gnarby',
      'Lewandowski',
    ],
    [
      'Burki',
      'Schulz',
      'Hummels',
      'Akanji',
      'Hakimi',
      'Weigl',
      'Witsel',
      'Hazard',
      'Brandt',
      'Sancho',
      'Gotze',
    ],
  ],
  score: '4:0',
  scored: ['Lewandowski', 'Gnarby', 'Lewandowski', 'Hummels'],
  date: 'Nov 9th, 2037',
  odds: {
    team1: 1.33,
    x: 3.25,
    team2: 6.5,
  },
};


// Q1 - Loop over game.scored array and print each player name to the console,
// along with the goal number (e.g. "Goal 1: Lewandowski")

for(let [index, player] of game.scored.entries()){
  console.log(`Goal ${index + 1}: ${player}`);
}

// Q2 - Use loop to calculate the average odd and log it to the console
const {odds} = game;
let sum = 0
let values =  Object.values(odds);
for (var i = 0; i < values.length; i++) {
  sum += values[i];
}
console.log(`Average Odd: ${(sum/values.length).toFixed(2)}`);

// Q3 - Print the 3 Odds to the console like (e.g. Odds of Victory = Bayern)
let allOdds = Object.entries(odds);
let openStr = `Odd of victory`
for(let [key, value] of allOdds){
  console.log(openStr + ` ${value < 1.34 ? 'Baryern Munich ' + value : 'Borrussia Dortmund ' + value}`)
}
console.log('=======================================================')
for(const [team, odd] of allOdds){
  const teamStr = team === 'x' ? 'draw' : `victory ${game[team]}`
  // console.log(teamStr)
  console.log(`Odd of ${teamStr} ${odd}`);
}

// BONUS // QUESTION:

const scores = Object.entries (game.scored);
console.log(scores);
let obj = Object.assign({}, scores);
