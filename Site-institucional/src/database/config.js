var sql = require('mssql');

// SQL SERVER CREDENTIALS
var connection = ({
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
    sql.connect(connection)
        .then(() => {
            return sql.query(qry);
        }).then((result) => {
            console.log(result);
        }).catch((err) => {
            console.log(err);
        })
};

module.exports = {
    execQuery
};

