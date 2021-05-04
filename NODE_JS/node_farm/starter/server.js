const http = require("http");

// Create a server
const server = http.createServer((req, res) => {
	console.log(req);
	res.end("Hello from the server!");
});

// Listening to incoming request
server.listen(8000, "127.0.0.1", () => {
	console.log("Server is listening to requests on port 8000:");
});
