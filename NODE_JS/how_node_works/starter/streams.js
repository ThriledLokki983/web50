const fs = require("fs");
const server = require("http").createServer();

server.on("request", (req, res) => {
	//! solution 1
	// fs.readFile("./test-file.txt", (err, data) => {
	// 	if (err) console.log(err);
	// 	res.end(data); // sending the data to the client
	// });

	// Solution 2: Streams [effect - backPressure]
	// const readable = fs.createReadStream("./test-file.txt");
	// readable.on("data", (chunkData) => {
	// 	res.write(chunkData);
	// });
	// readable.on("end", () => {
	// 	console.log("Finished reading the entire file");
	// 	res.end();
	// });
	// readable.on("error", (err) => {
	// 	console.log(err);
	// 	res.statusCode = 500;
	// 	res.end("File not found");
	// });

	//Solution 3: Pipe()
	const readable = fs.createReadStream("./test-file.txt");
	readable.pipe(res); // readableSource.pipe(writableDest)
});

server.listen(8000, "127.0.0.1", () => {
	console.log("Listening..........");
});
