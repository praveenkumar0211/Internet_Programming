import './App.css'
import { BrowserRouter as Router, Route,Switch } from 'react-router-dom';
import {Redirect} from 'react-router-dom';
import CovidComponent from "./Components/CovidComponent"
import Nav from './Components/Nav'
import Contact from './Components/Contact'

import Rules from './Components/Rules'

function App(){
return(
<Router>
      <Switch>
        <Route exact path="/">


    <div className="App">
         
         <Nav />

        <h1>Covid 19 Analysis</h1>
        <h2>Positive cases and Death count State vise</h2>
        <CovidComponent />
       
        <Rules />
        <Contact />
        
        </div>
        </Route>
        
    </Switch>
    </Router>
);
}
export default App;