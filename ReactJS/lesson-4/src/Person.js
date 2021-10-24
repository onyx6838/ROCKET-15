import './Person.css';
import React from 'react';

class Person extends React.Component {

    renderFullName = () => {
        return `${this.props.firstName} ${this.props.lastName}`;
    }

    render() {
        return (
            <div className="person">
                <h1>Full Name: {this.renderFullName()}</h1>
                <input type="text" placeholder="Input First Name" onChange={this.props.changeFirstName}/>
                <input type="text" placeholder="Input Last Name" onChange={this.props.changeLastName}/>
            </div>
        )
    };
}

export default Person;


