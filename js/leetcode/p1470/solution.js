const shuffle = function (nums, n) {
    const result = [];
    for (let i = 0; i < n; i++) {
        result.push(nums[i])
        result.push(nums[i + n]);
    }
    return result
};

module.exports = shuffle;