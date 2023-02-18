//howSumBruteForce takes in targetSum and an array of numbers as arguments
//should return an array containing any combination of elements
// that add up to exactly to targetSum else null

const howSumBruteForce = (targetSum, numbers) => {
    if (targetSum === 0) return [];
    if (targetSum < 0) return null;
    for (let number of numbers) {
        const remainder = targetSum - number;
        const remainderResult = howSumBruteForce(remainder, numbers);
        if (remainderResult !== null) {
            return [...remainderResult, number];
        }
    }
    return null;
}
//Space C: O(m+m)
// Time: O(m*n^m)


const howSumMemo = (targetSum, numbers, memo= {}) => {
    if (targetSum in memo) return memo[targetSum];
    if (targetSum === 0) return [];
    if (targetSum < 0) return null;
    for (let number of numbers) {
        const remainder = targetSum - number;
        const remainderResult = howSumMemo(remainder, numbers, memo);
        if (remainderResult !== null) {
            memo[targetSum] = [...remainderResult, number];
            return memo[targetSum];
        }
    }
    memo[targetSum] = null;
    return null;
}

// Space: O(m*m)
// Time: O(n*m*m)

// console.log(howSumBruteForce(7, [2, 3]));
// console.log(howSumBruteForce(7, [5, 3, 4, 7]));
// console.log(howSumBruteForce(7, [2, 4]));
// console.log(howSumBruteForce(8, [2, 3, 5]));
// console.log(howSumBruteForce(300, [7, 14]));
console.log(howSumMemo(7, [2, 3]));
console.log(howSumMemo(7, [5, 3, 4, 7]));
console.log(howSumMemo(7, [2, 4]));
console.log(howSumMemo(8, [2, 3, 5]));
console.log(howSumMemo(300, [7, 14]));