/**
 * @param {number} n
 * @return {number}
 */
const numberOfMatches = function (n) {
    return countMatches(n, 0)
};

function countMatches(numOfTeams, numOfMatches) {
    if (numOfTeams === 1) {
        return numOfMatches
    }

    if (isEvenNumber(numOfTeams)) {
        numOfMatches += (numOfTeams / 2);
        numOfTeams = numOfTeams / 2;
    } else {
        numOfMatches += ((numOfTeams - 1) / 2);
        numOfTeams = ((numOfTeams - 1) / 2) + 1;
    }

    return countMatches(numOfTeams, numOfMatches)
}

function isEvenNumber(n) {
    return n % 2 === 0;
}

module.exports = numberOfMatches;