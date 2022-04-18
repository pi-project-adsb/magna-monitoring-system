package api.entity;

import com.github.britooo.looca.api.group.memoria.Memoria;
import database.Connection;
import org.springframework.jdbc.core.JdbcTemplate;

public class Memory {
    Connection config = new Connection();
    JdbcTemplate con = new JdbcTemplate(config.getDatasource());
    Memoria memoria = new Memoria();

    public void showMemory() {
        System.out.println("-".repeat(30));
        System.out.println(memoria.getEmUso() / 1024 / 1024);
        System.out.println("-".repeat(30));
    }

    public void saveMemory() throws InterruptedException {
        Thread.sleep(500);

        Integer toMb = 1024;

        con.update("INSERT INTO ram VALUES(null, ?, ?, ?)",
        memoria.getEmUso() / toMb / toMb, memoria.getDisponivel() / toMb / toMb, memoria.getTotal() / toMb / toMb);
    }
}
