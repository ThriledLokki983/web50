var _parcelHelpers = require("@parcel/transformer-js/lib/esmodule-helpers.js");
_parcelHelpers.defineInteropFlag(exports);
var _baseIsMapJs = require('./_baseIsMap.js');
var _baseIsMapJsDefault = _parcelHelpers.interopDefault(_baseIsMapJs);
var _baseUnaryJs = require('./_baseUnary.js');
var _baseUnaryJsDefault = _parcelHelpers.interopDefault(_baseUnaryJs);
var _nodeUtilJs = require('./_nodeUtil.js');
var _nodeUtilJsDefault = _parcelHelpers.interopDefault(_nodeUtilJs);
/*Node.js helper references.*/
var nodeIsMap = _nodeUtilJsDefault.default && _nodeUtilJsDefault.default.isMap;
/**
* Checks if `value` is classified as a `Map` object.
*
* @static
* @memberOf _
* @since 4.3.0
* @category Lang
* @param {*} value The value to check.
* @returns {boolean} Returns `true` if `value` is a map, else `false`.
* @example
*
* _.isMap(new Map);
* // => true
*
* _.isMap(new WeakMap);
* // => false
*/
var isMap = nodeIsMap ? _baseUnaryJsDefault.default(nodeIsMap) : _baseIsMapJsDefault.default;
exports.default = isMap;
