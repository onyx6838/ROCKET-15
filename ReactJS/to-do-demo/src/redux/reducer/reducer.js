import { ADD_TODO, REMOVE_TODO, EDIT_TODO, MARK_TODO_COMPLETED } from '../actionTypes'

const initialState = [];

const reducer = (state = initialState, action) => {
    switch (action.type) {
        case ADD_TODO:
            return [...state, {
                id: Date.now(),
                text: action.text,
                completed: false
            }]
        case REMOVE_TODO:
            return state.filter(todo => todo.id !== action.id);
        case MARK_TODO_COMPLETED:
            const index = state.findIndex(todo => todo.id === action.id)
            state[index].completed = action.completed
            return state;
        case EDIT_TODO:
            return state.map(todo => {
                if (todo.id !== action.id) return todo;
                return {
                    ...todo,
                    text: action.text
                }
            })
        default:
            return state;
    }
}

export default reducer