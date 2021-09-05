/**
 * @param {string} s
 * @return {number}
 */
const balancedStringSplit = function (s) {
    let lCount = 0, rCount = 0 , result = 0;
    for (let i = 0; i < s.length; i++) {
        const char = s.charAt(i);

        if (char === 'L') {
            lCount++
        }

        if (char === 'R') {
            rCount++
        }

        if (lCount === rCount) {
            result++
            lCount = 0
            rCount = 0
        }
    }
    return result
};

module.exports = balancedStringSplit;