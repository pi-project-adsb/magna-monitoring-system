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

        con.update("INSERT INTO ram VALUES(null, ?, ?, ?, ?)",
        memoria.getEmUso() / toMb / toMb, memoria.getDisponivel() / toMb / toMb, memoria.getTotal() / toMb / toMb, null);

        con.update("UPDATE ram " +
                "SET fk_totem = select totem.id from totem where totem.hostname = 'VMNOTE-398' " +
                "WHERE id = SELECT id FROM ram ORDER BY id DESC LIMIT 1");
    }
}
