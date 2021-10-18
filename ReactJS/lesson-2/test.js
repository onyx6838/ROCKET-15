const person = {
    firstName: "A",
    lastName: "B",
    age: 18,
    role: {
        name1: "admin"
    }
}

const {
    firstName,
    role: {
        name1
    },
    age
} = person;

console.log(firstName);
console.log(name1);

// const {
//     role: {
//         name
//     }
// } = person;

// console.log(name);

const templateString = `name ${firstName} , age ${age}` // ` backtick
console.log(templateString);
const arr1 = [1, 3, 5];
const arr2 = [...arr1, 8];
//arr2.push(7);
console.log("ARR " + arr2);

// rest operator (optional params)

// const date = [15, 10, 2021];
// const [data, ...rest] = date;

//console.log(date);