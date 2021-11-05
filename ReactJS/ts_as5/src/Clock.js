import React, { Component } from "react"

class Clock extends Component {
    constructor(props) {
        super(props)
        this.state = { date: new Date() }

        this.timer = null
    }

    componentDidMount() {
        console.log("Didmount");

        this.timer = setInterval(() => {
            this.setState({ date: new Date() })
        }, 1000)
    }

    componentDidUpdate(prevProps, prevState) {
        console.log(prevState.date);
    }

    componentWillUnmount() {
        console.log("Unmount");
        clearInterval(this.timer)
    }

    render() {
        return (
            <div>
                <h1>Hello, world!</h1>
                <h2>It is {this.state.date.toLocaleTimeString()}.</h2>
            </div>
        )
    }
}

export default Clock
