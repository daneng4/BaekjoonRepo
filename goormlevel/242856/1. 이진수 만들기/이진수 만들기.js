// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
	for await (const line of rl) {
		let answer = [];
		let num = parseInt(line);
		
		while(num > 1){
			answer.unshift(num % 2);
			num = parseInt(num / 2);
		}
		
		if(num  % 2 == 1)
			answer.unshift(1);
		
		console.log(answer.toString().replaceAll(',',''));
		rl.close();
	}
	
	process.exit();
})();
