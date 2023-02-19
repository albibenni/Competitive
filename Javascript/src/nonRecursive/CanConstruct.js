/*
Write a function `canConstruct(target, wordBank)` that accepts a target string and an array of strings.

The function should return a boolean indicating whether or not the `target` can be constructed by concatenating 
elements of the `wordBank` array.

You may reuse elements of `wordBank` as many times as needed.
 */

const canConstruct = (target, wordBank) => {
    if (target === "") return true;

    for (let word of wordBank) {
        //     check if prefix
        if (target.indexOf(word) === 0) {
            const suffix = target.slice(word.length);
            if (canConstructBruteForce(suffix, wordBank) === true) {
                return true;
            }
        }
    }
    return false;
}
console.log(canConstructMemo("skataboard", ["bo", "rd", "ate", "t", "ska", "boar"])); // ->false
console.log(canConstructMemo("", ["bo", "rd", "ate", "t", "ska", "boar"])); // -> true
console.log(canConstructMemo("abcdef", ["ab", "abc", "cd", "def", "abcd"])); // -> true
console.log(canConstructMemo("enterapotentpot", ["a", "p", "ent", "enter", "ot", "o", "ot"])); // -> true
console.log(canConstructMemo("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", ["e", "ee", "eee", "eeee","eeeee", "eeeeee"])); // -> false
