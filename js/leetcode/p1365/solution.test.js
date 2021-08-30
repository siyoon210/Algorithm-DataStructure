const solution = require('./solution.js');

test('p1365', () => {
    expect(solution([8, 1, 2, 2, 3])).toStrictEqual([4, 0, 1, 1, 3]);
    expect(solution([6, 5, 4, 8])).toStrictEqual([2, 1, 0, 3]);
    expect(solution([7, 7, 7, 7])).toStrictEqual([0, 0, 0, 0]);
    expect(solution([5, 0, 10, 0, 10, 6])).toStrictEqual([2, 0, 4, 0, 4, 3]);
});