import * as types from "../constants";

export function getListGroupsAction(groups, page, totalSize, minTotalMember, maxTotalMember) {
    return {
        type: types.GET_LIST_GROUP,
        payload: {
            groups,
            page,
            totalSize,
            minTotalMember,
            maxTotalMember
        }
    };
}