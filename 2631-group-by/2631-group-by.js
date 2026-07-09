/**
 * @param {Function} fn
 * @return {Object}
 */
Array.prototype.groupBy = function(fn) {
    const res = {};
    for (const item of this) {
        const key = fn(item);
        if (!(key in res)) {
            res[key] = [];
        }
        res[key].push(item);
    }
    return res;
};

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */