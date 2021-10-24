import React from 'react'
import Wrapper from './Wrapper'

export class Main extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            display: "1"
        };
    }

    handleClick = (id) => {
        this.setState({ display: id })
    }

    render() {
        return (
            <main>
                <button onClick={() => this.handleClick("1")}>Display Way 1</button>
                <button onClick={() => this.handleClick("2")}>Display Way 2</button>

                <Wrapper layout={this.state.display}/>
            </main>
        )
    }
}

export default Main