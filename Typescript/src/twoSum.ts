export function twoSum(arr: number[], sum: number): number | null {
  arr.map(n1 => {
    return arr.find(n2 => n2 + n1 === sum);
  });
  return null;
}

console.log(twoSum([1, 2, 3], 5));
