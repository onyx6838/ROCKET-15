import React, { Component } from 'react'
import AuthContext from './AuthContext'

class Login extends Component {
    handleClick = (context) => {
        const { setToken } = context;

        // call api auth
        setToken("1111");
    }

    render() {
        return (
            <AuthContext.Consumer>
                {
                    context => {
                        return (
                            <div>
                                <button onClick={() => this.handleClick(context)}>Login</button>
                            </div>
                        );  // truyen vao arrow la ham moi thi moi dung context trong <AuthContext.Consumer>

                        // return (
                        //     <div>
                        //         <button onClick={this.handleClick}>Login</button>
                        //     </div>
                        // ); ham truyen event vao tren la truyen vao ham tren context k thuoc pham vi
                    }
                }
            </AuthContext.Consumer>
        )
    }
}

export default Login
