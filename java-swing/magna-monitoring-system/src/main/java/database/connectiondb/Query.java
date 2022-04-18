package database.connectiondb;

import database.table.Totem;
import external.Network;

import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class Query {
    public static void main(String[] args) throws UnknownHostException, SocketException {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDataSource());
        
        Network net = new Network();

        con.execute("DROP TABLE IF EXISTS totem");

        String queryNetwork = "CREATE TABLE totem(" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "localizacao VARCHAR(45)," +
                "status VARCHAR(45)," +
                "sistema VARCHAR(45)," +
                "localhost VARCHAR(255)," +
                "mac_address VARCHAR(255)" +
                ")";

        con.execute(queryNetwork);

        InetAddress addr = InetAddress.getLocalHost();

        con.update(
                "INSERT INTO totem VALUES(null, ?, ?, ?, ?, ?)",
            "Segundo andar", "Rodando", System.getProperty("os.name"), net.getLocalHost(), net.getMac(addr));

        
//        List networkList = con.queryForList("SELECT * FROM totem WHERE mac = ?", net.getMAC());
        
//        System.out.println(networkList);
        
        List<Totem> networkAdvancedUse = con.query("SELECT * FROM totem", new BeanPropertyRowMapper<>(Totem.class));

        List<Totem> onlyMac = con.query("SELECT * FROM totem WHERE mac_address = ?",
                new BeanPropertyRowMapper(Totem.class), net.getMac(addr));

        for (Totem totem : onlyMac) {
            System.out.println(totem);
        }

//        System.out.println(networkAdvancedUse);

//        List pokemonSimpleUse = con.queryForList("SELECT * FROM totem WHERE mac = ?");

//        System.out.println(pokemonSimpleUse);

//        List<Totem> onlyMac = con.query("SELECT * FROM totem WHERE mac = ?",
//                new BeanPropertyRowMapper(Totem.class), net.getMAC());

//        System.out.println(onlyMac);
    }
}
