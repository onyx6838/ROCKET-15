import React from 'react'

export class BodyVertical extends React.Component {
    render() {
        return (
            <div className="vertical">
                <div className="row">
                    <div className="col left">1</div>
                    <div className="col center">2</div>
                    <div className="col right">3</div>
                </div>
            </div>
        )
    }
}

export default BodyVertical
