const solution = require('./solution.js');

test('p1180', () => {
    expect(solution("1.1.1.1")).toStrictEqual("1[.]1[.]1[.]1");
    expect(solution("255.100.50.0")).toStrictEqual("255[.]100[.]50[.]0");
});