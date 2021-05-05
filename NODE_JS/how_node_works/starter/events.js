const EventEmitter = require("events");
const http = require("http");

class Sales extends EventEmitter {
	constructor() {
		super();
	}
}

const myEmitter = new Sales();

// Observer patterns
myEmitter.on("newSale", () => {
	console.log("There was a new sale");
});

myEmitter.on("newSale", () => {
	console.log(`Customer name is: Gideon`);
});

myEmitter.on("newSale", (stock) => {
	console.log(`There are ${stock} items in the basket`);
});

myEmitter.emit("newSale", 9);

//
const server = http.createServer();

server.on("request", (req, res) => {
	console.log("Request received");
	res.end("Request received");
});

server.on("request", (req, res) => {
	console.log("Another request 👋🏾");
});

server.close("close", () => {
	console.log("Server shutting down............");
});

server.listen(8000, "127.0.0.1", () => {
	console.log("listening on the server...");
});
