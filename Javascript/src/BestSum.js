/*
Write a func `bestSum(targetSum, numbers)` that takes in a targetSum and an array of numbers as arguments.

The function should return an array containing the SHORTEST combination of numbers that add up to exactly the targetSUm.

If there is a tie for the shortest combination you may return any one of the shortest.
 */

const bestSumBruteForce = (targetSum, numbers) => {
    if (targetSum === 0) return [];
    if (targetSum < 0) return null;

    let shortestCombination = null;


    for (let num of numbers) {
        const remainder = targetSum - num;
        const remainderCombination = bestSumBruteForce(remainder, numbers);

        if (remainderCombination != null) {
            const combination = [...remainderCombination, num];
            if (shortestCombination === null || combination.length < shortestCombination.length) shortestCombination = combination;
        }
    }
    return shortestCombination;
}

/*
m = target sum
n = number.length

time: O (m*n^m)
space: O(m*m)
 */


console.log(bestSumBruteForce(7, [5, 3, 4, 7]));
console.log(bestSumBruteForce(8, [2, 3, 5]));
console.log(bestSumBruteForce(8, [1, 4, 5]));
console.log(bestSumBruteForce(100, [1, 2, 5, 25]));