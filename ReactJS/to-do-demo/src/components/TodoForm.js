import React, { useState } from 'react'
import { useDispatch } from 'react-redux'
import { addTodo } from '../redux/action'

function TodoForm() {   // { onSubmit }
    const [content, setContent] = useState('')

    const dispatch = useDispatch();

    const handleSubmit = e => {
        e.preventDefault();
        // onSubmit({
        //     id: Math.floor(Math.random() * 100),
        //     text: content,
        //     status: "pending"
        // })  // parent cb
        dispatch(addTodo(content))
        setContent('')
    }

    return (
        <form onSubmit={handleSubmit}>
            <input type="text" placeholder="Add a todo" value={content} name="text"
                onChange={(e) => setContent(e.target.value)} />
            <button type="submit">Add Todo</button>
        </form>
    )
}

export default TodoForm;