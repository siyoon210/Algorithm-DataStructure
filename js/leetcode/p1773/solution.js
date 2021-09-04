/**
 * @param {string[][]} items
 * @param {string} ruleKey
 * @param {string} ruleValue
 * @return {number}
 */
const countMatches = function (items, ruleKey, ruleValue) {
    const counts = {
        type: {},
        color: {},
        name: {},
    }

    items.forEach(item => {
        arrangeCount("type", item[0]);

        arrangeCount("color", item[1]);

        arrangeCount("name", item[2]);

        function arrangeCount(describe, name) {
            if (name in counts[describe]) {
                counts[describe][name]++
            } else {
                counts[describe][name] = 1
            }
        }
    })

    return counts[ruleKey][ruleValue] || 0
};

module.exports = countMatches;