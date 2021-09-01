const solution = require('./solution.js');

test('p1313', () => {
    expect(solution([1, 2, 3, 4])).toStrictEqual([2, 4, 4, 4]);
    expect(solution([1, 1, 2, 3])).toStrictEqual([1, 3, 3]);
});