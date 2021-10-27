import React from 'react'
import Square from './Square';

class Board extends React.Component {
    render() {
        const { squares, onClickSquare, xIsNext } = this.props;
        const status = `Next player: ${xIsNext ? 'X' : 'O'}`;
        const size = Math.sqrt(squares.length);
        const rows = Array(size).fill(null);
        const cols = [...rows];

        return (
            <div>
                <div className="status">{status}</div>
                {
                    rows.map((row, rowIndex) => {
                        return (
                            <div className="row-row" key={rowIndex}>
                                {
                                    cols.map((col, colIndex) => {
                                        const position = size * rowIndex + colIndex;
                                        return <Square key={colIndex} position={position} value={squares[position]} onClickSquare={onClickSquare} />
                                    })
                                }
                            </div>
                        )
                    })
                }
            </div>
        )
    }
}

export default Board
