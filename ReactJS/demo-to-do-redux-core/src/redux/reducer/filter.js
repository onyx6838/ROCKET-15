import { VISIBILITY_FILTERS } from '../../constants'
import { FILTER_TODO } from '../actionTypes'

const initialState = VISIBILITY_FILTERS.ALL;

const filterReducer = (state = initialState, action) => {
    switch (action.type) {
        case FILTER_TODO:
            return action.filter;
        default:
            return state;
    }
}

export default filterReducer;