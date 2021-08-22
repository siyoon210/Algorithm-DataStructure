const solution = require('./solution.js');

test('p1528', () => {
    expect(solution("codeleet", [4, 5, 6, 7, 0, 2, 1, 3])).toStrictEqual("leetcode");
    expect(solution("abc", [0, 1, 2])).toStrictEqual("abc");
    expect(solution("aiohn", [3, 1, 4, 2, 0])).toStrictEqual("nihao");
});