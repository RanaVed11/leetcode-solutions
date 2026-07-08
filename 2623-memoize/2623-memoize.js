/**
 * @param {Function} fn
 * @return {Function}
 */
var memoize = function(fn) {
    const cache = {};
    return function(...args) {
        const key = JSON.stringify(args);
        if (key in cache) {
            return cache[key];
        }
        const result = fn(...args);
        cache[key] = result;
        return result;
    };
};

const sum = (a, b) => a + b;
const memoizedSum = memoize(sum);

console.log(memoizedSum(2,3));
console.log(memoizedSum(2,3));
console.log(memoizedSum(4,5));


/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */