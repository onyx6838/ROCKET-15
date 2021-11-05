import React from 'react'

function TodoList({ todos, completeTodo, removeTodo }) {
    const getEditTodo = (id) => {
        console.log(id);
    }

    const rows = todos.map((todo, _) => {
        return (
            <div key={todo.id}>
                <span>{todo.text}</span>
                <input type="checkbox" name="cbx-completed" onClick={() => completeTodo(todo.id)} /> |
                <span style={{ color: "red", cursor: "pointer" }} onClick={() => removeTodo(todo.id)}>x</span>
                <span style={{ color: "yellow", cursor: "pointer" }}
                    onClick={() => getEditTodo(todo.id)}> | edit</span>
            </div>)
    });

    return (
        <div>
            {rows}
        </div>
    )
}

export default TodoList