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

router.get("/real-time/:id", function(req, res){
    dataController.getDataRealTime(req, res);
})

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

router.get("/agendamentos/:id", function(req, res){
    dataController.getNextAgend(req, res);
});

// UPDATE PARAMETRIZAÇÃO

router.post("/1/limites", function(req, res){
    dataController.updateRAMParams(req, res);
});

router.post("/2/limites", function(req, res){
    dataController.updateCPUParams(req, res);
});

router.post("/3/limites", function(req, res){
    dataController.updateDiskParams(req, res);
});

router.post("/4/limites", function(req, res){
    dataController.updateProcParams(req, res);
});

// GET DE PARAMETRIZAÇÃO

router.get("/limites/:id", function(req, res){
    dataController.getParams(req, res);
});


// AGENDAMENTOS

router.get("/agendamentos/check/:id", function(req, res){
    dataController.getAgendCheck(req, res);
});

router.get("/agendamentos/notCheck/:id", function (req, res){
    dataController.getAllAgends(req, res);
});

router.post("/agendamentos/update", function(req, res){
    dataController.updateAgend(req, res);
})

router.get("/agendamentos/lastAgend/:id", function(req, res){
    dataController.lastAgend(req, res);
})

module.exports = router;