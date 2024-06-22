const filePath = process.platform === "linux" ? 0 : "./input.txt"

let input = require('fs').readFileSync(filePath).toString().trim().split('\n')

solution()

function solution(){
    const n = parseInt(input)
    let divide = n / 4
    let answer = ""

    for(i = 0; i<divide; i++){
        answer += "long "
    }
    answer += "int"
    console.log(answer)
}