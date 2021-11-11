import React from 'react'
import TodoList from './TodoList';
import TodoForm from './TodoForm';
import { useSelector, useDispatch } from 'react-redux'
import { filterTodo } from '../redux/action'
import { VISIBILITY_FILTERS } from "../constants";

function Todo() {
    const todos2 = useSelector(state => { return state })
    const dispatch = useDispatch();

    return (
        <div>
            <TodoForm />
            <div>
                <button onClick={() => dispatch(filterTodo(VISIBILITY_FILTERS.COMPLETED))}>Completed</button>
                <button onClick={() => dispatch(filterTodo(VISIBILITY_FILTERS.PENDING))}>Pending</button>
                <button onClick={() => dispatch(filterTodo(VISIBILITY_FILTERS.ALL))}>All</button>
            </div>
            <TodoList todos={todos2}/>
        </div>
    )
}

export default Todo