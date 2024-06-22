const filePath = process.platform === "linux" ? 0 : "./input.txt"

let input = require('fs').readFileSync(filePath).toString().trim().split('\n')

solution()

function solution(){
    const x = parseInt(input[0])
    const n = parseInt(input[1])
    let no = "No"
    let yes = "Yes"
    let sum = 0

    for(i = 2; i<input.length; i++){
        let [price, num] = input[i].split(" ")
        sum += price * num
    }

    if(sum == x)
        console.log(yes)
    else
        console.log(no)
}