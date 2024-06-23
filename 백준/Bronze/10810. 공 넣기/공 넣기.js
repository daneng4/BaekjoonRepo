const path = process.platform === 'linux' ? 0 : './input.txt'
const input = require('fs').readFileSync(path).toString().trim().split('\n')

let [n,m] = input[0].split(' ').map(Number)

let arr = new Array(n).fill(0)
for(i = 1; i<=m; i++){
    let [start, end, ball] = input[i].split(' ').map(Number)
    for(j = start-1; j<=end-1; j++){
        arr[j] = ball;
    }
}

let answer = ''
for(i = 0; i<n; i++){
    answer += arr[i] + ' '
}
console.log(answer)