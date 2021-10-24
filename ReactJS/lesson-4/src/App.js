import Person from './Person';
import './App.css';
import React from 'react';
import Form from './Form';

class App extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      persons: [
        {
          id: 1,
          firstName: "Nguyen Van",
          lastName: "A"
        },
        {
          id: 2,
          firstName: "Nguyen Van",
          lastName: "B"
        },
        {
          id: 3,
          firstName: "Nguyen Van",
          lastName: "C"
        }
      ], inputValue: ''
    };
  }

  changeFirstName = (event, id) => {
    // get index
    const personIndex = this.state.persons.findIndex(p => { return p.id === id });
    // get person in state
    const localPersons = [...this.state.persons];
    // change name
    localPersons[personIndex].firstName = event.target.value;
    // update person in state
    this.setState(
      {
        persons: localPersons
      }
    );
  }

  changeLastName = (event, id) => {
    // get index
    const personIndex = this.state.persons.findIndex(p => { return p.id === id });
    // get person in state
    const localPersons = [...this.state.persons];
    // change name
    localPersons[personIndex].lastName = event.target.value;
    // update person in state
    this.setState(
      {
        persons: localPersons
      }
    );
  }

  handleChangeInput = (e) => {
    this.setState({ inputValue: e.target.value })
  }

  handleFormSubmit = (e) => {
    const nameValue = this.state.inputValue;
    e.preventDefault();
    const newPerson = {
      id: Math.random(),
      firstName: 'Nguyen',
      lastName: nameValue
    }
    const newPersons = [...this.state.persons, newPerson];
    this.setState({
      persons: newPersons
    })
  }

  render() {
    const personList = this.state.persons.map(
      person =>
        <Person
          key={person.id}
          firstName={person.firstName}
          lastName={person.lastName}
          changeFirstName={(event) => this.changeFirstName(event, person.id)}
          changeLastName={(event) => this.changeLastName(event, person.id)}>
        </Person>
    );

    return (
      <div>
        {personList}
        <Form submitForm={this.handleFormSubmit} inputValue={this.state.inputValue} onChangeValue={this.handleChangeInput} />
      </div >
    );
  }
}

export default App;