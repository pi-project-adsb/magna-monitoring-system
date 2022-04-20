var bd = require("../database/config");

function entrar(email, senha){
    return bd.execQuery(`SELECT * FROM empresa WHERE email_empresa = '${email}' AND senha_empresa = '${senha}';`);
}


module.exports = {
    entrar
}



