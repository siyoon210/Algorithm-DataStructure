const solution = require('./solution.js');

test('concatenation [1,2,1]', () => {
    expect(solution([1, 2, 1])).toStrictEqual([ 1, 2, 1, 1, 2, 1 ]);
});

// npm run test solution.test.js