const solution = require('./solution.js');

test('p1534', () => {
    expect(solution([3, 0, 1, 1, 9, 7], 7, 2, 3)).toBe(4);
    expect(solution([1, 1, 2, 2, 3], 0, 0, 1)).toBe(0);
});