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

    const toggleCompleted = () => {
        dispatch(markTodoCompleted(todo.id, !todo.completed))
    }

    return (
        <li className='list-group-item'>
            <div className='d-flex justify-content-between'>
                <span className='d-flex align-items-center'>
                    <input type="checkbox" className='mr-3'
                        defaultChecked={todo.completed}
                        onChange={toggleCompleted} />{todo.text}
                </span>
                <span>
                    {editing &&
                        <input type="text"
                            defaultValue={todo.text} onChange={(e) => setNewText(e.target.value)} />}
                </span>
                {
                    editing ?
                        <button className='btn btn-warning mr-1' onClick={saveTodo}>Save</button> :
                        <>
                            <button className='btn btn-danger mr-1'
                                onClick={() => dispatch(removeTodo(todo.id))}>Delete</button>
                            <button className='btn btn-success mr-1'
                                onClick={() => setEditing(true)} >Edit</button>
                        </>
                }
            </div>
        </li>
    )
}

export default TodoItem