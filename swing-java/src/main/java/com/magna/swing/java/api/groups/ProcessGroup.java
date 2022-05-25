package com.magna.swing.java.api.groups;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import com.magna.swing.java.database.connection.Connection;
import com.magna.swing.java.database.connection.Database;
import org.springframework.jdbc.core.JdbcTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.List;

public class ProcessGroup {
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

    public void saveProcess() throws InterruptedException, UnknownHostException, SQLException, ClassNotFoundException {
        Looca looca = new Looca();
        ProcessosGroup processosGroup = looca.getGrupoDeProcessos();
        List<Processo> processos = processosGroup.getProcessos();

        System.out.println("Coletando dados dos processos...");
        for (Processo processo : processos) {

            Database database = new Database();

            Integer fkTotem = database.getFkTotem(InetAddress.getLocalHost().getHostName(), "azure");
            Integer fkTotemMySql = database.getFkTotem(InetAddress.getLocalHost().getHostName(), "mysql");

            conAzure.update("INSERT INTO processo(pid, nome, consumo_cpu, consumo_ram, fk_totem) VALUES(?, ?, ?, ?, ?) ",
                    processo.getPid(), processo.getNome(), processo.getUsoCpu() / 1024 / 1024, processo.getUsoMemoria() / 1024 / 1024, fkTotem);

            conMysql.update("INSERT INTO processo(pid, nome, consumo_cpu, consumo_ram, fk_totem) VALUES(?, ?, ?, ?, ?) ",
                    processo.getPid(), processo.getNome(), "processo.getUsoCpu()", processo.getUsoMemoria() / 1024 / 1024, fkTotemMySql);
            
        }
        System.out.println("Quantidade de processos: " + processosGroup.getTotalProcessos());
    }

}