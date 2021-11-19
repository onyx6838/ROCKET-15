import * as types from "../constants";

const initialState = {
    groups: []
};

export default function reducer(state = initialState, actions) {
    switch (actions.type) {
        case types.GET_LIST_GROUP:
            return {
                ...state,
                groups: actions.payload
            };
        default:
            return state;
    }
}
