package com.magna.swing.java.api.groups;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import com.magna.swing.java.database.connection.Connection;
import org.springframework.jdbc.core.JdbcTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

public class ProcessGroup {
    Connection config = new Connection();
    JdbcTemplate con = new JdbcTemplate(config.getDataSource());

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

            Integer fkTotem = con.queryForObject("SELECT TOP 1 id FROM totem WHERE hostname = " +
                    "'" + InetAddress.getLocalHost().getHostName() + "' ORDER BY id DESC", Integer.class);

            con.update("INSERT INTO processo(pid, nome, consumo_cpu, consumo_ram, fk_totem) VALUES(?, ?, ?, ?, ?) ",
                    processo.getPid(), processo.getNome(), processo.getUsoCpu(), processo.getUsoMemoria(), fkTotem);
        }
        System.out.println("Quantidade de processos: " + processosGroup.getTotalProcessos());
    }

}