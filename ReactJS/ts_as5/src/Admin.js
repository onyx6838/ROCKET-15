import React, { Component } from 'react'
import AuthContext from './AuthContext'
import Login from './Login'

export class Admin extends Component {
    render() {
        const {token} = this.context

        if (!token) {
            return <Login/>
        }

        return (
            <div>
                Admin Body
            </div>
        )
    }
}

Admin.contextType = AuthContext

export default Admin