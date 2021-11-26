import { createSelector } from "@reduxjs/toolkit";

/** Selector **/
const groupSelector = (state) => state.groups;

const selectListGroupSelector = createSelector(
    groupSelector,
    state => state.data);

const selectPageSelector = createSelector(
    groupSelector,
    state => state.page);

const selectSizeSelector = createSelector(
    groupSelector,
    state => state.size);

const selectTotalElementsSelector = createSelector(
    groupSelector,
    state => state.totalElements);

/** function */
export const selectListGroup = (state) => {
    return selectListGroupSelector(state);
}

export const selectPage = (state) => {
    return selectPageSelector(state);
}

export const selectSize = (state) => {
    return selectSizeSelector(state);
}
export const selectTotalElements = (state) => {
    return selectTotalElementsSelector(state);
}