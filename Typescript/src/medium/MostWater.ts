function maxArea(height: number[]): number {
  let result = 0;
  for (let i = 0; i < height.length; i++) {
    for (let j = i + 1; j < height.length; j++) {
      const lowNumber = height[j] > height[i] ? height[i] : height[j];
      const currArea = (j - i) * lowNumber;
      if (currArea > result) result = currArea;
    }
  }
  return result;
}

console.log(maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7]));
