import './AppEx6.css';
// import Game from './Game';
import { Route, Switch } from 'react-router-dom';
import AboutUs from './AboutUs';
import ContactUs from './ContactUs';
import Home from './Home';
import ErrorWeb from './ErrorWeb';

function AppEx6() {
  return (
    <div className="App">
      <Switch>
        <Route path="/about" exact component={AboutUs} />
        <Route path="/contact" exact component={ContactUs} />
        <Route path="/" exact component={Home} />
        <Route component={ErrorWeb} />
      </Switch>
      {/* <Game /> */}
    </div>
  );
}
// default route (without path)
// dung exact hoac switch case de tranh multiple route
export default AppEx6;