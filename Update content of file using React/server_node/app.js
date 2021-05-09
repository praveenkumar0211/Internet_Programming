const express = require("express");
const cors = require("cors");
const fs = require("fs");
const bodyParser = require("body-parser");
const app = express();

app.use(cors({ origin: true, credentials: true }));
app.use(bodyParser.urlencoded({ extended: true }));
app.use(express.json({ extended: false }));

app.get("/", (req, res) => {
    res.send("hello world");
});

app.get("/getfile", (req, res) => {
    fs.readFile("information.txt", "utf8", function(err, data) {
        res.send(data);
    });
});

app.post("/updatefile", (req, res) => {
    console.log('Request is: ' + JSON.stringify(req.body));
    console.log('Content is: ' + req.body.content)
    fs.writeFile("information.txt", req.body.content, function(err) {
        if (!err) res.send("Successfully updated database");
        else res.send("Failed to update");
    });
});

const port = 9000;
app.listen(port, () => {
    console.log("Server Running on port " + port);
});