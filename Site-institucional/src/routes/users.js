var express = require("express");
var router = express.Router();

var userController = require("../controllers/userController");

router.post("/login", (req, res) => {
    userController.entrar(req, res);
})


module.exports = router;