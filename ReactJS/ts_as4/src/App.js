
import './App.css';
import FormContainer from './Ex2/containers/FormContainer';

const styles = {
  fontFamily: "sans-serif",
  textAlign: "center"
};

function App() {
  return (
    <div className="col-md-6" style={styles}>
      <h3> Sample Form Container </h3>
      <FormContainer />
    </div>
  );
}

export default App;
