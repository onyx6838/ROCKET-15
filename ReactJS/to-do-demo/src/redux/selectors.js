import { VISIBILITY_FILTERS } from "../constants"

export const getTodosByFilter = (todos, filterReducer) => {
    switch (filterReducer) {
        case VISIBILITY_FILTERS.COMPLETED:
            return todos.filter(todo => todo.completed)
        case VISIBILITY_FILTERS.PENDING:
            return todos.filter(todo => !todo.completed)
        case VISIBILITY_FILTERS.ALL:
        default:
            return todos
    }
}