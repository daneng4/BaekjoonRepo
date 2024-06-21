const filePath = process.platform === "linux" ? 0 : "./input.txt"

let input = require('fs').readFileSync(filePath).toString().trim().split('\n')
let number = Number(input)

for(i = 1; i<=9; i++){
    let answer = i * number
    console.log(`${number} * ${i} = ${answer}`)
}