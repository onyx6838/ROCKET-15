function abc() {
    var fnScope = "abd";
    var fn2 = function def() {
        console.log(fnScope);
    };
    fn2();
}
abc();
