/**
 * @param {string[]} operations
 * @return {number}
 */
const finalValueAfterOperations = function (operations) {
    let x = 0;
    operations.forEach(operation => {
        if (operation.includes("+")) {
            x++;
        } else {
            x--;
        }
    })
    return x;
};

module.exports = finalValueAfterOperations;