import React, {Component} from 'react';
import { BrowserRouter as Router, Route,Switch } from 'react-router-dom';
import {Redirect} from 'react-router-dom';

import Stock from './Components/Stock'
import Nav from './Components/Nav'
import Contact from './Components/Contact'
import './App.css';

class App extends Component  {
  render(){
    return (
      <Router>
      <Switch>
        <Route exact path="/">

      <div className = "App">
        <Nav />
        <center><h1>HCL Technologies</h1>
                <h2>Stock Price</h2></center>
        <Stock />
      </div>

      </Route>

      <Route exact path="/contact">
        <Contact />
      </Route>
    </Switch>
    </Router>
    );
  }
}

export default App;
