/**
 * Ques1
 */
let arr1 = [2, 4, 6, 8, 10];
let arr2 = [...arr1, 1, 3, 5, 7, 9];
console.log(arr2);
/**
 * Ques2
 */
let arr3 = [...arr2];
console.log(arr3);
/**
 * Ques3
 */
let cold = ['autumn', 'winter'];
let warm = ['spring', 'summer'];

let seasons = [...cold, ...warm];
console.log(seasons);
