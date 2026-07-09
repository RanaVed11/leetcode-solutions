var flat = function(arr, n) {
    let result = [];

    function flatten(current, depth) {
        for (let item of current) {
            if (Array.isArray(item) && depth > 0) {
                flatten(item, depth - 1);
            } else {
                result.push(item);
            }
        }
    }

    flatten(arr, n);
    return result;
};