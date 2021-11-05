import React, { Component } from 'react'
import withLoading from './hoc'

class DemoHOC extends Component {
    render() {
        return (
            <div>
                List user loaded
            </div>
        )
    }
}

export default withLoading(DemoHOC)