import React from 'react'
import TodoList from './TodoList';
import TodoForm from './TodoForm';
import { useSelector, useDispatch } from 'react-redux'
import { filterTodo } from '../redux/action'
import { VISIBILITY_FILTERS } from "../constants";
import { getTodosByFilter } from '../redux/selectors';

function Todo() {
    const { reducer, filterReducer } = useSelector(state => state)
    const todosFilter = getTodosByFilter(reducer, filterReducer)
    console.log(todosFilter);
    const dispatch = useDispatch();

    return (
        <div>
            <TodoForm />
            <div className="form-group">
                <button className='btn btn-primary mr-2'
                    onClick={() => dispatch(filterTodo(VISIBILITY_FILTERS.COMPLETED))}>Completed</button>
                <button className='btn btn-success mr-2'
                    onClick={() => dispatch(filterTodo(VISIBILITY_FILTERS.PENDING))}>Pending</button>
                <button className='btn btn-warning mr-2'
                    onClick={() => dispatch(filterTodo(VISIBILITY_FILTERS.ALL))}>All</button>
            </div>
            <TodoList todos={reducer} />
        </div>
    )
}

export default Todo