const solution = require('./solution.js');

test('p1221', () => {
    expect(solution("RLRRLLRLRL")).toBe(4);
    expect(solution("RLLLLRRRLR")).toBe(3);
    expect(solution("LLLLRRRR")).toBe(1);
    expect(solution("RLRRRLLRLL")).toBe(2);
});