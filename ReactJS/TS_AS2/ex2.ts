const food = ['m', 'n', 'o', 'p', 'q', 'r', 's']

let per;
food.map((item, index) => {
    per += `${index} . ${item}`;
})