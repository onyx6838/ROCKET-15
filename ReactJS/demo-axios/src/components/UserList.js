import React from 'react'
import FormCreateUser from './FormCreateUser';
import UserItem from './UserItem';
import DemoHOC from './DemoHOC';
import Mouse from './DemoRenderProps';
import api from '../api/Api';

class UserList extends React.Component {
    state = {
        users: [],
        loading: false
    }

    componentDidMount() {
        this.getUsers();
    }

    getUsers = () => {
        this.setState({ loading: true });
        const response = api.get("users");
        response.then(result => {
            this.setState({ users: result.data });
            this.setState({ loading: false });
        })
    }

    addUser = (value) => {
        const response = api.post("users", { name: value })
        response.then(result => {
            this.getUsers()
        }).catch(error => console.log(error));
    }

    removeUser = (id) => {
        const response = api.delete(`users/${id}`)
        response.then(_ => {
            this.getUsers()
        })
    }

    render() {
        const { users, loading } = this.state;

        return (
            <div>
                <ul style={{ listStyleType: "none" }}>
                    {
                        users.map((user, index) => {
                            return (
                                <Mouse key={index} render={(position) => {
                                    // logic here with position from render
                                    return <UserItem key={index} user={user} onRemoveUser={this.removeUser} position={position} />
                                }} />
                            )
                        })
                    }
                </ul>
                <FormCreateUser onAddUser={this.addUser} />
                <DemoHOC isLoading={loading} />
            </div>
        )
    }
}

export default UserList
