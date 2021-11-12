import { createSlice } from "@reduxjs/toolkit";

const filterSlice = createSlice({
    name: "filters",
    initialState: "all",
    reducers: {
        setFilterTodo: (state, action) => {
            return action.payload.filter
        }
    }
})

export const { setFilterTodo } = filterSlice.actions

export default filterSlice.reducer