// import icons from '../img/icons.svg' // Parcel 1
import * as model from './model.js';
import recipeView from './view/recipeView.js';
import searchView from './view/searchView.js';
import resultsView from './view/resultView.js';
import paginationView from './view/paginationView.js';
import 'core-js/stable'; // polyfiling everything else
import 'regenerator-runtime/runtime'; // Polyfiling async await

if (module.hot) {
  module.hot.accept();
}

// https://forkify-api.herokuapp.com/v2

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
    recipeView.renderError();
  }
};

const controlSearchResults = async function () {
  try {
    resultsView.renderSpinner();

    // Getting the search query
    const query = searchView.getQuery();
    if (!query) return;

    // Loading search results
    await model.loadSearchResults(query);

    // Rendering the searched results
    // resultsView.render(model.state.search.results);
    resultsView.render(model.getSearchResultsPage());

    // Render initial pagination 
    paginationView.render(model.state.search);

  } catch (err) {
    console.log(err);
  }
};

const controlPagination = function (goToPage) {
  // Render NEW results
  resultsView.render(model.getSearchResultsPage(goToPage));

  // Render NEW Pagination Results
  paginationView.render(model.state.search);
}

const controlServings = function (newServings) {
  // Update the recipe servings (in state)
  model.updateServings(newServings);

  // Update the recipe view
  // recipeView.render(model.state.recipe);
  recipeView.update(model.state.recipe);

}

const init = function () {
  recipeView.addHandlerRender(controlRecipes);
  recipeView.addHandlerUpdateServings(controlServings);
  searchView.addHandlerSearch(controlSearchResults);
  paginationView.addHandlerClick(controlPagination);

};
init();