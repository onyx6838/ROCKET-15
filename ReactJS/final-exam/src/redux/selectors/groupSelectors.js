import { createSelector } from "@reduxjs/toolkit";

/** Selector **/
const userLoginInfoSelector = (state) => state.group;

const selectGroupSelector =
    createSelector(userLoginInfoSelector, state => state.groups);

/** function **/
export const selectGroups = (state) => {
    return selectGroupSelector(state);
}