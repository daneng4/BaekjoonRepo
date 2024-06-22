const filePath = process.platform === 'linux' ? 0 : './input.txt'
const input = require('fs').readFileSync(filePath).toString().trim().split('\n')

solution()

function solution(){
    let t = input[0]
    let answer = ''
    for(i = 1; i<=t; i++){
        let [a,b] = input[i].split(' ').map(Number)
        answer += `Case #${i}: ${a} + ${b} = ${a+b}\n`
    }
    console.log(answer)
}