import React,{Component} from "react";
class CovidComponent extends Component{
render(){
    return(
        <div>
    <div class="demo" id="demo"></div>
    <input type="button" onClick={previous} value="<<"></input>
    <input type="button" onClick={next} value=">>"></input>
    </div>
    );
}
}

var i=0;
var states;
display(i);
function display(i){
   var xhttp = new XMLHttpRequest();
   xhttp.onreadystatechange = function(){
       if(this.readyState==4 && this.status ==200){
           change(this,i);
       }
   }
   xhttp.open("GET","http://localhost:8082/covid",true);
   xhttp.send();
   
}
function change(res , i){
    var parser =new DOMParser();
    var xmldoc=parser.parseFromString(res.responseText,"text/xml");
    states=xmldoc.getElementsByTagName('STATE');
    var name,count,death;
    document.getElementById("demo").innerHTML="State:   "+states[i].getElementsByTagName("NAME")[0].childNodes[0].nodeValue+
    "<br>Positive cases:"+states[i].getElementsByTagName("COUNT")[0].childNodes[0].nodeValue + "<br>Death:"+states[i].getElementsByTagName("DEATH")[0].childNodes[0].nodeValue;
    

} 
function next() {
    if(i < states.length-1){
        i++;
        console.log("next");
        display(i);
    }
}
function previous(){
    if(i > 0){
        i--;
        console.log("previous");
        display(i);
    }
}
export default CovidComponent;

