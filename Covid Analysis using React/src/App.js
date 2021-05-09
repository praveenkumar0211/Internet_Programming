import React, {Component} from 'react';
import { BrowserRouter as Router, Route,Switch } from 'react-router-dom';
import {Redirect} from 'react-router-dom';

import Stats from './Components/Stats'
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
        <center><h1>Covid 19 Stats:</h1>
                <h2>State vise details</h2></center>
                
                <Stats prov="Tamil Nadu"/>
        <Stats prov="Kerala"/>
        <Stats prov="Puducherry"/>
        <Stats prov="Telangana"/>
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
