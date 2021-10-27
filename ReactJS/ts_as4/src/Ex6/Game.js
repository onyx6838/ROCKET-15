import React from 'react';
import GameContext from '../GameContext';
import Board from './Board';

class Game extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            squares: Array(9).fill(null),
            xIsNext: true,
            winner: "",
            theme: "dark"
        };
    }

    handleClickSquare = (value) => {
        const { xIsNext, squares, winner: hasWinner } = this.state;

        if (squares[value] || hasWinner) {
            return;
        }

        const newSquares = squares.map((square, index) => {
            if (value !== index) {
                return square;
            }
            return xIsNext ? 'X' : 'O';
        })

        const winner = this.calculateWinner(newSquares);

        if (winner) this.setState({ winner: winner, squares: newSquares })
        else {
            this.setState({ squares: newSquares, xIsNext: !xIsNext })
        }
    }

    calculateWinner = (squares) => {
        const lines = [
            [0, 1, 2],
            [3, 4, 5],
            [6, 7, 8],
            [0, 3, 6],
            [1, 4, 7],
            [2, 5, 8],
            [0, 4, 8],
            [2, 4, 6],
        ];
        for (let i = 0; i < lines.length; i++) {
            const [a, b, c] = lines[i];
            if (squares[a] && squares[a] === squares[b] && squares[a] === squares[c]) {
                return squares[a];
            }
        }
        return null;
    }

    handleChangeTheme = (value) => {
        this.setState({ theme: value })
    }

    render() {
        const { xIsNext, squares, winner } = this.state;

        const context = {
            state: this.state,
            onChangeTheme: this.handleChangeTheme
        }

        return (
            <GameContext.Provider value={context}>
                <div className="game">
                    <div className="game-board">
                        <Board squares={squares} xIsNext={xIsNext} onClickSquare={this.handleClickSquare} />
                    </div>
                    <div className="game-info">
                        <div>{winner && `Winner: ${winner}`}</div>
                    </div>
                </div>
            </GameContext.Provider>
        )
    }
}

export default Game;