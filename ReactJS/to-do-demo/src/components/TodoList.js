import React from 'react'
import TodoItem from './TodoItem';

function TodoList({ todos }) {

    const rows = todos.map((todo, _) => {
        return <TodoItem key={todo.id} todo={todo} />
    });

    return (
        <div>
            {rows}
        </div>
    )
}

export default TodoList