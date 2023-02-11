//howSum takes in targetSum and an array of numbers as arguments
//should return an array containing any combination of elements
// that add up to exactly to targetSum else null

const howSum = (targetSum, numbers) => {
    if (targetSum === 0) return [];
    if (targetSum < 0) return null;
    for (let number of numbers) {
        const remainder = targetSum - number;
        const remainderResult = howSum(remainder, numbers);
        if (remainderResult !== null) {
            return [...remainderResult, number];
        }
    }
    return null;
}

const numbers1 = [2, 3];
const numbers10 = [5, 3, 4, 7];
const numbers2 = [2, 4];
const numbers3 = [2, 3, 5];
// const numbers4 = [7, 14];
// const result = howSum(7, numbers1);
// const result2 = howSum(7, numbers10);
// const result3 = howSum(7, numbers2);
// const result4 = howSum(8, numbers3);
// const result5 = howSum(300, numbers4);
console.log(howSum(7, [2, 3]));
console.log(howSum(7, [5, 3, 4, 7]));
console.log(howSum(7, [2, 4]));
console.log(howSum(8, [2, 3, 5]));
// console.log(howSum(300, [7, 14]));