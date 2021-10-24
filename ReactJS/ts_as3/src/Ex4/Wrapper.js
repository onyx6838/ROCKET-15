import React from 'react'
import BodyHorizontal from './BodyHorizontal';
import BodyVertical from './BodyVertical';

export class Wrapper extends React.Component {
    getLayout = () => {
        const { layout } = this.props;

        switch (layout) {
            case "1":
                return <BodyHorizontal />
            case "2":
                return <BodyVertical />
            default:
                return null;
        }
    }

    render() {
        return (
            <div>
                {this.getLayout()}
            </div>
        )
    }
}

export default Wrapper
