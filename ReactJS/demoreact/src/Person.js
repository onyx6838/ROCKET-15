import React from "react";
import './person.css';

class Person extends React.Component {
    render() {
        return (
            <div className='person'>
                <h1>Minh Giang</h1>
                <p>Age: 21</p>
            </div>
        );
    }
}


function Person2() {
    return (
        <div className='person'>
            <h1>Minh Giang</h1>
            <p>Age: 21</p>
        </div>
    );
}
export default { Person, Person2 };