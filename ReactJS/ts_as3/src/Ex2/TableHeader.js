import react from 'react';

class TableHeader extends react.Component {
    render() {
        return (
            <thead>
                <tr>
                    <th>No</th>
                    <th>Language</th>
                    <th>Framework</th>
                </tr>
            </thead>
        )
    }
}

export default TableHeader;