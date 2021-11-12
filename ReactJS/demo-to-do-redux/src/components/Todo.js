import React from 'react'
import AddTodoForm from './AddTodoForm';
import TodoFilter from './TodoFilter';
import TodoList from './TodoList';

function Todo() {
    return (
        <>
            <AddTodoForm />
            <TodoFilter/>
            <TodoList />
        </>
    )
}

export default Todo
