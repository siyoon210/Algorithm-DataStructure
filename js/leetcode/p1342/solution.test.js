const solution = require('./solution.js');

test('p1342', () => {
    expect(solution(14)).toStrictEqual(6);
    expect(solution(8)).toStrictEqual(4);
    expect(solution(123)).toStrictEqual(12);
});