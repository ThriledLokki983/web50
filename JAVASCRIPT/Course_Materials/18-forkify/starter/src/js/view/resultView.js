import View from './View.js'
import icons from 'url:../../img/icons.svg'; // Parcel 2
import previewView from './previewView.js'

class ResultView extends View {
    _parentElement = document.querySelector('.results');
    _errorMessage = 'No recipes found. Please try again!'
    _successMessage = '';

    _generateMarkup() {
      return this._data.map(result => previewView.render(result, false)).join('');
  }
}

export default new ResultView();