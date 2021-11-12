import React, { useState } from 'react'
import { useDispatch } from 'react-redux';
import { setFilterTodo } from '../redux/filterSlice';

function TodoFilter() {
    const dispatch = useDispatch();
    const [filter, setFilter] = useState('');

    const handleFilterChange = (e) => {
        setFilter(e.target.value)
        dispatch(setFilterTodo({ filter: e.target.value }))
    }

    return (
        <div className="form-group">
            <label>Filter</label>
            <select className="form-control" value={filter} onChange={handleFilterChange}>
                <option value="All">All</option>
                <option value="Completed">Completed</option>
                <option value="Pending">Pending</option>
            </select>
        </div>
    )
}

export default TodoFilter