/*
Write a func `bestSum(targetSum, numbers)` that takes in a targetSum and an array of numbers as arguments.

The function should return an array containing the SHORTEST combination of numbers that add up to exactly the targetSUm.

If there is a tie for the shortest combination you may return any one of the shortest.
 */


const bestSum = (targetSum, numbers) => {
    const table = Array(targetSum + 1).fill(null);
    table[0] = [];
    for (let i = 0; i <= targetSum; i++) {
        if (table[i] !== null) {
            for (const number of numbers) {
                const sum = i + number;
                const arraySum = [...table[i], number];
                if (!table[sum] || table[sum].length > arraySum.length) {
                    table[sum] = arraySum;
                }
            }
        }
    }
    return table[targetSum];
}

/*
m = target sum
n = number.length

time: O(m*n*m)
space: O(m*m)
 */


console.log(bestSum(7, [5, 3, 4, 7]));
console.log(bestSum(8, [2, 3, 5]));
console.log(bestSum(8, [1, 4, 5]));
console.log(bestSum(300, [1, 2, 5, 25]));
