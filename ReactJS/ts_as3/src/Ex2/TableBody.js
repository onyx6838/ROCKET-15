import React from 'react';

class TableBody extends React.Component {
    rows = this.props.characterData.map((row, index) => {
        return (
            <tr key={index}>
                <td>{index}</td>
                <td>{row.language}</td>
                <td>{row.framework}</td>
            </tr>
        )
    });

    render() {
        return (
            <tbody>{this.rows}</tbody>
        )
    }
}

export default TableBody;