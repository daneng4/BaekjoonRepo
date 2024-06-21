const filePath = process.platform === "linux" ? 0 : "./input.txt"

let input = require('fs').readFileSync(filePath).toString().trim().split('\n')

for(const data of input){
    let split = data.split(' ')
    let a = Number(split[0])
    let b = Number(split[1])
    if(a == 0 && b == 0)
        break
    console.log(a + b)
}