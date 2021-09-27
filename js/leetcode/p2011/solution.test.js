const solution = require('./solution.js');

test('p2011', () => {
    expect(solution(["--X","X++","X++"])).toBe(1);
    expect(solution(["++X","++X","X++"])).toBe(3);
    expect(solution(["X++","++X","--X","X--"])).toBe(0);
});