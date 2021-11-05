import React, { Component } from 'react'
import { Link, Route, Switch } from 'react-router-dom'
import Home from './Home'
import Category from './Category'
import AuthContext from './AuthContext'
import Admin from './Admin'
import Clock from './Clock'

class App extends Component {

  constructor(props) {
    super(props);

    this.state = {
      token: "",
      displayClock: true
    }
  }

  setToken = (value) => {
    this.setState({ token: value })
  }

  removeClock = () => {
    this.setState({ displayClock: false })
  }

  render() {
    const contextValue = {
      token: this.state.token,
      setToken: this.setToken
    };

    return (
      <AuthContext.Provider value={contextValue}>
        <div>
          <ul className="menu">
            <li className="item">
              <Link to="/">Home</Link>
            </li>
            <li className="item">
              <Link to="/category">Category</Link>
            </li>
            <li className="item">
              <Link to="/admin">Admin</Link>
            </li>
          </ul>

          <Switch>
            <Route exact path="/" component={Home} />
            <Route path="/category" >
              <Category />
            </Route>
            <Route path="/admin" component={Admin} />
          </Switch>
        </div>

        {
          this.state.displayClock && <Clock />
        }
        <button onClick={this.removeClock}>Remove clock</button>
      </AuthContext.Provider>
    )
  }
}

export default App