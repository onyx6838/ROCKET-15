import React, { useState } from 'react';
import { useDispatch } from 'react-redux';
import { toggleTodo, deleteTodo, editTodo } from '../redux/todoSlice';

const TodoItem = ({ id, title, completed }) => {
	const dispatch = useDispatch();

	const [editing, setEditing] = useState(false);
	const [newText, setNewText] = useState('');

	const handleCompletedClick = () => {
		dispatch(toggleTodo({
			id: id,
			completed: !completed
		}))
	}

	const handleDeleteClick = () => {
		dispatch(deleteTodo({
			id: id
		}))
	}

	const handleEditClick = () => {
		setEditing(true)
	}

	const saveEdit = () => {
		dispatch(editTodo({ id: id, title: newText }))
		setEditing(false)
	}

	return (
		<li className={`list-group-item ${completed && 'list-group-item-success'}`}>
			<div className='d-flex justify-content-between'>
				<span className='d-flex align-items-center'>
					<input type='checkbox' className='mr-3' onChange={handleCompletedClick}></input>
					{title}
				</span>
				<span>
					{editing && <input type="text" defaultValue={title} onChange={(e) => setNewText(e.target.value)} />}
				</span>
				<div>
					{editing && <button onClick={saveEdit} className='btn btn-warning mr-1'>Save</button>}
					<button onClick={handleEditClick} className='btn btn-success mr-1'>Edit</button>
					<button onClick={handleDeleteClick} className='btn btn-danger mr-1'>Delete</button>
				</div>
			</div>
		</li>
	);
};

export default TodoItem;
