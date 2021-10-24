import logo from './logo.svg';
import './App.css';
import NonJSX from './NonJSX';
import ClassComponent from './ClassComponent';
import ParentComponent from './ParentComponent';
import Person from './Person';
import Clock from './Clock';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <a className="App-link" href="https://reactjs.org" target="_blank" rel="noopener noreferrer">
          Learn React
        </a>
        <NonJSX />
        <ClassComponent />
        <ParentComponent />
        <Person fullName="Minh Giang" age="21" />
        <Clock/>
      </header>
    </div>
  );
}

export default App;