import * as types from "../constants";

export function getListGroupsAction(groups) {
    return {
        type: types.GET_LIST_GROUP,
        payload: groups
    };
}