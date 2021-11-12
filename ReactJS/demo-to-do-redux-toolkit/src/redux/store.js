import { configureStore } from '@reduxjs/toolkit';
import filterReducer from './filterSlice';
import todoReducer from './todoSlice';

export default configureStore({
	reducer: {
        todos: todoReducer,
		filters: filterReducer
	}
});
