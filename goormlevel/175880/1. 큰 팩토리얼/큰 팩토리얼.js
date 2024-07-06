// Run by Node.js
const readline = require('readline');

function solve(n){
	let result = 1;
	while(n > 0){
		result *= n;
		result %= 1000000007;
		n-=1;
	}
	return result;
}

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
	for await (const line of rl) {
		let n = parseInt(line);
		
		console.log(solve(n));
		rl.close();
	}
	
	process.exit();
})();
