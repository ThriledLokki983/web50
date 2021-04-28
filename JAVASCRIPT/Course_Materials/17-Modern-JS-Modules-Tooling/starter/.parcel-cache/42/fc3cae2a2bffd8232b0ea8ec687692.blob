var _parcelHelpers = require("@parcel/transformer-js/lib/esmodule-helpers.js");
_parcelHelpers.defineInteropFlag(exports);
var _baseIndexOfJs = require('./_baseIndexOf.js');
var _baseIndexOfJsDefault = _parcelHelpers.interopDefault(_baseIndexOfJs);
var _toIntegerJs = require('./toInteger.js');
var _toIntegerJsDefault = _parcelHelpers.interopDefault(_toIntegerJs);
/*Built-in method references for those with the same name as other `lodash` methods.*/
var nativeMax = Math.max;
/**
* Gets the index at which the first occurrence of `value` is found in `array`
* using [`SameValueZero`](http://ecma-international.org/ecma-262/7.0/#sec-samevaluezero)
* for equality comparisons. If `fromIndex` is negative, it's used as the
* offset from the end of `array`.
*
* @static
* @memberOf _
* @since 0.1.0
* @category Array
* @param {Array} array The array to inspect.
* @param {*} value The value to search for.
* @param {number} [fromIndex=0] The index to search from.
* @returns {number} Returns the index of the matched value, else `-1`.
* @example
*
* _.indexOf([1, 2, 1, 2], 2);
* // => 1
*
* // Search from the `fromIndex`.
* _.indexOf([1, 2, 1, 2], 2, 2);
* // => 3
*/
function indexOf(array, value, fromIndex) {
  var length = array == null ? 0 : array.length;
  if (!length) {
    return -1;
  }
  var index = fromIndex == null ? 0 : _toIntegerJsDefault.default(fromIndex);
  if (index < 0) {
    index = nativeMax(length + index, 0);
  }
  return _baseIndexOfJsDefault.default(array, value, index);
}
exports.default = indexOf;
