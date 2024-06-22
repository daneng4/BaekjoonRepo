const path = process.platform === 'linux' ? 0 : './input.txt'
const input = require('fs').readFileSync(path).toString().trim().split('\n')

solution()

function solution(){
    let answer = ''
    for(i = 0; i<input.length; i++){
        let [a,b] = input[i].split(' ').map(Number)
        answer += `${a+b}\n`
    }
    console.log(answer)
}