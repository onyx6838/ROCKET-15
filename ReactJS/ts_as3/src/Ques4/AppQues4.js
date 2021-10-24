import logo from '../logo.svg';
import '../App.css';
import Tab from './Tab'
import Form from './Form';

function AppQues4() {
    return (
        <div className="App">
            <header className="App-header">
                <img src={logo} className="App-logo" alt="logo" />
                <Tab />
                <Form/>
            </header>
        </div>
    );
}

export default AppQues4;