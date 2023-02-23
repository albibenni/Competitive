/*
Write a function allConstruct(target, wordBank) that accepts a
target string and an array of strings.

The functio should return a 2D array containing all of the ways
that the target can be constructed by concatenating elements of
the wordBank array
*/

function allConstruct(target, wordBank) {
    const table = Array(target.length + 1)
        .fill()
        .map(() => []);

    table[0] = [[]];

    for (let i = 0; i <= target.length; i++) {
        for (let word of wordBank) {
            if (target.slice(i, i + word.length) === word) {
                const resultArrays = table[i].map(subArray => [...subArray, word]);
                table[i + word.length].push(...resultArrays);
            }
        }
    }
    return table[target.length]
}

// Space: O(n^m) like a 3d array
// Time: O(n^m) no matter what


console.log(allConstruct('abcdef', ["ab", "abc", "cd", "def", "abcd", "ef", "c"])) //
console.log(allConstruct('purple', ["purp", "p", "ur", "le", "abcd", "ef", "c"])) //
console.log(allConstruct('hello', ["cat", "mouse", "dog"])) // -> []
console.log(allConstruct('', ["cat", "mouse", "dog"])) // -> [[]]
console.log(allConstruct("skataboard", ["bo", "rd", "ate", "t", "ska", "sk", "boar"]));
console.log(allConstruct("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaz", ["a", "aa", "aaa", "aaaa", "aaaaa", "aaaaa", "aaaaaa"]));
