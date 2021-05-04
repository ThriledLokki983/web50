const http = require("http");
const url = require("url");
const fs = require("fs");

///////////////////////////////////
//SERVER
const tempOverview = fs.readFileSync(`${__dirname}/templates/template_overview.html`, "utf-8");
const tempCard = fs.readFileSync(`${__dirname}/templates/template_card.html`, "utf-8");
const tempProducts = fs.readFileSync(`${__dirname}/templates/template_product.html`, "utf-8");

const data = fs.readFileSync(`${__dirname}/dev-data/data.json`, "utf-8");
const dataObj = JSON.parse(data);


const replaceTemplate = function (temp, prod){
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

// Create a server
const server = http.createServer((req, res) => {
	// console.log(req.url);
	const pathName = req.url;


    // Overview Page
	if (pathName === "/overview" || pathName === "/") {
		res.writeHead(200, { "Content-type": "text/html" });
        const cardsHtml = dataObj.map(res => replaceTemplate(tempCard, res)).join('');
        
        const output = tempOverview.replace('{% ProductCard %}', cardsHtml);

        res.end(output);


        // Products page
	} else if (pathName === "/products") {
        res.writeHead(200, { "Content-type": "text/html" });
		res.end(tempProducts);



        // API
	} else if (pathName === "/api") {
		res.writeHead(200, { "Content-type": "application/json" });
		res.end(data);



        // NOT FOUND
	} else {
		res.writeHead(404, {
			"Content-type": "text/html",
			"my-own-header": "Hello World",
		});
		res.end("<h1>Page not found!</h1>");
	}
});

// Listening to incoming request
server.listen(8000, "127.0.0.1", () => {
	console.log("Server is listening to requests on port 8000:");
});
