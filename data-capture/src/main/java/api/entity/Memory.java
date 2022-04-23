package api.entity;

import com.github.britooo.looca.api.group.memoria.Memoria;
import database.Connection;
import org.springframework.jdbc.core.JdbcTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Memory {
    Connection config = new Connection();
    JdbcTemplate con = new JdbcTemplate(config.getDatasource());
    Memoria memoria = new Memoria();

    public void showMemory() {
        System.out.println("-".repeat(30));
        System.out.println(memoria.getEmUso() / 1024 / 1024);
        System.out.println("-".repeat(30));
    }

    public void saveMemory() throws InterruptedException, UnknownHostException {
        Thread.sleep(1000);

        Integer toMb = 1024;

        Integer fkTotem = con.queryForObject("SELECT TOP 1 id FROM totem WHERE hostname = " +
                "'" + InetAddress.getLocalHost().getHostName() + "' ORDER BY id DESC", Integer.class);

        con.update("INSERT INTO ram(uso, disponivel, total, fk_totem) VALUES(?, ?, ?, ?) ",
                memoria.getEmUso() / toMb / toMb, memoria.getDisponivel() / toMb / toMb, memoria.getTotal() / toMb / toMb, fkTotem);
    }
}