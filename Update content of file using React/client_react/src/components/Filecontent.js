import React, { Component } from "react";

class Filecontent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      content: "",
    };
  }

  componentDidMount() {
    this.retrieveData();
  }

  retrieveData() {
    var comp = this;
    var xhttpr = new XMLHttpRequest();
    xhttpr.onreadystatechange = function () {
      if (this.readyState === 4 && xhttpr.status === 200) {
        console.log("The response retrieved is ", xhttpr.responseText);
        comp.setState({ content: xhttpr.responseText });
      }
    };
    xhttpr.open("GET", "http://localhost:9000/getfile");
    xhttpr.send();
  }

  render() {
    function updatecontent() {
      const data = { content: document.getElementById("textcontent").value };
      var xhttpr = new XMLHttpRequest();
      xhttpr.onreadystatechange = function () {
        if (xhttpr.readyState === 4 && xhttpr.status === 200) {
          alert(xhttpr.responseText);
        }
      };
      xhttpr.open("POST", "http://localhost:9000/updatefile", true);
      xhttpr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
      xhttpr.send(`content=${data.content}`);
    }
    return (
      <div>
        <h2> Existing Content : {this.state.content} has been rendered</h2>
        <h3>Enter new content</h3>
        <textarea id="textcontent"></textarea>
        <button onClick={updatecontent}> Update</button>
      </div>
    );
  }
}

export default Filecontent;
