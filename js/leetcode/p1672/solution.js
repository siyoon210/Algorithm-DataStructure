const maximumWealth = function (accounts) {
    let max = 0
    accounts.forEach(account => {
        const sum = account.reduce((a, b) => a + b);
        max = (max > sum) ? max : sum
    })

    return max
};

module.exports = maximumWealth;