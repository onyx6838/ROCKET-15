import React, { Component } from 'react'

export class FormCreateUser extends Component {
    state = {
        input: ""
    }

    handleSubmit = (event) => {
        event.preventDefault();
        this.props.onAddUser(this.state.input);

        this.setState({ input: "" });
    }

    handleChangeInput = (event) => {
        const value = event.target.value;
        this.setState({ input: value });
    }

    render() {
        return (
            <div>
                <form onSubmit={this.handleSubmit} value={this.state.input} onChange={this.handleChangeInput}>
                    <input type="text" />
                    <button>Submit</button>
                </form>
            </div>
        )
    }
}

export default FormCreateUser
