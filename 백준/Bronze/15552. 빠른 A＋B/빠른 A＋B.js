const filePath = process.platform === "linux" ? 0 : "./input.txt"

let input = require('fs').readFileSync(filePath).toString().trim().split('\n')

solution()

function solution(){
    const t = input[0]
    let answer = ""
    for(i = 1; i<input.length; i++){
        let[a, b] = input[i].split(" ").map(Number);
        answer += `${a+b}\n`
    }
    console.log(answer)
}