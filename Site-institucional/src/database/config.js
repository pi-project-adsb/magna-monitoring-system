var sql = require('mssql');

// AZURE CREDENTIALS
var config = ({
    user: "admin-magna",
    password: "2ads#grupo6",
    database: "bd-magna",
    server: "magna-monitoring-system.database.windows.net",
    port: 1433,
    pool: {
        max: 10,
        min: 0,
        idleTimeoutMillis: 30000
    },
    options: {
        encrypt: true,
    }
})

function execQuery(qry) {
    return new Promise((resolve, reject) => {
        sql.connect(config).then(function () {
            return sql.query(qry);
        }).then(function (resultados) {
            console.log(resultados);
            resolve(resultados.recordset);
        }).catch(function (erro) {
            reject(erro);
            console.log('ERRO: ', erro);
        });
        sql.on('error', function (erro) {
            return ("ERRO NO SQL SERVER (Azure): ", erro);
        });
    })
}

module.exports = {
    execQuery
};

