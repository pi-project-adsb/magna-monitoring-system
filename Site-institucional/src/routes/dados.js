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

router.get("/1/real-time/:id", function (req, res){
    dataController.getDataRealCPU(req, res);
});

router.get("/2/real-time/:id", function (req, res){
    dataController.getDataRealRAM(req, res);
});

router.get("/3/real-time/:id", function (req, res){
    dataController.getDataRealDisk(req, res);
});

router.get("/processos/:id", function(req, res){
    dataController.getProcessTotem(req, res);
});

module.exports = router;