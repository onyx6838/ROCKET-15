function abc() {
    var fnScope = "abd";

    var fn2 = function log() {
        console.log(fnScope);   
    }

    fn2();
}

abc();