// import icons from '../img/icons.svg' // Parcel 1
import * as model from './model.js';
import recipeView from './view/recipeView.js';
import searchView from './view/searchView.js';
import resultsView from './view/resultView.js';
import 'core-js/stable'; // polyfiling everything else
import 'regenerator-runtime/runtime'; // Polyfiling async await

// if (module.hot) {
//   module.hot.accept();
// }

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
    recipeView.renderError()
  }
}

const controlSearchResults = async function () {
  try {
    resultsView.renderSpinner();

    // Getting the search query
    const query = searchView.getQuery();
    if (!query) return;

    // Loading search results
    await model.loadSearchResults(query);

    // Rendering the searched results
    console.log(model.state.search.results);
    // resultsView.render(model.state.search.results);
    resultsView.render(model.getSearchResultsPage());

  } catch (err) {
    console.log(err)
  }
}


const init = function () {
  recipeView.addHandlerRender(controlRecipes);
  searchView.addHandlerSearch(controlSearchResults);
};
init();