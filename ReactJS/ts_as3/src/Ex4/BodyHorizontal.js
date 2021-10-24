import React from 'react'

class BodyHorizontal extends React.Component {
    render() {
        return (
            <div className="horizontal">
                <div className="row">
                    <div className="col left">1</div>
                    <div className="col center">2</div>
                    <div className="col right">3</div>
                </div>
            </div>
        )
    }
}

export default BodyHorizontal;