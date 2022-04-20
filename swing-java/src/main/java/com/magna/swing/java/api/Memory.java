package com.magna.swing.java.api;

import com.github.britooo.looca.api.group.memoria.Memoria;
import com.magna.swing.java.database.connection.Connection;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.springframework.jdbc.core.JdbcTemplate;

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

        Integer fkTotem = con.queryForObject("SELECT id FROM totem WHERE hostname = " +
                "'" + InetAddress.getLocalHost().getHostName() + "' LIMIT 1", Integer.class);

        con.update("INSERT INTO ram VALUES(null, ?, ?, ?, ?)",
        memoria.getEmUso() / toMb / toMb, memoria.getDisponivel() / toMb / toMb, memoria.getTotal() / toMb / toMb, fkTotem);
    }
}
