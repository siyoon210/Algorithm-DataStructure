const getConcatenation = function (nums) {
    return [...nums, ...nums]
};

console.log(getConcatenation([1, 2, 1]));