var express = require("express");
var cors = require("cors");
var path = require("path");
var port = 3333;

var app = express();

var indexRouter = require("./src/routes/index");
var userRouter = require("./src/routes/users");
var dataRouter = require("./src/routes/dados");

app.use(express.json());
app.use(express.urlencoded({ extended: false}));
app.use(express.static(path.join(__dirname, "public")));

app.use(cors());

app.use("/", indexRouter);
app.use("/users", userRouter);
app.use("/dados", dataRouter);

app.listen(port, () => {
    console.log(`Server is running on http://localhost:${port}`);
})