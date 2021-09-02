/**
 * @param {number[]} nums
 * @return {number}
 */
const numIdenticalPairs = function (nums) {
    const countOfNums = {}
    nums.forEach(num => {
        if (num in countOfNums) {
            countOfNums[num] += 1
        } else {
            countOfNums[num] = 1
        }
    })

    let result = 0
    Object.keys(countOfNums).forEach(num => {
        const count = countOfNums[num]

        if (count === 1) {
            return
        }

        result += (count) * (count - 1) / 2
    })

    return result
};
module.exports = numIdenticalPairs;