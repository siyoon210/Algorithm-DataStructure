/**
 * @param {number} n
 * @return {number}
 */
const subtractProductAndSum = function (n) {
    const digitNumbers = []

    while (n >= 10) {
        digitNumbers.push(n % 10)
        n = Math.floor(n / 10)
    }

    if (n >= 0) {
        digitNumbers.push(n)
    }

    const product = digitNumbers.reduce((preValue, currValue) => preValue * currValue)
    const sum = digitNumbers.reduce((preValue, currValue) => preValue + currValue)

    return product - sum
};

module.exports = subtractProductAndSum;