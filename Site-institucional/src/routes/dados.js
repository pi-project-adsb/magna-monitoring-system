var express = require("express");
var router = express.Router();

var dataController = require('../controllers/dataController');

// 1 para CPU, 2 para RAM e 3 para Disco.

router.get("/1/:id", function(req, res){
    dataController.getDataCPU(req, res);
});

router.get("/2/:id", function(req, res){
    dataController.getDataRAM(req, res);
});

router.get("/3/:id", function (req, res){
    dataController.getDataDisk(req, res);
});

router.get("/processos/:id", function(req, res){
    dataController.getProcessTotem(req, res);
});

module.exports = router;