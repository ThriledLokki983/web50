const fs = require("fs"); // objects with a lot of functions to be used
const http = require("http");

// const hello = 'Hello world';
// console.log(hello);

// Blocking, Synchronous way
const textIn = fs.readFileSync("./txt/input.txt", "utf-8");
// console.log(textIn);

const textOut = `This is what we know about avocado: \n${textIn} \nCreated on: ${Date.now()}`;
fs.writeFileSync("./txt/output.txt", textOut);
// console.log("File written");

// Non-Blocking, Asynchronous way
fs.readFile("./txt/start.txt", "utf-8", (err, data) => {
	fs.readFile(`./txt/${data}.txt`, "utf-8", (err, data1) => {
		console.log(data1);
		fs.readFile("./txt/append.txt", "utf-8", (err, data2) => {
			console.log(data2);
			fs.writeFile(
				"./txt/result.txt",
				`${data1}\n${data2}`,
				"utf-8",
				(err) => {
					console.log("File is written ✅✅✅");
				}
			);
		});
	});
});
console.log("Will read file when done!");

// fs.writeFile('')
