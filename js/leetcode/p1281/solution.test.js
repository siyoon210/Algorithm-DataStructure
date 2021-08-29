const solution = require('./solution.js');

test('p1281', () => {
    expect(solution(234)).toBe(15);
    expect(solution(4421)).toBe(21);
    expect(solution(10225)).toBe(-10);
});