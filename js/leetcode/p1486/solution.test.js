const solution = require('./solution.js');

test('p1486', () => {
    expect(solution(5, 0)).toBe(8);
    expect(solution(4, 3)).toBe(8);
    expect(solution(1, 7)).toBe(7);
    expect(solution(10, 5)).toBe(2);
});