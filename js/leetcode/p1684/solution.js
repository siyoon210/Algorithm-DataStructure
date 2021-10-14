/**
 * @param {string} allowed
 * @param {string[]} words
 * @return {number}
 */
const countConsistentStrings = function (allowed, words) {
    const allowedChars = new Set(allowed.split(''));
    let count = 0;
    words.forEach(word => {
        function isAllowed() {
            const chars = word.split('');
            for (const item of chars) {
                if (!allowedChars.has(item)) {
                    return false;
                }
            }
            return true;
        }

        if (isAllowed()) {
            count++;
        }
    })

    return count;
};
module.exports = countConsistentStrings;