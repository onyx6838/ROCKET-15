import { createSelector } from "@reduxjs/toolkit";

/** Selector **/
const groupSelector = (state) => state.group;

const selectGroupSelector =
    createSelector(groupSelector, state => state.groups);

const selectPageSelector =
    createSelector(groupSelector, state => state.page);

const selectSizeSelector =
    createSelector(groupSelector, state => state.size);

const selectTotalSizeSelector =
    createSelector(groupSelector, state => state.totalSize);

const selectMinTotalMemberSelector = createSelector(
    groupSelector,
    state => state.minTotalMember);

const selectMaxTotalMemberSelector = createSelector(
    groupSelector,
    state => state.maxTotalMember);

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
    return selectTotalSizeSelector(state);
}

export const selectMinTotalMember = (state) => {
    return selectMinTotalMemberSelector(state);
}

export const selectMaxTotalMember = (state) => {
    return selectMaxTotalMemberSelector(state);
}