/**
 * @param {number} millis
 * @return {Promise}
 */
async function sleep(millis) {
    return new Promise(resolve => setTimeout(resolve, millis));
}

async function example() {
    console.log("Start");
    await sleep(2000);
    console.log("End after 2 seconds");
}

example();


/** 
 * let t = Date.now()
 * sleep(100).then(() => console.log(Date.now() - t)) // 100
 */