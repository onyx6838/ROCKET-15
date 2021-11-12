import React, { useState } from 'react'
import { useDispatch } from 'react-redux'
import { addTodo } from '../redux/action'

function TodoForm() {
    const [content, setContent] = useState('')

    const dispatch = useDispatch();

    const handleSubmit = e => {
        e.preventDefault();
        dispatch(addTodo(content))
        setContent('')
    }

    return (
        <form onSubmit={handleSubmit} className='form-inline mt-3 mb-3'>
            <label className='sr-only'>Name</label>
            <input type="text" className='form-control mb-2 mr-sm-2' placeholder="Add a todo"
                value={content} name="text"
                onChange={(e) => setContent(e.target.value)} />
            <button type="submit" className='btn btn-primary mb-2'>Add Todo</button>
        </form>
    )
}

export default TodoForm;