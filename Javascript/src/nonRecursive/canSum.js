/*
Write a function canSum(targetSum, numbers) that takes in a targetSm and an array of numbers
as arguments.

the function should return a boolean indicating wheter or not it is possible to generate
the targetSum using numbers from the array.

You may use an element of the array as many times as needed.

You may assume that all imput numbers are nonnegative.
 */

const canSum = (targetSum, numbers) => {
    const table = Array(targetSum + 1).fill(false);
    table[0] = true;

    for (let i = 0; i <= targetSum; i++) {
        if (table[i] === true) {
            for (let number of numbers) {
                let tableNewIndex = i + number;
                if (table.length > tableNewIndex) table[tableNewIndex] = true;
            }
        }
    }
    // console.log(table);

    return table[targetSum];
}
// m = targetSum
// n = number.length

// O(mn) time
// O(m) space


console.log(canSum(7, [2, 3]));
console.log(canSum(7, [5, 3, 4, 7]));
console.log(canSum(7, [2, 4]));
console.log(canSum(8, [2, 3, 5]));
console.log(canSum(300, [7, 14]));