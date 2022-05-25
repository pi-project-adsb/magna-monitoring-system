package com.magna.datacapture.api.entity.groups;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import com.magna.datacapture.database.Connection;
import org.springframework.jdbc.core.JdbcTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

public class Process {
    Connection configMysql = new Connection("mysql");
    JdbcTemplate conMysql = new JdbcTemplate(configMysql.getDatasource());

    Connection configAzure = new Connection("azure");
    JdbcTemplate conAzure = new JdbcTemplate(configAzure.getDatasource());

    public void listProcess() {
        Looca looca = new Looca();
        ProcessosGroup processosGroup = looca.getGrupoDeProcessos();
        List<Processo> processos = processosGroup.getProcessos();

        for (Processo processo : processos) {
            System.out.println(processo);
            System.out.println("-".repeat(30));
        }

        System.out.println("-".repeat(30));
    }

    public void saveProcess() throws InterruptedException, UnknownHostException {
        Looca looca = new Looca();
        ProcessosGroup processosGroup = looca.getGrupoDeProcessos();
        List<Processo> processos = processosGroup.getProcessos();

        System.out.println("Coletando dados dos processos...");
        for (Processo processo : processos) {

            Integer fkTotem = conAzure.queryForObject("SELECT TOP 1 id FROM totem WHERE hostname = " +
                    "'" + InetAddress.getLocalHost().getHostName() + "' ORDER BY id DESC", Integer.class);

            conAzure.update("INSERT INTO processo(pid, nome, consumo_cpu, consumo_ram, fk_totem) VALUES(?, ?, ?, ?, ?) ",
                    processo.getPid(), processo.getNome(), processo.getUsoCpu(), processo.getUsoMemoria(), fkTotem);

            conMysql.update("INSERT INTO processo(pid, nome, consumo_cpu, consumo_ram, fk_totem) VALUES(?, ?, ?, ?, ?) ",
                    processo.getPid(), processo.getNome(), processo.getUsoCpu(), processo.getUsoMemoria(), fkTotem);
            
        }
        System.out.println("Quantidade de processos: " + processosGroup.getTotalProcessos());
    }

}