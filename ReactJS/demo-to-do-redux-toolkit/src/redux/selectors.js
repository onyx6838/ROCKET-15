export const getTodosByFilter = (store, filter) => {
    switch (filter) {
        case "completed":
            return store.todos.filter(todo => todo.completed)
        case "pending":
            return store.todos.filter(todo => !todo.completed)
        case "all":
        default:
            return store
    }
}