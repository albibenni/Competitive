/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

 */
function isValid(s: string): boolean {
  const parenthesisMap: Map<string, string> = new Map([
    ['(', ')'],
    ['[', ']'],
    ['{', '}'],
  ]);
  for (let i = 0; i < s.length; i++) {
    const equivalentClosingBracket = parenthesisMap.get(s[i]);
    if (
      equivalentClosingBracket === undefined ||
      equivalentClosingBracket !== s[++i]
    )
      return false;
  }
  return true;
}

const input1 = '()[]{}';
const input2 = '()';
const input3 = '(]';

console.log(isValid(input1));
console.log(isValid(input2));
console.log(isValid(input3));
