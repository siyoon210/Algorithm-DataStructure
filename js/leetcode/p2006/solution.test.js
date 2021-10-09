const solution = require('./solution.js');

test('p2006', () => {
    expect(solution([1, 2, 2, 1], 1)).toBe(4);
    expect(solution([1, 3], 3)).toBe(0);
    expect(solution([3, 2, 1, 5, 4], 2)).toBe(3);
    expect(solution([10, 2, 10, 9, 1, 6, 8, 9, 2, 8], 5)).toBe(1);
});