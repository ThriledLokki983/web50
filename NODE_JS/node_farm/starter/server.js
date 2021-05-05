const http = require("http");
const url = require("url");
const fs = require("fs");
const slugify = require('slugify'); // slug ==> the last part of the url/unique string that the webpage is displaying
// import * from './modules/replaceTemp.js'
const replaceTemplate = require('./modules/replaceTemp.js');

///////////////////////////////////
//SERVER
const tempOverview = fs.readFileSync(`${__dirname}/templates/template_overview.html`, "utf-8");
const tempCard = fs.readFileSync(`${__dirname}/templates/template_card.html`, "utf-8");
const tempProducts = fs.readFileSync(`${__dirname}/templates/template_product.html`, "utf-8");

const data = fs.readFileSync(`${__dirname}/dev-data/data.json`, "utf-8");
const dataObj = JSON.parse(data);

const slugs = dataObj.map(res => slugify(res.productName, {lower: true, locale: 'nl'}))
console.log(slugs);

// Create a server
const server = http.createServer((req, res) => {
	// const pathName = req.url;

    const baseURL = 'http://' + 'localhost:8000' + '/';
    // const baseURL = 'localhost:8000' + '/'; this wont work
    const {pathname, searchParams, search} = new URL(req.url, baseURL);
    // console.log(searchParams);
    // console.log(new URL(req.url, baseURL));
    
    // Overview Page
	if (pathname === "/overview" || pathname === "/") {
		res.writeHead(200, { "Content-type": "text/html" });
        const cardsHtml = dataObj.map(res => replaceTemplate(tempCard, res)).join('');
        
        const output = tempOverview.replace('{% ProductCard %}', cardsHtml);
        res.end(output);

        // Products page
	} else if (pathname === "/product") {
        res.writeHead(200, { "Content-type": "text/html" });
        const product = dataObj[+search.slice(-1)];
 
        const output = replaceTemplate(tempProducts, product);
		res.end(output);

        // API
	} else if (pathname === "/api") {
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
