// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
	for await (const line of rl) {
		let answer = '';
		let count = parseInt(line);
		
		while(count != 0){
			for(i = 0; i<count; i++){
				answer += '*';
			}
			answer += '\n';
			count -= 1;
		}
		
		console.log(answer);
		rl.close();
	}
	
	process.exit();
})();
