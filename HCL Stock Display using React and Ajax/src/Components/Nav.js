import React, {Component} from 'react';
import Contact from './Contact'

//Nav bar component
class Nav extends Component{
  render(){
    return(
      <div className="nav">
        <ul>
          <li><a href="/">Home</a></li>
          <li><a href="/contact">Contact Us</a></li>
        </ul>
      </div>
    );
  }
}

export default Nav;
