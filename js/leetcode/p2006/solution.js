/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
const countKDifference = function (nums, k) {
    let count = 0;
    for (let i = 0; i < nums.length - 1; i++) {
        for (let j = i + 1; j < nums.length; j++) {
            if (Math.abs(nums[i] - nums[j]) === k) {
                count++;
            }
        }
    }
    return count;
};
module.exports = countKDifference;