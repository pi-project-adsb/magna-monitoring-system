var bd = require('../database/config');

function getDataCPU(id_totem) {

    return bd.execQuery(`
        SELECT TOP 7 uso_cpu, dh_registro FROM registro WHERE fk_totem = ${id_totem} 
        ORDER BY id DESC;`
    );
}

function getDataRAM(id_totem) {

    return bd.execQuery(`
        SELECT TOP 7 uso_ram, dh_registro FROM registro WHERE fk_totem = ${id_totem} 
        ORDER BY id DESC;`
    );
}

function getDataDisk(id_totem) {

    return bd.execQuery(`
        SELECT TOP 7 uso_disco, dh_registro FROM registro WHERE fk_totem = ${id_totem} 
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
        `SELECT TOP 200 * FROM processo WHERE fk_totem = ${id_totem}`
    );
}

function getNextAgend(id_totem){
    return bd.execQuery(`
        SELECT TOP 1 id, CONVERT(VARCHAR, data_agendamento, 103) as data_agen, fk_totem FROM
        agendamento where status_concluido = 0 AND fk_totem = ${id_totem} ORDER BY data_agen
    `);
}


function updateRAMParams(tempo, limite_dados, id_totem){
    return bd.execQuery(
        `UPDATE parametrizacao
        SET tempo_ram = ${tempo}, uso_ram = ${limite_dados}
        WHERE fk_totem = ${id_totem} 
    `);
}

function updateCPUParams(tempo, limite_dados, id_totem){
    return bd.execQuery(
        `UPDATE parametrizacao
        SET tempo_cpu = ${tempo}, uso_cpu = ${limite_dados}
        WHERE fk_totem = ${id_totem} 
    `);
}

function updateDiskParams(tempo, limite_dados, id_totem){
    return bd.execQuery(
        `UPDATE parametrizacao
        SET tempo_disco = ${tempo}, uso_disco = ${limite_dados}
        WHERE fk_totem = ${id_totem} 
    `);
}

function updateProcParams(qtd_proc, id_totem){
    return bd.execQuery(
        `UPDATE parametrizacao
        SET qtd_proc = ${qtd_proc}
        WHERE fk_totem = ${id_totem} 
    `);
}


function getParams(id_totem){
    return bd.execQuery(
        `SELECT * FROM parametrizacao WHERE fk_totem = ${id_totem}
    `);
}

module.exports = {
    getDataCPU,
    getDataRAM,
    getDataDisk,
    getProcessTotem,
    getDataRealCPU,
    getDataRealRAM,
    getDataRealDisk,
    getNextAgend,
    updateRAMParams,
    updateCPUParams,
    updateDiskParams,
    updateProcParams,
    getParams
}