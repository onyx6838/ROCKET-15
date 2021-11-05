import './App.css';
import Clock1 from './Clock1';
import Clock2 from './Clock2';
import Counting from './components/Counting';
import LessText from './components/LessText';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <LessText text={`Focused, hard work is the real key to success. Keep your eyes on the goal, 
        and just keep taking the next step towards completing it `} maxLength={35} />
        <Counting timer={0} />
        <Clock1/>
        <Clock2/>
      </header>
    </div>
  );
}

export default App;