import React, { useState } from 'react'

function TodoForm({ onSubmit}) {
    const [content, setContent] = useState('')

    const handleChange = e => {
        setContent(e.target.value);
    }

    const handleSubmit = e => {
        e.preventDefault();
        onSubmit({
            id: Math.floor(Math.random() * 100),
            text: content,
            status: "pending"
        })  // parent cb
        setContent('')
    }

    return (
        <form onSubmit={handleSubmit}>
            <input type="text" placeholder="Add a todo" value={content} name="text" 
            onChange={handleChange} />
            <button type="submit">Add Todo</button>
        </form>
    )
}

export default TodoForm;