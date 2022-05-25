package com.magna.swing.java.api;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.magna.swing.java.database.connection.Connection;
import org.json.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.List;

public class Record {

    Connection config = new Connection();
    JdbcTemplate con = new JdbcTemplate(config.getDataSource());
    Processador processador = new Processador();
    Memoria memoria = new Memoria();
    Looca looca = new Looca();
    List<Volume> volumeGroup = looca.getGrupoDeDiscos().getVolumes();
    DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();
    List<Disco> discos = grupoDeDiscos.getDiscos();
    JSONObject json = new JSONObject();

    public void saveRecord() throws InterruptedException, IOException {
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
                    json.put("text", "" +
                            ":fire: *ALERTA - MEMÓRIA* :fire:\n\n" +
                            "MEMÓRIA COM USO ACIMA DO RECOMENDADO\n");
                    Slack.enviarMensagem(json);

                }
                if (discoUso > 500) {
                    json.put("text", "" +
                            ":fire: *ALERTA - DISCO* :fire:\n\n" +
                            "DISCO COM USO ACIMA DO RECOMENDADO\n");
                    Slack.enviarMensagem(json);
                }
                if (cpuUso > 25.0) {
                    json.put("text", "" +
                            ":fire: *ALERTA - CPU* :fire:\n\n" +
                            "CPU COM USO ACIMA DO RECOMENDADO\n");
                    Slack.enviarMensagem(json);
                }
                    Integer fkTotem = con.queryForObject("SELECT TOP 1 id FROM totem WHERE hostname = " +
                            "'" + InetAddress.getLocalHost().getHostName() + "' ORDER BY id DESC", Integer.class);

                    con.update("INSERT INTO registro(uso_disco, disponivel_disco, uso_cpu, disponivel_ram, uso_ram,fk_totem, dh_registro)" +
                                    " VALUES(?, ?, ?, ?, ?, ?, ?) ",
                            discoUso, discoDisp, cpuUso, memDisp, memUso, fkTotem, LocalDateTime.now());
            }
        }
    }
}
