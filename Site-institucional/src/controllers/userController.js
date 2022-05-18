var userModel = require("../model/userModel");


function testar(req, res) {
    console.log("FUNCINOU");
    userModel.listar()
        .then(
            function(result){
                res.json(result);
            }
        ).catch(function(err){
            res.status(500).json(err.sqlMessage);
        })
}


function entrar(req, res) {
    var email = req.body.emailServer;
    var senha = req.body.senhaServer;

    if (email == undefined) {
        res.status(400).send("Seu email está undefined!");
    } else if (senha == undefined) {
        res.status(400).send("Sua senha está indefinida!");
    } else {

        userModel.entrar(email, senha)
            .then(
                function (resultado) {
                    if (resultado.length == 1) {
                        console.log(resultado);
                        res.json(resultado[0]);
                    } else if (resultado.length == 0) {
                        res.status(403).send("Email e/ou senha inválido(s)");
                    } else {
                        res.status(403).send("Mais de um usuário com o mesmo login e senha!");
                    }
                }
            ).catch(
                function (erro) {
                    console.log(erro);
                    console.log("\nHouve um erro ao realizar o login! Erro: ", erro.sqlMessage);
                    res.status(500).json(erro.sqlMessage);
                }
            );
    }

}

function cadastrar(req, res) {
    var email = req.body.emailServer;
    var empresa = req.body.empresaServer;
    var cnpj = req.body.cnpjServer;
    var senha = req.body.senhaServer;

    if (email == undefined) {
        res.status(400).send("Seu email está undefined!");
    } else if (senha == undefined) {
        res.status(400).send("Sua senha está indefinida!");
    } else {

        userModel.cadastrar(email, empresa, cnpj, senha)
            .then(
                function (resultado) {
                    res.json(resultado)
                }
            ).catch(
                function (erro) {
                    console.log(erro);
                    console.log(
                        "\nHouve um erro ao realizar o cadastro! Erro: ",
                        erro.sqlMessage
                    );
                    res.status(500).json(erro.sqlMessage);
                }
            );
    }

}

function findUserById(req, res){
    
    var id = req.params.id;

    userModel.findUserById(id)
        .then(
            function(result){
                res.json(result);
            }
        ).catch(function (err) {
            res.status(500).json(err.sqlMessage);
        })
}

function numberTotem(req, res){

    var id = req.params.id;

    userModel.numberTotem(id)
        .then(
            function(result){
                res.json(result);
            }
        ).catch(function(err) {
            res.status(500).json(err.sqlMessage);
        })

}

module.exports = {
    entrar,
    testar, 
    cadastrar,
    findUserById,
    numberTotem
}