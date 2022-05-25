var bd = require('../database/config');

function getDataCPU(id_totem) {

    return bd.execQuery(`
        SELECT TOP 7 uso_cpu, dh_registro FROM registro WHERE fk_totem = ${id_totem} 
        ORDER BY id DESC;`
    );
}

function getDataRAM(id_totem) {

    return bd.execQuery(`
        SELECT uso_ram, dh_registro FROM registro WHERE fk_totem = ${id_totem} 
        ORDER BY id DESC;`
    );
}

function getDataDisk(id_totem) {

    return bd.execQuery(`
        SELECT uso_disco, dh_registro FROM registro WHERE fk_totem = ${id_totem} 
        ORDER BY id DESC;`
    );
}

function getDataRealCPU(id_totem){
    return bd.execQuery(`
        SELECT TOP 1 uso_cpu, dh_registro, fk_totem from registro WHERE fk_totem = ${id_totem} ORDER BY id DESC;
    `)
}

function getDataRealRAM(id_totem){
    return bd.execQuery(`
        SELECT TOP 1 uso_cpu, dh_registro, fk_totem from registro WHERE fk_totem = ${id_totem} ORDER BY id DESC;
    `)
}

function getDataRealDisk(id_totem){
    return bd.execQuery(`
        SELECT TOP 1 uso_cpu, dh_registro, fk_totem from registro WHERE fk_totem = ${id_totem} ORDER BY id DESC;
    `)
}

function getProcessTotem(id_totem){
    return bd.execQuery(
        `SELECT TOP 5 * FROM processo WHERE fk_totem = ${id_totem}`
    );
}

module.exports = {
    getDataCPU,
    getDataRAM,
    getDataDisk,
    getProcessTotem,
    getDataRealCPU,
    getDataRealRAM,
    getDataRealDisk
}