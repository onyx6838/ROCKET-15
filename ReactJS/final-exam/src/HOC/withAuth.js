import React from 'react';
import { Redirect } from 'react-router-dom';
import storage from '../storage/storage';

function withAuth(AuthenticatedComponent) {

    class HOC extends React.Component {
        render() {
            return (
                !storage.isAuth() ?
                    <Redirect
                        to={{
                            pathname: "/auth/sign-in"
                        }}
                    />
                    :
                    <AuthenticatedComponent {...this.props} />
            );
        }
    }
    return HOC;
}

export default withAuth;

