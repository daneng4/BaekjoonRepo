const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];
rl.on('line', (line) => {
    input.push(line);
});

rl.on('close', () => {
    const [N, K] = input[0].split(' ');
    const numbers = input[1].split(' ').map(Number);
    let count = 0;

    for (const num of numbers) {
        if (!num.toString().includes(K.toString())) {
            count++;
        }
    }
    console.log(count);
});