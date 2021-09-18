/**
 * @param {string} s
 * @return {number}
 */
const maxDepth = function (s) {
    const stack = []
    let maxDepth = 0
    s.split("").forEach(char => {
        if (char === "(") {
            stack.push(char)
            maxDepth = stack.length > maxDepth ? stack.length : maxDepth
        } else if (char === ")") {
            stack.pop()
        }
    })
    return maxDepth
};
module.exports = maxDepth;