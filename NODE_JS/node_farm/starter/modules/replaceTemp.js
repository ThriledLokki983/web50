

module.exports = function (temp, prod){
    let output = temp.replace(/{% ProductName %}/g, prod.productName);
    output = output.replace(/{% Image %}/g, prod.image);
    output = output.replace(/{% Price %}/g, prod.price);
    output = output.replace(/{% From %}/g, prod.from);
    output = output.replace(/{% NutrientName %}/g, prod.nutrients);
    output = output.replace(/{% Quantity %}/g, prod.quantity);
    output = output.replace(/{% Price %}/g, prod.price);
    output = output.replace(/{% Description %}/g, prod.description);
    output = output.replace(/{% id %}/g, prod.id);
    if(!prod.organic) output = output.replace(/{% NotOrganic %}/g, 'not-organic');

    return output;
};