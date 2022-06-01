var dataModel = require('../model/dataModel');

function getDataCPU(req, res) {

    var id_totem = req.params.id;

    dataModel.getDataCPU(id_totem)
        .then(function (result) {
            if (result.length > 0) {
                res.status(200).json(result);
            } else {
                res.status(204).send("Nenhum resultado encontrado!");
            }
        }).catch(function (err) {
            res.status(500).json(err.sqlMessage);
        });
}

function getDataRAM(req, res) {

    var id_totem = req.params.id;

    dataModel.getDataRAM(id_totem)
        .then(function (result) {
            if (result.length > 0) {
                res.status(200).json(result);
            } else {
                res.status(204).send("Nenhum resultado encontrado!");
            }
        }).catch(function (err) {
            res.status(500).json(err.sqlMessage);
        });
}

function getDataDisk(req, res) {

    var id_totem = req.params.id;

    dataModel.getDataDisk(id_totem)
        .then(function (result) {
            if (result.length > 0) {
                res.status(200).json(result);
            } else {
                res.status(204).send("Nenhum resultado encontrado!");
            }
        }).catch(function (err) {
            res.status(500).json(err.sqlMessage);
        });
}

function getProcessTotem(req, res) {

    var id_totem = req.params.id;

    dataModel.getProcessTotem(id_totem)
        .then(function (result) {
            if (result.length > 0) {
                res.status(200).json(result);
            } else {
                res.status(204).send("Nenhum processo encontrado!");
            }
        }).catch(function (err) {
            res.status(500).json(err.sqlMessage);
        })
}


function getDataRealCPU(req, res) {

    var id_totem = req.params.id;

    dataModel.getDataRealCPU(id_totem)
        .then(function (result) {
            if (result.length > 0) {
                res.status(200).json(result);
            } else {
                res.status(204).send("Nenhum dado encontrado!");
            }
        }).catch(function (err) {
            res.status(500).json(err.sqlMessage);
        })
}

function getDataRealRAM(req, res) {

    var id_totem = req.params.id;

    dataModel.getDataRealRAM(id_totem)
        .then(function (result) {
            if (result.length > 0) {
                res.status(200).json(result);
            } else {
                res.status(204).send("Nenhum dado encontrado!");
            }
        }).catch(function (err) {
            res.status(500).json(err.sqlMessage);
        })
}

function getDataRealDisk(req, res) {

    var id_totem = req.params.id;

    dataModel.getDataRealDisk(id_totem)
        .then(function (result) {
            if (result.length > 0) {
                res.status(200).json(result);
            } else {
                res.status(204).send("Nenhum dado encontrado!");
            }
        }).catch(function (err) {
            res.status(500).json(err.sqlMessage);
        })
}

function getNextAgend(req, res) {

    var id_totem = req.params.id;

    dataModel.getNextAgend(id_totem)
        .then(function (result) {
            if (result.length > 0) {
                res.status(200).json(result);
            } else {
                res.status(204).send("Nenhum dado encontrado!");
            }
        }).catch(function (err) {
            res.status(500).json(err.sqlMessage);
        })
}

function updateRAMParams(req, res) {

    var tempo = req.body.tempoServer;
    var limite_dados = req.body.limiteServer;
    var id_totem = req.body.id_totemServer;

    dataModel.updateRAMParams(tempo, limite_dados, id_totem)
        .then(function(result){
            res.status(200).json(result);
        }).catch(function(err){
            res.status(500).json(err.sqlMessage);
        })
}

function updateCPUParams(req, res) {

    var tempo = req.body.tempoServer;
    var limite_dados = req.body.limiteServer;
    var id_totem = req.body.id_totemServer;

    dataModel.updateCPUParams(tempo, limite_dados, id_totem)
        .then(function(result){
            res.status(200).json(result);
        }).catch(function(err){
            res.status(500).json(err.sqlMessage);
        })
}

function updateDiskParams(req, res) {

    var tempo = req.body.tempoServer;
    var limite_dados = req.body.limite_dadosServer;
    var id_totem = req.body.id_totemServer;

    dataModel.updateDiskParams(tempo, limite_dados, id_totem)
        .then(function(result){
            res.status(200).json(result);
        }).catch(function(err){
            res.status(500).json(err.sqlMessage);
        })
}

function updateProcParams(req, res) {

    var qtd_proc = req.body.qtd_procServer;
    var id_totem = req.body.id_totemServer;

    dataModel.updateProcParams(qtd_proc, id_totem)
        .then(function(result){
            res.status(200).json(result);
        }).catch(function(err){
            res.status(500).json(err.sqlMessage);
        })
};

function getParams(req, res){
    var id_totem = req.params.id;

    dataModel.getParams(id_totem)
    .then(function(result){
        if(result.length > 0){
            res.status(200).json(result);
        }
    }).catch(function(err){
        res.status(500).json(err.sqlMessage);
    })
}


module.exports = {
    getDataCPU,
    getDataRAM,
    getDataDisk,
    getProcessTotem,
    getDataRealCPU,
    getDataRealRAM,
    getDataRealDisk,
    getNextAgend,
    updateRAMParams,
    updateCPUParams,
    updateDiskParams,
    updateProcParams,
    getParams
}