/**
 * @param {...(null|boolean|number|string|Array|Object)} args
 * @return {number}
 */

    var argumentsLength = function(...args) {
    return args.length;
};

console.log(argumentsLength(1,2,3));
console.log(argumentsLength());
console.log(argumentsLength(5));



/**
 * argumentsLength(1, 2, 3); // 3
 */