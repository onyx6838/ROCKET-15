import React, { Component } from 'react';

class UserItem extends Component {
    handleClick = () => {
        const curId = this.props.user.id;
        this.props.onRemoveUser(curId);
    }

    render() {
        const { user } = this.props;
        
        return (
            <li>
                {user.name}
                <span style={{
                    color: "red",
                    marginLeft: 16,
                    fontSize: 14,
                    cursor: "pointer"
                }} onClick={this.handleClick}>x</span>
            </li>
        );
    }
}

export default UserItem;