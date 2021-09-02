const solution = require('./solution.js');

test('p1512', () => {
    expect(solution([1, 2, 3, 1, 1, 3])).toStrictEqual(4);
    expect(solution([1, 1, 1, 1])).toStrictEqual(6);
    expect(solution([1, 2, 3])).toStrictEqual(0);
});