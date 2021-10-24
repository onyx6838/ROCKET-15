import React, { Component } from 'react'

export class Form extends Component {

    render() {
        const { inputValue, submitForm, onChangeValue } = this.props;

        return (
            <form onSubmit={submitForm}>
                <input type="text" value={inputValue} onChange={onChangeValue} />
                <input type="submit" />
            </form>
        )
    }
}

export default Form
