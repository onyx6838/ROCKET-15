// function abc() {
//     var fnScope = "abd";
//     var fn2 = function def() {
//         console.log(fnScope);
//     };
//     fn2();
// }
// abc();

let root = {
    depth: 0,
    player: 1,
    activePlayer: 1,
    baseScore: 1,
    score: 1,
    moves: 133
};


let fringe = [root];

fringe.push({
    depth: 0,
    player: 1,
    activePlayer: 1,
    baseScore: 1,
    score: 1,
    moves: 12
})
let node = fringe.shift();



console.log(node);