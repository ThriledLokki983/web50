const http = require("http");
const url = require("url");
const fs = require("fs");

///////////////////////////////////
//SERVER
const data = fs.readFileSync(`${__dirname}/dev-data/data.json`, "utf-8");
const dataObject = JSON.parse(data);

// Create a server
const server = http.createServer((req, res) => {
	// console.log(req.url);
	const pathName = req.url;
	if (pathName === "/overview" || pathName === "/") {
		res.end("This is the overview page");
	} else if (pathName === "/products") {
		res.end("This is the Products page");
	} else if (pathName === "/api") {
		res.writeHead(200, { "Content-type": "application/json" });
		res.end(data);
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
