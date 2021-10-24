import React from 'react';
import ReactDOM from 'react-dom';
// import AppEx4 from './Ex4/AppEx4';
import './index.css';
// import App from './App';
// import AppQues4 from './Ques4/AppQues4';
import AppEx5 from './Ex5/AppEx5'
import reportWebVitals from './reportWebVitals';

ReactDOM.render(
  <React.StrictMode>
    <AppEx5/>
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
