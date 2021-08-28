/**
 * @param {number} num
 * @return {number}
 */
const numberOfSteps = function (num) {
    let count = 0;
    while (num > 0) {
        if (isEventNumber(num)) {
            num /= 2;
        } else {
            num -= 1;
        }

        count++;
    }

    return count
};

const isEventNumber = num => {
    return num % 2 === 0;
}

module.exports = numberOfSteps;