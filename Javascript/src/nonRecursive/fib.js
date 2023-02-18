/*
Write a function `fib(n)` that takes in a number as an argument. The function should return the n-th number of the Fibonacci sequence.

The 0th number of the seq. is 0
The 1st is 1

to generate the next number of the seq we sum the previous two.
 */

const fib = (n) => {
    const table = Array(n + 1).fill(0);
    table[1] = 1;
    for (let i = 0; i <= n; i++) {
        table[i + 1] += table[i];
        table[i + 2] += table[i];
    }
    return table[n];
}

console.log(fib(6));
console.log(fib(7));
console.log(fib(8));
console.log(fib(50));