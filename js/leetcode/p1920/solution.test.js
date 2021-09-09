const solution = require('./solution.js');

test('p1920', () => {
    expect(solution([0, 2, 1, 5, 3, 4])).toEqual([0, 1, 2, 4, 5, 3]);
    expect(solution([5, 0, 1, 2, 3, 4])).toEqual([4, 5, 0, 1, 2, 3]);
});