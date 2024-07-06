const readline = require('readline');
const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout
});

const input = [];
rl.on('line', (line) => {
  input.push(line);
});

rl.on('close', () => {
  	const N = parseInt(input[0]);
	const S = input[1];
	const answer = S.split("").map(el => el.toLowerCase() === el ? el = el.toUpperCase() : el = el.toLowerCase()).join("");
	console.log(answer);
	process.exit();
});