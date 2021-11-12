import { ADD_TODO, REMOVE_TODO, EDIT_TODO, FILTER_TODO, MARK_TODO_COMPLETED } from './actionTypes'

export const addTodo = (text) => {
    return ({
        type: ADD_TODO,
        text: text
    })
}

export const filterTodo = (filter) => {
    return {
        type: FILTER_TODO,
        filter: filter
    }
}

export const markTodoCompleted = (id, completed) => {
    return {
        type: MARK_TODO_COMPLETED,
        id: id,
        completed: completed
    }
}

export const removeTodo = (id) => {
    return {
        type: REMOVE_TODO,
        id: id
    }
}

export const editTodo = (id, text) => {
    return {
        type: EDIT_TODO,
        id: id,
        text: text
    }
}