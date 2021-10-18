const p = new Promise(function (resolve, reject) {
    if (true) {
        resolve("ok");
    } else {
        reject("err");
    }
});

p.then(msg => console.log(msg)).catch(err => console.log(err));


export default {};