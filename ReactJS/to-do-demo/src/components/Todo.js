import React, { useState } from 'react'
import TodoList from './TodoList';
import TodoForm from './TodoForm';
import { useSelector } from 'react-redux'

function Todo() {
    const [todos, setTodos] = useState([]);
    const todos2 = useSelector(state => { console.log(state); return state })

    const addTodo = todo => {
        if (!todo.text) return;
        const newTodos = [todo, ...todos];
        setTodos(newTodos)
    }

    const setCompletedTodo = id => {
        let updatedTodos = todos.map(todo => {
            if (todo.id === id) todo.status = "completed";
            return todo;
        });
        setTodos(updatedTodos);
    }

    const getCompletedTodo = () => {
        let completedTodos = todos.filter(todo => todo.status === "completed");
        setTodos(completedTodos);
    }

    const removeTodo = id => {
        let removedTodos = todos.filter(todo => todo.id !== id);
        setTodos(removedTodos);
    }

    return (
        <div>
            <TodoForm onSubmit={addTodo} />
            <div>
                <button onClick={getCompletedTodo}>Completed</button>
                <button>Pending</button>
                <button>All</button>
            </div>
            <TodoList todos={todos2} completeTodo={setCompletedTodo} removeTodo={removeTodo} />
        </div>
    )
}

export default Todo