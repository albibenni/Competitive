/*
Write a function countConstruct(target, wordbank) that acept target string and an array of strings

The function should return the number of ways that the target can be constructed by concatenating
elements of the wordbank array

You may reuse elements of wordbank as many times as needed.
 */

const countConstruct = (target, wordBank) => {
    const table = Array(target.length + 1).fill(0);
    table[0] = 1;
    for (let i = 0; i <= target.length; i++) {
        for (const word of wordBank) {
            let sumIndex = i + word.length;
            if (target.slice(i, sumIndex) === word) {
                table[sumIndex] += table[i];
            }
        }
    }
    return table[target.length]
}
/*
m = target
n = wordbank length
// Time: O(m*m*n)
// Space: O(m)
 */

console.log(countConstruct("skataboard", ["bo", "rd", "ate", "t", "ska", "boar"])); // ->0
console.log(countConstruct("purple", ["purp", "p", "ur", "le", "purpl"])); // -> 2
console.log(countConstruct("abcdef", ["ab", "abc", "cd", "def", "abcd"])); // -> 1
console.log(countConstruct("enterapotentpot", ["a", "p", "ent", "enter", "ot", "o", "ot"])); // -> 4
console.log(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", ["e", "ee", "eee", "eeee", "eeeee", "eeeeee"])); // -> 0
