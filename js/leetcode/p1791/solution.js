/**
 * @param {number[][]} edges
 * @return {number}
 */
const findCenter = function (edges) {
    const first = edges[0][0]
    const second = edges[0][1]

    if (first === edges[1][0] || first === edges[1][1]) {
        return first
    }
    return second
};

module.exports = findCenter;