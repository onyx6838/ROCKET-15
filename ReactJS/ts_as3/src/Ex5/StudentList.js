import React from 'react'
import StudentItem from './StudentItem'

export class StudentList extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            students: [{
                id: "1",
                name: "A"
            }, {
                id: "2",
                name: "B"
            }, {
                id: "3",
                name: "C"
            }]
        }
    }

    removeStudent = (id) => {
        const {students} = this.state;

        const newStudents = students.filter(student => student.id !== id);

        this.setState({ students: newStudents })
    }

    render() {
        return (
            <ul>
                {this.state.students.map(student =>
                    <StudentItem student={student} onRemoveStudent={this.removeStudent}/>
                )}
            </ul>
        )
    }
}

export default StudentList