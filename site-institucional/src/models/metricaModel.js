var database = require("../database/config")

function ranking() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function trocar(): ")
    var instrucao = `
                    SELECT COUNT(fkFilme) AS TotalFilme, fi.titulo FROM usuario us
                        JOIN filme fi ON us.fkFilme = fi.idFilme 
                            GROUP BY titulo ORDER BY TotalFilme DESC;

    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

module.exports = {
    ranking
};