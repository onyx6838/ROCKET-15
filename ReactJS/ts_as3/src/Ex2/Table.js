import react from 'react';
import TableBody from './TableBody';
import TableHeader from './TableHeader';

class Table extends react.Component {
    render() {
        const { characterData } = this.props;

        return (
            <table className="table table-dark table-striped">
                <TableHeader />
                <TableBody characterData={characterData} />
            </table>
        )
    }
}

export default Table;