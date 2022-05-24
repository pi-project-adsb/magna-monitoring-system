var express = require("express");
var router = express.Router();

var userController = require("../controllers/userController");
var dataController = require('../controllers/dataController');

router.get("/", function (req, res) {
    userController.testar(req, res);
});

router.get("/:id", function (req, res) {
    userController.findUserById(req, res);
})

router.get("/hub/:id", function (req, res){
    userController.numberTotem(req, res);
})

router.get("/totem/:id", function (req, res){
    userController.findTotemById(req, res);
})

router.post("/login", function(req, res) {
    userController.entrar(req, res);
})

router.post("/signup", function(req, res) {
    userController.cadastrar(req, res);
})

router.post("/dashboard/agendar", function(req,res){
    userController.agendar(req, res);
})

module.exports = router;