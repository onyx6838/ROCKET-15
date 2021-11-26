import { createSlice, createAsyncThunk } from '@reduxjs/toolkit'
import GroupApi from '../../api/GroupApi';

export const getGroupsAsync = createAsyncThunk('groupSlice/getGroupsAsync', async (page, size) => {
    const response = await GroupApi.getAll(page, size);
    const groups = response.content
    const totalElements = response.totalElements;
    return { groups, page, totalElements }
})

const initialState = {
    data: [],
    page: 1,
    size: 3,
    totalElements: 0
}

const groupSlice = createSlice({
    name: 'groupSlice',
    initialState,
    reducers: {
    },
    extraReducers: {
        [getGroupsAsync.fulfilled]: (state, action) => {
            state.data = action.payload.groups;
            state.page = action.payload.page;
            state.totalElements = action.payload.totalElements;
        }
    }
})

export default groupSlice.reducer