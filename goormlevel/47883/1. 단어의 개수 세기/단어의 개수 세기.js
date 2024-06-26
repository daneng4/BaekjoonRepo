// Run by Node.js

const readline = require("readline");
const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout
});

rl.on("line", function(line) {
	// 로직 작성하기
	let arr = line.split(' ').map(String);
	let answer = arr.filter((a) => a != '');
	console.log(answer.length);
	rl.close();
}).on("close", function() {
	process.exit();
});