const solution = require('./solution.js');

test('p1614', () => {
    expect(solution("(1+(2*3)+((8)/4))+1")).toBe(3);
    expect(solution("(1)+((2))+(((3)))")).toBe(3);
    expect(solution("1+(2*3)/(2-1)")).toBe(1);
});