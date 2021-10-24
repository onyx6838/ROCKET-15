import React from 'react'

export class StudentItem extends React.Component {
    render() {
        const {student , onRemoveStudent} = this.props;
        return (
           <li onClick={() => onRemoveStudent(student.id)}>{student.name}</li>
        )
    }
}

export default StudentItem
