import React, {Component} from 'react';
class Stats extends Component{
  constructor(props) {
    super(props);
    this.state = {
      active: "",
      recovered: "",
      death: "",
      confirmed: "",
      prov: this.props.prov,
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
        var temp = JSON.parse(xhttpr.responseText)
        temp.forEach(element => {
          if(element["Province"]===comp.state.prov)
          {
            comp.setState({ active: element["Active"],recovered:element["Recovered"],confirmed:element["Confirmed"],death:element["Deaths"]});
          }
        });
      }
    };
    xhttpr.open("GET", "https://api.covid19api.com/live/country/india/status/confirmed/date/2021-05-06T13:13:30Z");
    xhttpr.send();
  }
  render(){
    return(
      <div className="stat">
        <h1>State:{this.state.prov} </h1>
        <h3>Active:{this.state.active} </h3>
        <h3>Death:{this.state.death} </h3>
        <h3>Recovery:{this.state.recovered} </h3>
        <h3>Confirmed:{this.state.confirmed} </h3>
      </div>
    );
  }
}
    
export default Stats;