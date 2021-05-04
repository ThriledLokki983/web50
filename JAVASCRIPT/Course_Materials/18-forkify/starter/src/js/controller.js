// import icons from '../img/icons.svg' // Parcel 1
import * as model from './model.js';
import {MODAL_CLOSE_SEC} from './config.js'
import recipeView from './view/recipeView.js';
import searchView from './view/searchView.js';
import resultsView from './view/resultView.js';
import bookmarkView from './view/bookmarksView.js';
import paginationView from './view/paginationView.js';
import addRecipeView from './View/addRecipeView.js';
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
    
    // update resultview to mark the selected search result
    resultsView.update(model.getSearchResultsPage());

    // Updating the bookmarksView
    bookmarkView.update(model.state.bookmarks);
    
    // Loading Recipe
    await model.loadRecipe(id);
    
    // Rendering Recipe
    recipeView.render(model.state.recipe);
    
  
  } catch (error) {
    recipeView.renderError();
    con
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

const controlAddbookmark = function (){
  // Add/Remove bookmark
  if(!model.state.recipe.bookmarked) model.addBookmark(model.state.recipe);
  else model.deleteBookmark(model.state.recipe.id);

  // Update recipeView
  recipeView.update(model.state.recipe);

  //Render bookmarks
  bookmarkView.render(model.state.bookmarks);
}

const controlBookmarks = function (){
  bookmarkView.render(model.state.bookmarks);
}

const controlAddRecipe = async function (newRecipe){
  try {
    // Show loading Soinner
    addRecipeView.renderSpinner()


    await model.uploadRecipe(newRecipe);
    console.log(model.state.recipe);

    // Render 
    recipeView.render(model.state.recipe);

    // Success message
    addRecipeView.renderMessage();

    // Render the bookmarkview
    bookmarkView.render(model.state.bookmarks);

    // Change url ID
    window.history.pushState(null, '', `#${model.state.recipe.id}`);
    // window.history.back()

    // close form window
    setTimeout(function(){
      addRecipeView.toggleWindow();
    }, MODAL_CLOSE_SEC * 1000);
  } catch (err) {
    console.log('🔥', err)
    addRecipeView.renderError(err.message);
  }
}

const init = function () {
  bookmarkView.addHandlerRender(controlBookmarks);
  recipeView.addHandlerRender(controlRecipes);
  recipeView.addHandlerUpdateServings(controlServings);
  recipeView.addHandlerAddBookmark(controlAddbookmark);
  searchView.addHandlerSearch(controlSearchResults);
  paginationView.addHandlerClick(controlPagination);
  addRecipeView._addHandlerUpload(controlAddRecipe);
};
init();


/**
 * IMPROVEMENTS: (EASY)
 * Display number of pages between the pagination buttons
 * Ability to sort search results by duration or number of ingredients
 * Perform ingredient validation in view, before submitting the form
 * Improve recipe ingredient input: Separate in multiple fields and laoow more that 6 ingredients
 * 
 * IMPROVEMENTS: (HARD)
 * Shopping list feature: button on recipe to add ingredients to a list;
 * Weekly meal planning feature: assign recipes to the next 7 days and show on a weekly calendar
 * Get nutrition data on each ingredient from spoonacular API (https://spoonacular.com/food-api) and calculate calories of recipe.
 * **Possibilities are endless**
 */