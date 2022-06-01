package com.magna.swing.java.api.groups;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.magna.swing.java.database.connection.Connection;
import com.magna.swing.java.database.connection.Database;
import org.json.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.net.InetAddress;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class RecordData {

    Connection configMysql = new Connection("mysql");
    JdbcTemplate conMysql = new JdbcTemplate(configMysql.getDatasource());

    Connection configAzure = new Connection("azure");
    JdbcTemplate conAzure = new JdbcTemplate(configAzure.getDatasource());

    Processador processador = new Processador();
    Memoria memoria = new Memoria();
    Looca looca = new Looca();
    List<Volume> volumeGroup = looca.getGrupoDeDiscos().getVolumes();
    DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();
    List<Disco> discos = grupoDeDiscos.getDiscos();
    JSONObject json = new JSONObject();

    public void saveRecord() throws InterruptedException, IOException, SQLException, ClassNotFoundException {
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
                Double cpuUso = processador.getUso();

                if (memUso > 2000) {
                    json.put("text", ""
                            + ":fire: *ALERTA - MEMÓRIA* :fire:\n\n"
                            + "MEMÓRIA COM USO ACIMA DO RECOMENDADO\n");
                    Slack.enviarMensagem(json);

                }
                if (discoUso > 500) {
                    json.put("text", ""
                            + ":fire: *ALERTA - DISCO* :fire:\n\n"
                            + "DISCO COM USO ACIMA DO RECOMENDADO\n");
                    Slack.enviarMensagem(json);
                }
                if (cpuUso > 25.0) {
                    json.put("text", ""
                            + ":fire: *ALERTA - CPU* :fire:\n\n"
                            + "CPU COM USO ACIMA DO RECOMENDADO\n");
                    Slack.enviarMensagem(json);
                }

//                    Integer fkTotem = conAzure.queryForObject("select top 1 id from totem where hostname = " +
//                            "'" + InetAddress.getLocalHost().getHostName() + "' order by id desc", Integer.class);
//                List<TotemRepository> fkTotem = conAzure.query("SELECT id FROM totem WHERE hostname = ? ",
//                        new BeanPropertyRowMapper<>(TotemRepository.class), new Object[]{InetAddress.getLocalHost().getHostName()} );
                Database database = new Database();
           
                Integer fkTotem = database.getFkTotem(InetAddress.getLocalHost().getHostName(), "azure");

               // Integer fkTotemMySql = database.getFkTotem(InetAddress.getLocalHost().getHostName(), "mysql");

                System.out.println(fkTotem);

                System.out.println("Inserindo na Azure");
                // Insert para Azure
                conAzure.update("INSERT INTO registro(uso_disco, disponivel_disco, uso_cpu, disponivel_ram, uso_ram,fk_totem, dh_registro)"
                        + " VALUES(?, ?, ?, ?, ?, ?, ?) ",
                        discoUso, discoDisp, processador.getUso(), memDisp, memUso, fkTotem, LocalDateTime.now());

                System.out.println("Inserindo no MySQL");
                // Insert para MySql
//                conMysql.update("INSERT INTO registro(uso_disco, disponivel_disco, uso_cpu, disponivel_ram, uso_ram,fk_totem, dh_registro)"
   //                     + " VALUES(?, ?, ?, ?, ?, ?, ?) ",
 //                       discoUso, discoDisp, processador.getUso(), memDisp, memUso, fkTotemMySql, LocalDateTime.now());

            }
        }
    }
}
