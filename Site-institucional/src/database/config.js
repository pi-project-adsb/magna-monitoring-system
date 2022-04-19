var sql = require('mssql');

// SQL SERVER CREDENTIALS
var connection = ({
    user: "adm",
    password: "#Gfgrupo8",
    database: "bd-magna",
    server: "projeto-hiveward.database.windows.net",
    port: 1433,
    pool: {
        max: 10,
        min: 0,
        idleTimeoutMillis: 30000
    },
    options: {
        encrypt: true, // for azure
    }
})




function executar(qry) {

    sql.connect(connection, function (err) {

        if (err){
            console.log(err)
        } ;

        // create Request object
        var request = new sql.Request();

        // query to the database and get the records
        request.query(qry, function (err, recordset) {

            if (err) console.log(err)

            // send records as a response
            // return recordset
            console.log("Medida inserida");
        })
    })
}

module.exports = {
    executar
}