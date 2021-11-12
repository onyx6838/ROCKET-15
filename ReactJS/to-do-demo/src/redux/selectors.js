import { VISIBILITY_FILTERS } from "../constants"

export const getTodosByFilter = (store, filterReducer) => {
    switch (filterReducer) {
        case VISIBILITY_FILTERS.COMPLETED:
            return store.reducer.filter(todo => todo.completed === "completed")
        case VISIBILITY_FILTERS.PENDING:
            return store.reducer.filter(todo => todo.completed === "pending")
        case VISIBILITY_FILTERS.ALL:
        default:
            return store.reducer
    }
}