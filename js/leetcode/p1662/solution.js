/**
 * @param {string[]} word1
 * @param {string[]} word2
 * @return {boolean}
 */
const arrayStringsAreEqual = function (word1, word2) {
    const appendedWord1 = word1.reduce((preValue, currValue) => {
        return preValue + currValue
    }, "");

    const appendedWord2 = word2.reduce((preValue, currValue) => {
        return preValue + currValue
    }, "");

    return appendedWord1 === appendedWord2

    //return word1.join('') === word2.join('')
};
module.exports = arrayStringsAreEqual;