/*
Write a function allConstruct(target, wordBank) that accepts a
target string and an array of strings.

The functio should return a 2D array containing all of the ways
that the target can be constructed by concatenating elements of
the wordBank array
*/

function allConstruct(target, wordBank, memo = {}) {
    if (target in memo) return memo[target];
    if (target === '') return [[]];
    const allTheWays = [];
    for (let word of wordBank) {
        if (target.indexOf(word) === 0) {
            const suffix = target.slice(word.length);
            const suffixWays = allConstruct(suffix, wordBank, memo);
            const targetWays = suffixWays.map(way => [word, ...way])
            allTheWays.push(...targetWays);
        }
    }
    memo[target] = allTheWays;
    return allTheWays
}

console.log(allConstruct('abcdef', ["ab", "abc", "cd", "def", "abcd", "ef", "c"])) //
console.log(allConstruct('hello', ["cat", "mouse", "dog"])) // -> []
console.log(allConstruct('', ["cat", "mouse", "dog"])) // -> [[]]
console.log(allConstruct("skataboard", ["bo", "rd", "ate", "t", "ska","sk" ,"boar"]));
console.log(allConstruct("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaz", ["a", "aa", "aaa", "aaaa", "aaaaa","aaaaa" ,"aaaaaa"]));
