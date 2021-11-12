import React from "react";

class Mouse extends React.Component {
    state = {
        x: 0, y: 0
    }

    handleMouse = (event) => {
        const { clientX, clientY } = event;
        this.setState({ x: clientX, y: clientY });
    }

    render() {
        console.log(this.state.x, this.state.y);
        return (
            <div onMouseMove={this.handleMouse}>{this.props.render(this.state)}</div>
        )
    }
}

export default Mouse;