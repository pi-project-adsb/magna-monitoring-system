package com.magna.datacapture.api.entity;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.magna.datacapture.database.Connection;
import org.springframework.jdbc.core.JdbcTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.List;

public class Record {

    Connection config = new Connection();
    JdbcTemplate con = new JdbcTemplate(config.getDatasource());
    Processador processador = new Processador();
    Memoria memoria = new Memoria();
    Looca looca = new Looca();
    List<Volume> volumeGroup = looca.getGrupoDeDiscos().getVolumes();
    DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();
    List<Disco> discos = grupoDeDiscos.getDiscos();


    public void saveRecord() throws InterruptedException, UnknownHostException {
        Thread.sleep(1000);

        Integer toMb = 1024;

        System.out.println("Coletando dados da cpu...");
        System.out.println("Coletando dados do disco...");
        System.out.println("Coletando dados da memória ram...");

        for (Disco disco : discos) {
            for (Volume volume : volumeGroup) {
                Long discoUso = (volume.getTotal() - volume.getDisponivel()) / toMb / toMb / toMb;
                Long discoDisp = volume.getDisponivel() / toMb / toMb / toMb;
                Long memDisp = memoria.getDisponivel() / toMb / toMb;
                Long memUso = memoria.getEmUso() / toMb / toMb;

                Integer fkTotem = con.queryForObject("SELECT TOP 1 id FROM totem WHERE hostname = " +
                        "'" + InetAddress.getLocalHost().getHostName() + "' ORDER BY id DESC", Integer.class);

                con.update("INSERT INTO registro(uso_disco, disponivel_disco, uso_cpu, disponivel_ram, uso_ram,fk_totem, dh_registro)" +
                                " VALUES(?, ?, ?, ?, ?, ?, ?) ",
                        discoUso, discoDisp, processador.getUso(), memDisp, memUso, fkTotem, LocalDateTime.now());
            }
        }
    }
}
