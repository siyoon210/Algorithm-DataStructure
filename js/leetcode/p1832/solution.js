/**
 * @param {string} sentence
 * @return {boolean}
 */
const checkIfPangram = function (sentence) {
    // const chars = new Set()
    // sentence.split('').forEach(char =>{
    //     chars.add(char)
    // })
    //
    // return chars.size === 26
    return new Set([...sentence]).size === 26
};
module.exports = checkIfPangram;