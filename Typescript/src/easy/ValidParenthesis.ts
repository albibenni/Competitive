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
  const initParenth: string[] = [];
  for (let i = 0; i < s.length; i++) {
    const equivalentClosingBracket = parenthesisMap.get(s[i]);
    if (equivalentClosingBracket) initParenth.push(s[i]);
    else {
      if (parenthesisMap.get(initParenth[initParenth.length - 1]) === s[i])
        initParenth.pop();
      else return false;
    }
  }
  return initParenth.length <= 0;
}

const input1 = '()[]{}';
const input4 = '({[]})';
const input2 = '()';
const input3 = '(]';

console.log(isValid(input1));
console.log(isValid(input4));
console.log(isValid(input2));
console.log(isValid(input3));
