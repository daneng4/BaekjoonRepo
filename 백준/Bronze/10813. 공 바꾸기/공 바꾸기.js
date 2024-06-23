const path = process.platform === 'linux' ? 0 : './input.txt'
const input = require('fs').readFileSync(path).toString().trim().split('\n')

let [n,m] = input[0].split(' ')
let arr = new Array()
for(i = 0; i<n; i++){
    arr.push(i+1)
}

for(i = 1; i<=m; i++){
    let [a, b] = input[i].split(' ').map(Number)
    if(a == b)
        continue
    let temp = arr[a-1]
    arr[a-1] = arr[b-1]
    arr[b-1] = temp;
}

let answer = ''
for(i = 0; i<n; i++){
    answer += arr[i] + ' '
}
console.log(answer)