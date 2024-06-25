const path = process.platform === 'linux' ? 0 : './jsAlgo/input.txt';
const input = require('fs').readFileSync(path).toString().trim().split('\n').map(Number);

let answer = [];

for(i = 1; i<=30; i++){
    if(input.includes(i)) continue;
    answer.push(i);
}

answer.sort((a, b) => a-b);
console.log(`${answer[0]}\n${answer[1]}`);