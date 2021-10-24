import React from "react";

class Clock extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            time: new Date()    // init state
        };
    }

    updateTime = () => {    // arrow function
        this.setState({
            time: new Date()
        })
    }

    render() {
        return (
            <div>
                <h2>Time:{this.state.time.toLocaleTimeString()}</h2>
                <button onClick={this.updateTime}>
                    Update time
                </button>
            </div>
        )
    }
}

export default Clock;