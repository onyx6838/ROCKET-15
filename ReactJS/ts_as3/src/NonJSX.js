import React from 'react';

const style = {
    color: "red"
}

function handleClick(){
    alert('hello');
}

function NonJSX() {
    return (
        <div>
            <div className="class" style={style}>
                <p>Hello world</p>
                <button onClick={handleClick}>Click</button>
            </div>
        </div>
    )
}

export default NonJSX;