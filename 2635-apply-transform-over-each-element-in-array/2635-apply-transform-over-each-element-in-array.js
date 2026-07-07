/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
    var map = function(arr, fn) {
    const res = [];
    for (let i = 0; i < arr.length; i++) {
        res.push(fn(arr[i], i));
    }
    return res;
};

console.log(map([1,2,3], function(n) { return n + 1; }));
console.log(map([1,2,3], function(n, i) { return n + i; }));
console.log(map([10,20,30], function(n) { return n * 2; }));

