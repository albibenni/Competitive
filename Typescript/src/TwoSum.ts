function twoSumMap(arr: number[], sum: number): Map<number, number> | null {
  if (sum === 0) return new Map();
  if (arr.length === 0) return null;
  const index: Map<number, number> = new Map();
  //return the index
  for (let i = 0; i < arr.length; i++) {
    const numToFind = sum - arr[i];
    for (let j = i; j < arr.length; j++) {
      arr[j] === numToFind && index.set(i, j);
    }
  }
  if (index.size === 0) return null;
  return index;
}

console.log(twoSumMap([1, 2, 3], 5));
console.log(twoSumMap([1, 3, 7, 9, 2], 11));
console.log(twoSumMap([], 5));

// Leetcode
/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
 */
function twoSum(nums: number[], target: number): number[] | null {
  for (let i = 0; i < nums.length; i++) {
    const numToFind = target - nums[i];
    for (let j = i + 1; j < nums.length; j++) {
      if (nums[j] === numToFind) return [i, j];
    }
  }
  return null;
}
