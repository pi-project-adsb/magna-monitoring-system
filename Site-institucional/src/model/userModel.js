var bd = require("../database/config");

function entrar(email, senha){
    return bd.execQuery(
        `SELECT * FROM empresa WHERE email = '${email}' AND senha = '${senha}';`
    );
}

function cadastrar(email, empresa, cnpj, senha) {
    return bd.execQuery(
        `INSERT INTO empresa (email, nome, cnpj, senha) VALUES ('${email}', '${empresa}', '${cnpj}', '${senha}');`
    );
}

module.exports = {
    entrar,
    cadastrar
}



