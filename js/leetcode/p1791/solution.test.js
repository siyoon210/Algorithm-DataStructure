const solution = require('./solution.js');

test('p1791', () => {
    expect(solution([[1,2],[2,3],[4,2]])).toBe(2);
    expect(solution([[1,2],[5,1],[1,3],[1,4]])).toBe(1);
});