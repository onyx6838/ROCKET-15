import React from 'react';
import TodoItem from './TodoItem';
import { useSelector } from 'react-redux'
import { getTodosByFilter } from '../redux/selectors';

const TodoList = () => {
	const { todos, filters } = useSelector(state => state)

	const todosFilter = getTodosByFilter(todos, filters)
	return (
		<ul className='list-group'>
			{todosFilter.map((todo) => (
				<TodoItem key={todo.id} id={todo.id} title={todo.title} completed={todo.completed} />
			))}
		</ul>
	);
};

export default TodoList;
