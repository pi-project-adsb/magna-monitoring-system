package com.magna.datacapture.api.entity;

import com.magna.datacapture.database.Connection;
import org.springframework.jdbc.core.JdbcTemplate;

import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Totem {

    public void saveTotem() throws UnknownHostException {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());
        Network network = new Network();
        String osName = System.getProperty("os.name");
        InetAddress addr = InetAddress.getLocalHost();

        try {
            con.update("INSERT INTO totem (hostname, localizacao, totem_status, sistema_operacional, fk_empresa, endereco_mac) VALUES (?, ?, ?, ?, ?, ?)",
                    InetAddress.getLocalHost().getHostName(), null, null, osName, 1, network.getMAC(addr));
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }
}
