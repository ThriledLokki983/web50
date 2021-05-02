import View from './View.js'
import icons from 'url:../../img/icons.svg'; // Parcel 2
import previewView from './previewView.js'

class BookmarksView extends View {
    _parentElement = document.querySelector('.bookmarks__list');
    _errorMessage = 'No bookmarks yet. Please add one :-)'
    _successMessage = '';

    _generateMarkup() {
        return this._data.map(bookmark => previewView.render(bookmark, false)).join('');
    }
}

export default new BookmarksView();