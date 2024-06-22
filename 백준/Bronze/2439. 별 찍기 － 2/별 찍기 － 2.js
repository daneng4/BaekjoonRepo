const filePath = process.platform === "linux" ? 0 : './input.txt'
const input = require('fs').readFileSync(filePath).toString().trim().split('\n')

let answer = ''
let blank = ' '

for(i = 1; i<=input; i++){
    let j
    for(j = 1; j<=input-i; j++){
        answer += blank
    }
    let k = j
    for(k; j<=input; j++){
        answer += '*'
    }
    answer += '\n'
}

console.log(answer)