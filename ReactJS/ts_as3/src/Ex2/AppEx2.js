import logo from '../logo.svg';
import '../App.css';
import Table from './Table';
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import Clock from '../Clock';

function AppEx2() {
    const characterData = [
        {
            'language' :'Java',
            'framework':'Spring'
        },
        {
            'language' :'C#',
            'framework':'ASP.NET'
        },
        {
            'language' :'PHP',
            'framework':'Laravel'
        }
    ]

    return (
        <div className="App">
            <header className="App-header">
                <img src={logo} className="App-logo" alt="logo" />
                <Table characterData={characterData}/>
                <Clock/>
            </header>
        </div>
    );
}

export default AppEx2;