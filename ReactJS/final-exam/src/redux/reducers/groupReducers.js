import * as types from "../constants";

const initialState = {
    groups: [],
    page: 1,
    size: 3,
    totalElement: 0,
    // filtering
    minTotalMember: undefined,
    maxTotalMember: undefined,
    // searching
    search: undefined,
    sortField: null,
    sortType: null
};

export default function reducer(state = initialState, actions) {
    switch (actions.type) {
        case types.GET_LIST_GROUP:
            return {
                ...state,
                groups: actions.payload.groups,
                page: actions.payload.page,
                totalElement: actions.payload.totalElement,
                minTotalMember: actions.payload.minTotalMember,
                maxTotalMember: actions.payload.maxTotalMember,
                search: actions.payload.search,
                sortField: actions.payload.sortField,
                sortType: actions.payload.sortType,
            };
        default:
            return state;
    }
}