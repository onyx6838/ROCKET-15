import './App.css';
import Counter from './Counter';
import store from './store';

function App() {
  const cong = () => {
    store.dispatch({ type: 'counter/incremented' })
  }

  const tru = () => {
    store.dispatch({ type: 'counter/decremented' })
  }

  // store.subscribe(() => {
  //   console.log(store.getState());
  // })

  return (
    <div className="App">
      <header className="App-header">
        <div>
          {/* <p className="count">{store.getState().value}</p> */}
          <Counter />
          <button onClick={cong}>Cong</button>
          <button onClick={tru}>Tru</button>
        </div>
      </header>
    </div>
  );
}

export default App;