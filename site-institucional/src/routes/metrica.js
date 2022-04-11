var express = require("express");
var router = express.Router();

var metricaController = require("../controllers/metricaController");

router.post("/ranking", function (req, res) {
    metricaController.ranking(req, res);

});

module.exports = router;