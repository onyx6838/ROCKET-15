import React from 'react'
import GameContext from '../GameContext';

class Square extends React.Component {
    handleClick = () => {
        const { position, onClickSquare } = this.props;
        onClickSquare(position);

        this.context.onChangeTheme('light');
    }

    render() {
        return (
            <button className="square" onClick={this.handleClick}>
                {this.props.value}
            </button>
        )
    }

}

// thay consumer
Square.contextType = GameContext
export default Square;