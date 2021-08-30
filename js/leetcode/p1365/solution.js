/**
 * @param {number[]} nums
 * @return {number[]}
 */
const smallerNumbersThanCurrent = function(nums) {
    const sortedNums = [...nums].sort((a, b) => a - b);
    const numberMap = {};
    sortedNums.forEach((num, index) => {
        if (num in numberMap) {
            return
        }

        numberMap[num] = index;
    })
    const result = []

    nums.forEach(num => {
        result.push(numberMap[num])
    })

    return result
};
module.exports = smallerNumbersThanCurrent;