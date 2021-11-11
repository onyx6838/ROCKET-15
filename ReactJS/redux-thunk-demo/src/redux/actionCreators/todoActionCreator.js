import todoApi from "../../api/TodoApi";
import { GET_LIST_TODO } from "../actionTypes";

const listTodoAction = (todos) => {
    return {
        type: GET_LIST_TODO,
        payload: todos
    };
}

export const getListTodoAsyncAction = () => {
    return async dispatch => {
        try {
            const todos = await todoApi.getAll();
            dispatch(listTodoAction(todos));
        } catch (error) {
            console.log(error);
        }
    };
};