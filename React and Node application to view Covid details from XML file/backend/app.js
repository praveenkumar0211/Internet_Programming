const express=require("express");
const cors=require("cors");
const bodyParser =require('body-parser');
const fs=require('fs');

const app=express();
app.use(cors({origin:true,credentials:true}));
app.use(bodyParser.urlencoded({extended:false}));
app.use(express.json({extended:false}));
app.get("/",(req,res) =>{
    res.send("hello");
})
app.use("/covid",(req,res)=>{
    fs.readFile("covid.xml","utf8",function (err,data){
        res.send(data)
    })
})

const port =8082;
app.listen(port, () => {
    console.log('Server running on Port'+port);
})