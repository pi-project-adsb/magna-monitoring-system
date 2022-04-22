package api.entity;

import com.github.britooo.looca.api.group.sistema.Sistema;
import database.Connection;
import org.springframework.jdbc.core.JdbcTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class SystemInfo {
    Connection config = new Connection();
    JdbcTemplate con = new JdbcTemplate(config.getDatasource());

    public void showSystemInfo() {
        Sistema sistema = new Sistema();

        System.out.println(sistema);
        System.out.println("-".repeat(30));
    }

    public void saveSystemInfo() throws InterruptedException, UnknownHostException {
        Thread.sleep(1000);

        Integer fkTotem = con.queryForObject("SELECT TOP 1 id FROM totem WHERE hostname = " +
                "'" + InetAddress.getLocalHost().getHostName() + "' ORDER BY id DESC", Integer.class);
    }
}
