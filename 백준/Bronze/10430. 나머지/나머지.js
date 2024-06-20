var input = require('fs').readFileSync('/dev/stdin').toString().trim().split(' ').map(Number)

const [a, b, c] = input;

var answer1 = (a+b)%c;
var answer2 = ((a%c) + (b%c))%c
var answer3 = (a*b)%c
var answer4 = ((a%c)*(b%c))%c
console.log(answer1);
console.log(answer2);
console.log(answer3);
console.log(answer4);