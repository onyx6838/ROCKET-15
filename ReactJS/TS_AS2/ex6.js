/**
 * 
 */
let createUser = new Promise(function (resolve, reject) {
    if (true) {
        resolve("ok");
    } else {
        reject("err");
    }
});

let createGr = new Promise(function (resolve, reject) {
    if (true) {
        resolve("ok");
    } else {
        reject("err");
    }
});

let addUserToGroup = new Promise(function (resolve, reject) {
    if (true) {
        resolve("ok");
    } else {
        reject("err");
    }
});

createUser.then(() => {
    return createGr();
});

createUser.catch(err => console.log(err));

createGr.then(()=>{
    return addUserToGroup();
});

createGr.catch(err => console.log(err));