const filePath = process.platform === "linux" ? 0 : "./input.txt"

var input = require('fs').readFileSync(filePath).toString().trim().split('\n')

let a = input[0]; let b = input[1];

if(a > 0 && b > 0)
    console.log('1')
else if(a > 0 && b < 0)
    console.log('4')
else if(a < 0 && b > 0)
    console.log('2')
else
    console.log('3')

