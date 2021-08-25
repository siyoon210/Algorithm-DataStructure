const solution = require('./solution.js');

test('p1672', () => {
    expect(solution([[1, 2, 3], [3, 2, 1]])).toBe(6);
    expect(solution([[1, 5], [7, 3], [3, 5]])).toBe(10);
    expect(solution([[2, 8, 7], [7, 1, 3], [1, 9, 5]])).toBe(17);
});