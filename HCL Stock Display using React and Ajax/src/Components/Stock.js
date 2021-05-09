import React, {Component} from 'react';
import axios from 'axios';

//class Stock with state high and low set to 0
class Stock extends Component{
  // constructor(props) {
  //   super(props);
  //   this.state = {
  //     high: 0,
  //     low: 0
  //   };
  // }
  constructor(props) {
    super(props);
    this.state = {
      content: "",
    };
  }
//
//   componentDidMount() {
//   //fetching HCL stock price using API
// 	axios.get('https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=HCLTECH.BSE&outputsize=full&apikey=ZT190HZDN99BS851')
// 	  //baseURL: 'http://localhost:8082/',
//     .then((res) => {
//       this.setState({
// 		  high: res.data["Time Series (Daily)"]["2021-04-30"]["2. high"],
//       low: res.data["Time Series (Daily)"]["2021-04-30"]["3. low"]
// 		})
// 		console.log(res.data["Time Series (Daily)"]["2021-04-30"]);
// 		})
// 	  .catch(err =>{
// 		console.log('Error from Event');
// 	  });
//   };
//
// //Displaying stock price
//   render(){
    /*{return(
      <div>
        <center><h2>BSE: {this.state.high}</h2>
        <h2>NSE: {this.state.low}</h2></center>

      </div>}
    );*/
//   }
componentDidMount() {
  this.retrieveData();
}

retrieveData() {
  var comp = this;
  var xhttpr = new XMLHttpRequest();
  xhttpr.onreadystatechange = function () {
    if (this.readyState === 4 && xhttpr.status === 200) {
      console.log("The response retrieved is ", JSON.parse(xhttpr.responseText));
      var temp = JSON.parse(xhttpr.responseText)
      comp.setState({ content: temp["Time Series (Daily)"]["2021-04-30"]["2. high"]});
    }
  };
  xhttpr.open("GET", "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=HCLTECH.BSE&outputsize=full&apikey=ZT190HZDN99BS851");
  xhttpr.send();
}

render() {

  return (
    <div>
      <h2> Content : {this.state.content} </h2>
    </div>
  );
}
}

export default Stock;
