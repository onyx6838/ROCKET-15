import * as types from "../constants";

const initialState = {
    groups: [],
    page: 1,
    size: 3,
    totalSize: 0,
    minTotalMember: null,
    maxTotalMember: null
};

export default function reducer(state = initialState, actions) {
    switch (actions.type) {
        case types.GET_LIST_GROUP:
            return {
                ...state,
                groups: actions.payload.groups,
                page: actions.payload.page,
                totalSize: actions.payload.totalSize,
                minTotalMember: actions.payload.minTotalMember,
                maxTotalMember: actions.payload.maxTotalMember
            };
        default:
            return state;
    }
}