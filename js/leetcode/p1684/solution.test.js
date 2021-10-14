const solution = require('./solution.js');

test('p1684', () => {
    expect(solution("ab", ["ad","bd","aaab","baa","badab"])).toBe(2);
    expect(solution("abc",  ["a","b","c","ab","ac","bc","abc"])).toBe(7);
    expect(solution("cad",  ["cc","acd","b","ba","bac","bad","ac","d"])).toBe(4);
});