import React from 'react';

class ChildComponent extends React.Component {
    render() {
        return (
            <div>
                Dad: {this.props.dad} , Mom {this.props.mom}
                <div>
                    {this.props.children}
                </div>
            </div>
        )
    }


}

export default ChildComponent