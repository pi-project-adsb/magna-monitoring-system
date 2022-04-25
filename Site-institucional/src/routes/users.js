var express = require("express");
var router = express.Router();

var userController = require("../controllers/userController");

router.get("/", function (req, res) {
    userController.testar(req, res);
});

router.get("/:id", function (req, res) {
    userController.findUserById(req, res);
})

router.post("/login", function(req, res) {
    userController.entrar(req, res);
})

router.post("/signup", function(req, res) {
    userController.cadastrar(req, res);
})

module.exports = router;