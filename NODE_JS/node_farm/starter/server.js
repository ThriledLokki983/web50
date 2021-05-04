const http = require("http");
const url = require("url");

// Create a server
const server = http.createServer((req, res) => {
	// console.log(req.url);
	const pathName = req.url;
	if (pathName === "/overview" || pathName === "/") {
		res.end("This is the overview page");
	} else if (pathName === "/products") {
		res.end("This is the Products page");
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
