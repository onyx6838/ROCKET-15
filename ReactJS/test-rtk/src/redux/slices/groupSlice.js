import { createSlice, createAsyncThunk } from '@reduxjs/toolkit'
import GroupApi from '../../api/GroupApi';

/* middleware */
export const getGroupsAsync = createAsyncThunk('group/getGroupsAsync',
    async ({ page, sizePerPage, sortField, sortOrder, searchText }) => {
        const response = await GroupApi.getAll(page, sizePerPage, sortField, sortOrder, searchText);
        const groups = response.content
        const totalElements = response.totalElements;
        const size = response.size;
        return { groups, page, size, totalElements, searchText }
    }
)

const initialState = {
    data: [],
    page: 1,
    size: 4,
    totalElements: 0,
    search: undefined
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
            state.size = action.payload.size;
            state.totalElements = action.payload.totalElements;
            state.search = action.payload.searchText;
        }
    }
})

export default groupSlice.reducer