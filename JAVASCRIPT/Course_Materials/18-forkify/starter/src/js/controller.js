// import icons from '../img/icons.svg' // Parcel 1
import * as model from './model.js';
import recipeView from './view/recipeView.js';
import 'core-js/stable'; // polyfiling everything else
import 'regenerator-runtime/runtime'; // Polyfiling async await

const recipeContainer = document.querySelector('.recipe');

const timeout = function (s) {
  return new Promise(function (_, reject) {
    setTimeout(function () {
      reject(new Error(`Request took too long! Timeout after ${s} second`));
    }, s * 1000);
  });
};

// https://forkify-api.herokuapp.com/v2

///////////////////////////////////////

const controlRecipes = async function () {
  try {
    const id = window.location.hash.slice(1);

    if (!id) return;
    recipeView.renderSpinner();

    // Loading Recipe
    await model.loadRecipe(id);

    // Rendering Recipe
    recipeView.render(model.state.recipe);


  } catch (error) {
    alert(error);
  }
}
// controlRecipes();
// ['hashchange', 'load'].forEach(ev => window.addEventListener(ev, controlRecipes));
window.addEventListener('hashchange', controlRecipes);
window.addEventListener('load', controlRecipes);