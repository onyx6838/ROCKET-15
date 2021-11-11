import { VISIBILITY_FILTERS } from '../../constants'
import { FILTER_TODO } from '../actionTypes'
import store from '../store'

const initialState = []

const filterReducer = (state = initialState, action) => {
    switch (action.type) {
        case FILTER_TODO:
            switch (action.filter) {
                case VISIBILITY_FILTERS.ALL:
                    state = [...action.todos2]
                    return state;
                case VISIBILITY_FILTERS.COMPLETED:
                    state = [...action.todos2].filter(todo => todo.status === "completed")
                    return state;
                case VISIBILITY_FILTERS.PENDING:
                    state = [...action.todos2].filter(todo => todo.status === "pending")
                    return state;
                default:
                    return state;
            }
        default:
            return state;
    }
}

export default filterReducer;