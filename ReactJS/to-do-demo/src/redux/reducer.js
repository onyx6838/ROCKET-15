import { ADD_TODO, REMOVE_TODO, EDIT_TODO, MARK_TODO_COMPLETED } from './actionTypes'

const initTodos = [];

const reducer = (state = initTodos, action) => {
    switch (action.type) {
        case ADD_TODO:
            return [...state, {
                id: Math.floor(Math.random() * 100),
                text: action.text,
                status: "pending"
            }]
        case REMOVE_TODO:
            return state.filter(todo => todo.id !== action.id);
        case MARK_TODO_COMPLETED:
            return state.map(todo => {
                if (todo.id !== action.id) return todo;
                return { ...todo, status: "completed" } // de` len properties cua ... operator
            })
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