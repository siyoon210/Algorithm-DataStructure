/**
 * @param {string} address
 * @return {string}
 */
const defangIPaddr = function(address) {
    return address.replace(/\./g,"[.]");
};
module.exports = defangIPaddr;