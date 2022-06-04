package com.magna.datacapture.api.entity;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import com.magna.datacapture.database.Connection;
import com.magna.datacapture.database.Database;
import com.magna.datacapture.repository.ParametrizacaoRepository;
import org.json.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.net.InetAddress;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

public class Record {

//    Connection configMysql = new Connection("mysql");
//    JdbcTemplate conMysql = new JdbcTemplate(configMysql.getDatasource());

    Connection configAzure = new Connection("azure");
    JdbcTemplate conAzure = new JdbcTemplate(configAzure.getDatasource());

    Processador processador = new Processador();
    Memoria memoria = new Memoria();
    Looca looca = new Looca();
    List<Volume> volumeGroup = looca.getGrupoDeDiscos().getVolumes();
    DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();
    List<Disco> discos = grupoDeDiscos.getDiscos();
    List<ParametrizacaoRepository> parameters;
    JSONObject json = new JSONObject();
    Temperatura temperatura = new Temperatura();



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

                Long ramTotal = memoria.getTotal() / 1024 / 1024;
                Long discoTotal = grupoDeDiscos.getTamanhoTotal() / 1024 / 1024 / 1024;

                Long mediaRam = (memUso * 100) / ramTotal;
                Long mediaDisco = (discoUso * 100) / discoTotal;
                Double cpuUso = processador.getUso();
                Database database = new Database();
                String desc;

                Integer fkTotemAzure = database.getFkTotem(InetAddress.getLocalHost().getHostName(), "azure");

                parameters = conAzure.query("SELECT * FROM parametrizacao WHERE fk_totem = ?",
                        new BeanPropertyRowMapper<>(ParametrizacaoRepository.class), fkTotemAzure);

                for (ParametrizacaoRepository parameter: parameters) {

                    if (mediaRam > parameter.getUsoRam()) {
                        json.put("text", ""
                            + ":fire: *ALERTA - MEMÓRIA* :fire:\n\n"
                            + "MEMÓRIA COM USO ACIMA DO RECOMENDADO\n");
                        Slack.enviarMensagem(json);

                        desc = String.format("Memória ram passou dos limites estipulados, atingindo %d MB, %d por cento do total!",
                                memUso, mediaRam);

                        conAzure.update("INSERT INTO log_alerta (dh_alerta, titulo, descricao, recurso, checked, fk_totem) " +
                                        "VALUES(?, ?, ?, ?, ?, ?) ",
                                LocalDateTime.now(), "MEMÓRIA RAM ACIMA DO RECOMENDADO", desc, "Memória RAM", 0, fkTotemAzure);
                    }
                    if (mediaDisco > parameter.getUsoDisco()) {
                        json.put("text", ""
                            + ":fire: *ALERTA - DISCO* :fire:\n\n"
                            + "DISCO COM USO ACIMA DO RECOMENDADO\n");
                        Slack.enviarMensagem(json);

                        desc = String.format("Memória de armazenamento passou dos limites estipulados, atingindo %d GB, %d por cento do total!",
                                discoUso, mediaRam);

                        conAzure.update("INSERT INTO log_alerta (dh_alerta, titulo, descricao, recurso, checked, fk_totem) " +
                                        "VALUES(?, ?, ?, ?, ?, ?) ",
                                LocalDateTime.now(), "MEMÓRIA DE ARMAZENAMENTO ACIMA DO RECOMENDADO", desc, "Memória de Armazenamento", 0, fkTotemAzure);
                    }
                    if (cpuUso > parameter.getUsoCpu()) {
                        json.put("text", ""
                            + ":fire: *ALERTA - CPU* :fire:\n\n"
                            + "CPU COM USO ACIMA DO RECOMENDADO\n");
                        Slack.enviarMensagem(json);

                        desc = String.format("Uso da CPU passou dos limites estipulados, %.2f por cento do total!",
                                cpuUso);

                        conAzure.update("INSERT INTO log_alerta (dh_alerta, titulo, descricao, recurso, checked, fk_totem) " +
                                        "VALUES(?, ?, ?, ?, ?, ?) ",
                                LocalDateTime.now(), "USO DA CPU ACIMA DO RECOMENDADO", desc, "CPU", 0, fkTotemAzure);
                    }

                }

                System.out.println("Inserindo na Azure");
                // Insert para Azure
                conAzure.update("INSERT INTO registro(uso_disco, disponivel_disco, uso_cpu, disponivel_ram, uso_ram,fk_totem, dh_registro, temperatura_cpu)"
                        + " VALUES(?, ?, ?, ?, ?, ?, ?, ?) ",
                        discoUso, discoDisp, processador.getUso(), memDisp, memUso, fkTotemAzure, LocalDateTime.now(), temperatura.getTemperatura());


            }
        }
    }
}
