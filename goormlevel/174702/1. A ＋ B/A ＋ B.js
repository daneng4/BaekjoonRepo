// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
	for await (const line of rl) {
		
		let [a,b] = line.split(" ").map(Number);
		console.log(a+b);
		rl.close();
	}
	
	process.exit();
})();
