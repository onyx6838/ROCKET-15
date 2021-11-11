import { ADD_TODO, REMOVE_TODO, EDIT_TODO, MARK_TODO_COMPLETED, FILTER_TODO } from '../actionTypes'
import { VISIBILITY_FILTERS } from '../../constants'

const initialState = [];

const reducer = (state = initialState, action) => {
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
        case FILTER_TODO:
            switch (action.filter) {
                case VISIBILITY_FILTERS.COMPLETED:
                    return state.filter(todo => todo.status === "completed")
                case VISIBILITY_FILTERS.PENDING:
                    return state.filter(todo => todo.status === "pending")
                case VISIBILITY_FILTERS.ALL:
                default:
                    return state;
            }
        default:
            return state;
    }
}

export default reducer