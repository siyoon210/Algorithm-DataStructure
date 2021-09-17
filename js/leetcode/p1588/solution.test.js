const solution = require('./solution.js');

test('p1588', () => {
    expect(solution([1, 4, 2, 5, 3])).toBe(58);
    expect(solution([1, 2])).toBe(3);
    expect(solution([10, 11, 12])).toBe(66);
});