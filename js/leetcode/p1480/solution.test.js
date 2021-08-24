const solution = require('./solution.js');

test('p1480', () => {
    expect(solution([1, 2, 3, 4])).toStrictEqual([1, 3, 6, 10]);
    expect(solution([1, 1, 1, 1, 1])).toStrictEqual([1, 2, 3, 4, 5]);
    expect(solution([3, 1, 2, 10, 1])).toStrictEqual([3, 4, 6, 16, 17]);
});