import * as types from "../constants";

const initialState = {
  groups: [],
  isLoading: false
};

export default function reducer(state = initialState, actions) {
  switch (actions.type) {
    case types.GET_LIST_GROUP:
      return {
        ...state,
        groups: actions.payload,
        isLoading: false
      };
    default:
      return state;
  }
}