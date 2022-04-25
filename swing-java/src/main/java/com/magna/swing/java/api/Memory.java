package com.magna.swing.java.api;

import com.github.britooo.looca.api.group.memoria.Memoria;
import com.magna.swing.java.database.connection.Connection;
import org.springframework.jdbc.core.JdbcTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Memory {
    Connection config = new Connection();
    JdbcTemplate con = new JdbcTemplate(config.getDataSource());
    Memoria memoria = new Memoria();

    public void showMemory() {
        System.out.println("-".repeat(30));
        System.out.println(memoria.getEmUso() / 1024 / 1024);
        System.out.println("-".repeat(30));
    }

    public void saveMemory() throws InterruptedException, UnknownHostException {
        Thread.sleep(1000);

        Integer toMb = 1024;

        System.out.println("Coletando dados da memória ram...");

        Integer fkTotem = con.queryForObject("SELECT TOP 1 id FROM totem WHERE hostname = " +
                "'" + InetAddress.getLocalHost().getHostName() + "' ORDER BY id DESC", Integer.class);

        con.update("INSERT INTO ram(uso, disponivel, total, fk_totem) VALUES(?, ?, ?, ?) ",
                memoria.getEmUso() / toMb / toMb, memoria.getDisponivel() / toMb / toMb, memoria.getTotal() / toMb / toMb, fkTotem);

    }
}
