/**
 * @param {number} n
 * @param {number} start
 * @return {number}
 */
const xorOperation = function (n, start) {
    const generateNumber = index => start + (2 * index);

    let result = generateNumber(0);

    for (let i = 1; i < n; i++) {
        result ^= generateNumber(i);
    }

    return result;
};

module.exports = xorOperation;