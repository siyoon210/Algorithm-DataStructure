const solution = require('./solution.js');

test('p1816', () => {
    expect(solution("Hello how are you Contestant", 4)).toEqual("Hello how are you");
    expect(solution("What is the solution to this problem", 4)).toEqual("What is the solution");
    expect(solution("chopper is not a tanuki", 5)).toEqual("chopper is not a tanuki");
});