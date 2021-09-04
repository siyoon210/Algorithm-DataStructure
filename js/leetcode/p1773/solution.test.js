const solution = require('./solution.js');

test('p1773', () => {
    expect(solution([["phone", "blue", "pixel"], ["computer", "silver", "lenovo"], ["phone", "gold", "iphone"]],
        "color", "silver")).toBe(1);
    expect(solution([["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]],
        "type", "phone")).toBe(2);
});