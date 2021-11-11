import rootReducer from './reducer/index'
import { createStore } from "redux";
import thunk from 'redux-thunk'
import reducer from './reducer/reducer'

const store = createStore(reducer, 
    window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__());

export default store;