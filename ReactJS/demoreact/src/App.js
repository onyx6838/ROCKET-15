import './App.css';
import React from 'react';
import Person from './Person';

const divStyle = {
  color: "red"
}

const handleClick = () => {
  console.log('clicked');
}

const url = 'https://d1iv5z3ivlqga1.cloudfront.net/wp-content/uploads/2021/02/30162047/huong-dan-hoc-reactjs-1.jpg';

function App() {
  return (
    <div className="App" style={divStyle}>
      <p onClick={handleClick}>Hello World</p>
      <img src={url} alt={'asdasd'}></img>
      <br/>
      <Person></Person>
      <Person></Person>
      <Person></Person>
    </div>
  );
}

export default App;