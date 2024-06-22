const path = process.platform === 'linux' ? 0 : './input.txt'
const input = require('fs').readFileSync(path).toString().trim().split('\n')

let n = input[0]
let arr = input[1].split(' ')
let target = input[2]
let count = 0
for(i = 0; i<n; i++){
    if(arr[i] == target)
        count++
}

console.log(count)