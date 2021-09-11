/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
const truncateSentence = function (s, k) {
    // const words = s.split(" ");
    // let result = words[0];
    // for (let i = 1; i < k; i++) {
    //     result += " " + words[i]
    // }
    // return result
    return s.split(' ', k).join(' ');
};

module.exports = truncateSentence;