import { combineReducers } from "redux";
import filterReducer from './filter'
import reducer from './reducer'

export default combineReducers({ filterReducer, reducer })