import { createSelector } from "@reduxjs/toolkit";

/** Selector **/
const groupSelector = (state) => state.group;

const selectListGroupSelector = createSelector(groupSelector, state => state.data);
const selectPageSelector = createSelector(groupSelector, state => state.page);
const selectSizeSelector = createSelector(groupSelector, state => state.size);
const selectTotalElementsSelector = createSelector(groupSelector, state => state.totalElements);
const selectSearchSelector = createSelector(groupSelector, state => state.search);

/** function */
export const selectListGroup = (state) => { return selectListGroupSelector(state); }
export const selectPage = (state) => { return selectPageSelector(state); }
export const selectSize = (state) => { return selectSizeSelector(state); }
export const selectTotalElements = (state) => { return selectTotalElementsSelector(state); }
export const selectSearch = (state) => { return selectSearchSelector(state); }