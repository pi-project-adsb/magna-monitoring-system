package api.entity;

import com.github.britooo.looca.api.group.processador.Processador;
import database.Connection;
import org.springframework.jdbc.core.JdbcTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;

public class Cpu {
    Connection config = new Connection();
    JdbcTemplate con = new JdbcTemplate(config.getDatasource());
    Processador processador = new Processador();
    DecimalFormat formatador = new DecimalFormat("0.00");

    public void showCpu() {
        System.out.println(Math.round(processador.getUso() * 100.0)/100.0);
        System.out.println(processador.getFrequencia() / 10000000);
        System.out.println("-".repeat(30));
    }

    public void saveCpu() throws InterruptedException, UnknownHostException {
        Thread.sleep(1000);

        Double usoProcessador = Math.round(processador.getUso() * 100.0)/100.0;

        Integer fkTotem = con.queryForObject("SELECT TOP 1 id FROM totem WHERE hostname = " +
                "'" + InetAddress.getLocalHost().getHostName() + "' ORDER BY id DESC", Integer.class);

        con.update("INSERT INTO cpu(nome, frequencia, nucleos, threads, uso,fk_totem) VALUES(?, ?, ?, ?, ?, ?) ",
                processador.getNome(), processador.getFrequencia() / 10000000, processador.getNumeroCpusFisicas(),
                processador.getNumeroCpusLogicas(), usoProcessador, fkTotem);
    }
}
