const restoreString = function (s, indices) {
    const charByIndex = {}
    indices.forEach((sequence, index) => {
        charByIndex[sequence] = s.charAt(index)
    })

    let result = "";

    for (let i = 0; i < indices.length; i++) {
        result += charByIndex[i];
    }

    return result
};

module.exports = restoreString;