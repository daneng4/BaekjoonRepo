const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function solve(input){
	let n = input[0];
	let fstv = [];
	for(let i = 1; i<=n; i++){
		let arr = input[i].split(' ').map(Number);
		fstv.push(arr);
	}
	
	fstv.sort((a,b) => {
		if(a[1] === b[1])
			return a[0] - b[0];
		return a[1] - b[1];
	});
	
	let count = 0;
	let ct = -1;
	
	for(let [s, e] of fstv){
		if(s > ct){
			count++;
			ct = e;
		}
	}
	
	console.log(count);
}

let input = [];
rl.on('line', (line) => {
    input.push(line);
});

rl.on('close', () => {
    solve(input);
});