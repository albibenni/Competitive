function twoSumCustomMap(
  arr: number[],
  sum: number
): Map<number, number> | null {
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

console.log(twoSumCustomMap([1, 2, 3], 5));
console.log(twoSumCustomMap([1, 3, 7, 9, 2], 11));
console.log(twoSumCustomMap([], 5));

// Leetcode
function twoSum(nums: number[], target: number): number[] | null {
  for (let i = 0; i < nums.length; i++) {
    const numToFind = target - nums[i];
    for (let j = i + 1; j < nums.length; j++) {
      if (nums[j] === numToFind) return [i, j];
    }
  }
  return null;
}
