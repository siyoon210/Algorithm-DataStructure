const solution = require('./solution.js');

test('p1662', () => {
    expect(solution(["ab", "c"],  ["a", "bc"])).toBe(true);
    expect(solution(["a", "cb"], ["ab", "c"])).toBe(false);
    expect(solution(["abc", "d", "defg"], ["abcddefg"])).toBe(true);
});