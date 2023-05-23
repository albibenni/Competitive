export function twoSum(arr: number[], sum: number): Map<number, number> | null {
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

console.log(twoSum([1, 2, 3], 5));
