import React, { useState } from "react";
import selectListTodos from "../redux/selectors/todoSelector";
import store from "../redux/store";
import Todo from "./Todo";

function TodoList() {

    const [todos, updateTodos] = useState(selectListTodos());

    const todoList = todos.map((item, index) =>
        <Todo key={index} todo={item.todo} />
    );

    const updateList = () =>
        store.subscribe(() => updateTodos(selectListTodos()));

    updateList();

    return (
        <ul>
            {todoList}
        </ul>
    );
};

export default TodoList;
