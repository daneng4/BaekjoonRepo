// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
	for await (const line of rl) {
		let num = line.split(" ").map(Number);
		let answer = num[0] + num[1];
		console.log(answer.toFixed(6));
		rl.close();
	}
	
	process.exit();
})();
