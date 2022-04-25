package com.magna.swing.java.api;

import com.magna.swing.java.database.connection.Connection;
import com.magna.swing.java.external.Network;
import org.springframework.jdbc.core.JdbcTemplate;

import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Totem {

    public void saveTotem() throws UnknownHostException, SocketException {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDataSource());
        Network network = new Network();
        String osName = System.getProperty("os.name");
        InetAddress addr = InetAddress.getLocalHost();

        con.update("INSERT INTO totem (hostname, localizacao, totem_status, sistema_operacional, fk_empresa, endereco_mac) VALUES (?, ?, ?, ?, ?, ?)",
                InetAddress.getLocalHost().getHostName(), null, null, osName, 1, network.getMAC(addr));
    }
}
