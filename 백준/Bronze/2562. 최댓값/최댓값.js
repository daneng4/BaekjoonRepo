const path = process.platform === 'linux' ? 0 : './input.txt'
const input = require('fs').readFileSync(path).toString().trim().split('\n').map(Number)

let max = input[0]
let maxidx = 1
for(i = 1; i<input.length; i++){
    if(max < input[i]){
        max = input[i]
        maxidx = i+1
    }
}

console.log(`${max}\n${maxidx}`)