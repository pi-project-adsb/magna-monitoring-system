var metricaModel = require("../models/metricaModel");

var sessoes = [];

function ranking(req, res) {

    metricaModel.ranking()
        .then(
            function (resultado) {
                
                    console.log(`\nResultados encontrados: ${resultado.length}`);
                    console.log(`Resultados: ${JSON.stringify(resultado)}`); // transforma JSON em String

                    console.log(resultado);
                    res.json(resultado);
                
            }
            
        ).catch(
            function (erro) {
                console.log(erro);
                console.log("\nHouve um erro ao realizar o login! Erro: ", erro.sqlMessage);
                res.status(500).json(erro.sqlMessage);
            }
        );
}

module.exports = {
    ranking
}