//howSum takes in targetSum and an array of numbers as arguments
//should return an array containing any combination of elements that adds up to targetSum
//else null
//may return only one way

const howSum = (targetSum, numbers) => {
    let result = [];
    const selectionArray = Array(targetSum + 1).fill(null);
    selectionArray[0] = 0;

    for (let i = 0; i <= targetSum; i++) {
        if (selectionArray[i] !== null) {
            for (let number of numbers) {
                let indexNumberSum = i + number;
                if (indexNumberSum <= targetSum) {
                    result.push(number);
                    targetSum[indexNumberSum] = true;
                }
                if (selectionArray[targetSum] === true) return result.push(i);
            }
            result = [];
        }
    }
    return null;
}

// Space: O(m*m)
// Time: O(n*m*m)
console.log(howSum(7, [2, 3]));
// console.log(howSum(7, [5, 3, 4, 7]));
// console.log(howSum(7, [2, 4]));
// console.log(howSum(8, [2, 3, 5]));
// console.log(howSum(300, [7, 14]));