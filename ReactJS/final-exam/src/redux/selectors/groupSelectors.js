import { createSelector } from "@reduxjs/toolkit";

/** Selector **/
const groupSelector = (state) => state.group;

const selectGroupSelector =
    createSelector(groupSelector, state => state.groups);

const selectPageSelector =
    createSelector(groupSelector, state => state.page);

const selectSizeSelector =
    createSelector(groupSelector, state => state.size);

const selectTotalElementSelector =
    createSelector(groupSelector, state => state.totalElement);

const selectMinTotalMemberSelector = createSelector(
    groupSelector,
    state => state.minTotalMember);

const selectMaxTotalMemberSelector = createSelector(
    groupSelector,
    state => state.maxTotalMember);

const selectSortFieldSelector = createSelector(
    groupSelector,
    state => state.sortField);

const selectSortTypeSelector = createSelector(
    groupSelector,
    state => state.sortType);

const selectSearchSelector = createSelector(
    groupSelector,
    state => state.search);

/** function **/
export const selectListGroup = (state) => {
    return selectGroupSelector(state);
}

export const selectPage = (state) => {
    return selectPageSelector(state);
}

export const selectSize = (state) => {
    return selectSizeSelector(state);
}

export const selectTotalElement = (state) => {
    return selectTotalElementSelector(state);
}

export const selectSortField = (state) => {
    return selectSortFieldSelector(state);
}

export const selectSortType = (state) => {
    return selectSortTypeSelector(state);
}

export const selectMinTotalMember = (state) => {
    return selectMinTotalMemberSelector(state);
}

export const selectMaxTotalMember = (state) => {
    return selectMaxTotalMemberSelector(state);
}
export const selectSearch = (state) => {
    return selectSearchSelector(state);
}