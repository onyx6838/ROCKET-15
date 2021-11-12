import React from 'react';
import TodoList from './components/TodoList';
import { getListTodoAsyncAction } from "./redux/actionCreators/todoActionCreator";
import store from './redux/store';

class App extends React.Component {

  getListEmployee = () => {
    store.dispatch(getListTodoAsyncAction());
  }

  componentDidMount() {
    this.getListEmployee();
  }

  render() {
    return (
      <div>
        <TodoList />
      </div>
    );
  }
}

export default App;

