const solution = require('./solution.js');

test('p1832', () => {
    expect(solution("thequickbrownfoxjumpsoverthelazydog")).toBe(true);
    expect(solution("leetcode")).toBe(false);
});