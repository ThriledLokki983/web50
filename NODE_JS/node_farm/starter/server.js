const http = require("http");

// Create a server
http.createServer((req, res) => {
	res.end("Hello from the server!");
});
