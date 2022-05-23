var bd = require("../database/config");


function listar(){
    return bd.execQuery(`SELECT * FROM empresa`);
}

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

function findUserById(id){
    return bd.execQuery(`
        SELECT * FROM empresa WHERE id = ${id};
    `);
}

function numberTotem(id){
    return bd.execQuery(`
        SELECT e.id AS id_empresa, t.id AS id_totem, t.hostname AS name_totem FROM totem t 
        INNER JOIN empresa e ON fk_empresa = e.id WHERE e.id = ${id};
    `);
}

function findTotemById(id){
    return bd.execQuery(`
        SELECT * FROM totem WHERE id = ${id};
    `);
}

function agendar(motivo, data_agendamento, descricao, fk_totem){
    return bd.execQuery(`
        INSERT INTO agendamentos (motivo, data_agendamento, descricao, fk_totem) VALUES (${motivo}, ${data_agendamento}, ${descricao}, ${fk_totem});
    `);
}

module.exports = {
    entrar,
    cadastrar,
    listar,
    findUserById,
    numberTotem,
    findTotemById,
    agendar
}



