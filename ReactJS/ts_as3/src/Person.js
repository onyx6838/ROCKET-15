import React from 'react';
import './person.css'

function Person(props) {
    return (
        <div className="person">
            <h1>Fullname: {props.fullName}</h1>
            <p>Age: {props.age}</p>
            <p>Year Of Birth {new Date().getFullYear() - props.age}</p>
        </div>
    )
}

export default Person;