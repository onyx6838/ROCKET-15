import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import ExampleContext from './context';

ReactDOM.render(
  <React.StrictMode>
    <ExampleContext.Provider value={{ test: "ggg" }}>
      <App />
    </ExampleContext.Provider>
  </React.StrictMode>,
  document.getElementById('root')
);