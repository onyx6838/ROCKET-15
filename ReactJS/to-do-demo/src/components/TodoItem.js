import React, { useState } from 'react'
import { useDispatch } from 'react-redux'
import { editTodo, markTodoCompleted, removeTodo } from '../redux/action';

const TodoItem = ({ todo }) => {
    const [editing, setEditing] = useState(false);
    const [newText, setNewText] = useState('');
    const dispatch = useDispatch();

    const saveTodo = () => {
        dispatch(editTodo(todo.id, newText))
        setEditing(false);
    }

    return (
        <div >
            {
                editing ? <input type="text"
                    defaultValue={todo.text}
                    onChange={(e) => setNewText(e.target.value)} />
                    : <span>{todo.text}</span>
            }
            <input type="checkbox" name="cbx-completed"
                onClick={() => dispatch(markTodoCompleted(todo.id))} /> |
            <span style={{ color: "red", cursor: "pointer" }}
                onClick={() => dispatch(removeTodo(todo.id))}>x</span>
            {
                editing ? <span style={{ color: "yellow", cursor: "pointer" }} onClick={saveTodo}> | Save</span> :
                    <span style={{ color: "blue", cursor: "pointer" }}
                        onClick={() => setEditing(true)} > | edit</span>
            }
        </div>
    )
}

export default TodoItem
