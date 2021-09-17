/**
 * @param {number[]} arr
 * @return {number}
 */
const sumOddLengthSubarrays = function (arr) {
    let result = 0
    for (let i = 1; i <= arr.length; i+=2) {
        for (let j = 0; j < arr.length; j++) {
            if (j + i > arr.length) {
                continue;
            }
            result += arr.slice(j, j + i)
                .reduce((a, b) => a + b, 0);
        }
    }
    return result
};
module.exports = sumOddLengthSubarrays;