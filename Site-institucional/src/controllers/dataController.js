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

module.exports = {
    getDataCPU,
    getDataRAM,
    getDataDisk
}