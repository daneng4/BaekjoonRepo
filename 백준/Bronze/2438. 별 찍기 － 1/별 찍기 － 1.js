const filePath = process.platform === "linux" ? 0 : './input.txt'
const input = require('fs').readFileSync(filePath).toString().trim().split('\n')

solution()

function solution(){
    let answer = ''
    for(i = 1; i<=input; i++){
        for(j = 1; j<=i; j++){
            answer += '*'
        }
        answer += '\n'
    }
    console.log(answer)
}