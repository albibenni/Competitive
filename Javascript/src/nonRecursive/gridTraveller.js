/*
Traveller on a 2D grid. You begin in the top-left corner and your goal is to travel to the bottom-right corner. You may only move down or right.

In how many ways can you travel to the goal on a grid with dimensions m*n?

Write a function gridTraveller(m, n) that calculates this.
 */

const gridTraveller = (m, n) => {
    const twoDTable = Array(m + 1)
        .fill(0)
        .map(() => Array(n + 1).fill(0));
    twoDTable[1][1] = 1;

    for (let i = 0; i <= m; i++) {
        for (let j = 0; j <= n; j++) {
            const currentValue = twoDTable[i][j];
            if (j + 1 <= n) twoDTable[i][j + 1] += currentValue;
            if (i + 1 <= m) twoDTable[i + 1][j] += currentValue;
        }
    }

    return twoDTable[m][n];

}

// complexity driven by table size
// O(m*n) space and time

console.log(gridTraveller(1, 1)) // -> 1
console.log(gridTraveller(2, 3)) // -> 3
console.log(gridTraveller(3, 3)) // -> 3
console.log(gridTraveller(3, 3)) // -> 6
console.log(gridTraveller(18, 18)) // ->2333606220