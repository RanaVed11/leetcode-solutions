/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
var compactObject = function(obj) {
    if (Array.isArray(obj)) {
        return obj
            .map(compactObject)       // recursive call for nested arrays/objects
            .filter(Boolean);         // remove falsy values
    } else if (obj !== null && typeof obj === "object") {
        const res = {};
        for (const key in obj) {
            const val = compactObject(obj[key]);
            if (Boolean(val)) {
                res[key] = val;
            }
        }
        return res;
    } else {
        return obj;
    }
};
