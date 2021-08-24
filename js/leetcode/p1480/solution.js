const runningSum = function (nums) {
    const result = []
    let sumOfArray = 0;

    nums.forEach(num => {
        sumOfArray += num
        result.push(sumOfArray)
    })

    return result
};

module.exports = runningSum;