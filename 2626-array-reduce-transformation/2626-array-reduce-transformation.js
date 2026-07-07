/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
    let acc = init;
    for (let i = 0; i < nums.length; i++) {
        acc = fn(acc, nums[i]);
    }
    return acc;
};

console.log(reduce([1,2,3,4], function(acc, curr) { return acc + curr; }, 0));
console.log(reduce([1,2,3,4], function(acc, curr) { return acc + curr * curr; }, 100));
console.log(reduce([], function(acc, curr) { return acc + curr; }, 25));
