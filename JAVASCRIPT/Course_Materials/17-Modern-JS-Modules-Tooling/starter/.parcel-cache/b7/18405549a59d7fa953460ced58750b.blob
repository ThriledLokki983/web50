var _parcelHelpers = require("@parcel/transformer-js/lib/esmodule-helpers.js");
_parcelHelpers.defineInteropFlag(exports);
var _SymbolJs = require('./_Symbol.js');
var _SymbolJsDefault = _parcelHelpers.interopDefault(_SymbolJs);
/** Used to convert symbols to primitives and strings.*/
var symbolProto = _SymbolJsDefault.default ? _SymbolJsDefault.default.prototype : undefined, symbolValueOf = symbolProto ? symbolProto.valueOf : undefined;
/**
* Creates a clone of the `symbol` object.
*
* @private
* @param {Object} symbol The symbol object to clone.
* @returns {Object} Returns the cloned symbol object.
*/
function cloneSymbol(symbol) {
  return symbolValueOf ? Object(symbolValueOf.call(symbol)) : {};
}
exports.default = cloneSymbol;
