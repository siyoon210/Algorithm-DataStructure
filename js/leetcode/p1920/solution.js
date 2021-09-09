/**
 * @param {number[]} nums
 * @return {number[]}
 */
const buildArray = function (nums) {
    const ans = []
    nums.forEach(num => {
        ans.push(nums[num])
    })
    return ans;
};
module.exports = buildArray;