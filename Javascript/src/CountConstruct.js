/*
Write a function countConstruct(target, wordbank) that acept target string and an array of strings

The function should return the number of ways that the target can be constructed by concatenating
elements of the wordbank array

You may reuse elements of wordbank as many times as needed.
 */

const countConstruct = (target, wordbank, memo = {}) => {
    if (target in memo) return memo[target];
    if (target === "") return 1;
    let totalCount = 0;
    for (let word of wordbank) {
        if (target.indexOf(word)=== 0){
            const numberOfWays = countConstruct(target.slice(word.length), wordbank, memo);
            totalCount += numberOfWays;
        }
    }
    memo[target] =totalCount;
    return totalCount;
}

// const countConstruct = (target, wordbank) => {
//     if (target === "") return 1;
//     let totalCount = 0;
//     for (let word of wordbank) {
//         if (target.indexOf(word)=== 0){
//             const numberOfWays = countConstruct(target.slice(word.length), wordbank);
//             totalCount += numberOfWays;
//         }
//     }
//     return totalCount;
// }


console.log(countConstruct("skataboard", ["bo", "rd", "ate", "t", "ska", "boar"])); // ->0
console.log(countConstruct("purple", ["purp", "p", "ur", "le", "purpl"])); // -> 2
console.log(countConstruct("abcdef", ["ab", "abc", "cd", "def", "abcd"])); // -> 1
console.log(countConstruct("enterapotentpot", ["a", "p", "ent", "enter", "ot", "o", "ot"])); // -> 4
console.log(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", ["e", "ee", "eee", "eeee","eeeee", "eeeeee"])); // -> 0
