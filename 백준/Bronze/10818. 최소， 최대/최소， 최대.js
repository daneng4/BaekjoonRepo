const path = process.platform === 'linux' ? 0 : './input.txt'
const input = require('fs').readFileSync(path).toString().trim().split('\n')

let n = input[0]
let list = input[1].split(' ').map(Number)
let max = list[0]
let min = list[0]

for(i = 0; i<n; i++){
    max = Math.max(list[i], max)
    min = Math.min(list[i], min)
}

console.log(`${min} ${max}`)