function romanToInt(s: string): number {
  let result = 0;
  let prevNum = 0;
  const romanMapInt: Map<string, number> = new Map([
    ['I', 1],
    ['V', 5],
    ['X', 10],
    ['L', 50],
    ['C', 100],
    ['D', 500],
    ['M', 1000],
  ]);
  for (let i = s.length - 1; i >= 0; i--) {
    const currNum = romanMapInt.get(s[i]);
    if (currNum !== undefined) {
      if (prevNum > currNum) result -= currNum;
      else result += currNum;
      prevNum = currNum;
    }
  }
  return result;
}

console.log(romanToInt('MCMXCIV'));
console.log(romanToInt('LVIII'));
console.log(romanToInt('III'));
