package api.entity;

import com.github.britooo.looca.api.group.processador.Processador;
import database.Connection;
import org.springframework.jdbc.core.JdbcTemplate;

public class Cpu {
    Connection config = new Connection();
    JdbcTemplate con = new JdbcTemplate(config.getDatasource());
    Processador processador = new Processador();

    public void showCpu() {
        System.out.println("-".repeat(30));
    }

    public void saveCpu() throws InterruptedException {
        Thread.sleep(1000);

        con.update("INSERT INTO cpu VALUES(null, ?, ?, ?, ?, ?)",
                processador.getNome(), processador.getFrequencia(),
                processador.getNumeroCpusFisicas(), processador.getNumeroCpusFisicas(), processador.getUso());
    }
}
