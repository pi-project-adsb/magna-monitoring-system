
package com.magna.datacapture.database;

import com.magna.datacapture.repository.TotemRepository;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author TotemSystem
 */
public class Database {
    
    public String getDriver(String local) {
        
        String driver = "Local inválido";
        
        if (local.equals("mysql")) {
            return driver = "com.mysql.cj.jdbc.Driver";
        } else {
            return driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        }
    }

    public String getURL(String local) {

        String url = "Local inválido";

        if (local.equals("mysql")) {
            return url = "jdbc:mysql://magnaSQL:3306/bd_magna";
            //return url = "jdbc:mysql://mysql-totem:3306/totemsystem";
        } else if (local.equals("azure")) {
            return url = "jdbc:sqlserver://magna-monitoring-system.database.windows.net:1433;database=bd-magna;user=admin-magna@magna-monitoring-system;password=2ads#grupo6;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

        } else {
            return url;
        }
    }

    public String getLogin(String local) {

        String login = "Local inválido";

        if (local.equals("mysql")) {
            return login = "root";
        } else if (local.equals("azure")) {
            return login = "admin-magna";
        } else {
            return login;
        }
    }

    public String getSenha(String local) {

        String senha = "Local inválido";

        if (local.equals("mysql")) {
            return senha = "urubu100";
        } else if (local.equals("azure")) {
            return senha = "2ads#grupo6";
        } else {
            return senha;
        }
    }

    public Integer getFkTotem(String hostname, String local) throws SQLException, ClassNotFoundException {
        
        Class.forName(this.getDriver(local)); /* Aqui registra */
        Connection connection = DriverManager.getConnection(this.getURL(local), this.getLogin(local), this.getSenha(local));

        Integer id = 0;

        PreparedStatement pesquisa = connection.prepareStatement(String.format("select id from totem where hostname = '%s'", hostname));
        ResultSet resultado = pesquisa.executeQuery();

        while (resultado.next()) {
            try {
                id = Integer.valueOf(resultado.getString("id"));
            } catch (Exception e) {
                System.out.println("ID está null");

            }

        }

        return id;

    }
    
        public Integer getFkEmpresa(String empresa, String local) throws SQLException, ClassNotFoundException {
        
        Class.forName(this.getDriver(local)); /* Aqui registra */
        Connection connection = DriverManager.getConnection(this.getURL(local), this.getLogin(local), this.getSenha(local));

        Integer id = 0;

        PreparedStatement pesquisa = connection.prepareStatement(String.format("SELECT id FROM empresa WHERE email = '%s'", empresa));
        ResultSet resultado = pesquisa.executeQuery();

        while (resultado.next()) {
            try {
                id = Integer.valueOf(resultado.getString("id"));
            } catch (Exception e) {
                System.out.println("ID está null");

            }

        }

        return id;

    }

    public Boolean existeEstacao(String nomeEstacao, String local) throws SQLException, ClassNotFoundException {
        Class.forName(this.getDriver(local)); /* Aqui registra */
        Connection conexão = DriverManager.getConnection(this.getURL(local), this.getLogin(local), this.getSenha(local));

        PreparedStatement pesquisa = conexão.prepareStatement(String.format("select nome_estacao from tb_estacao where nome_estacao = '%s'", nomeEstacao));
        ResultSet resultado = pesquisa.executeQuery();

        if (resultado.next()) {
            return true;
        } else {
            return false;
        }

    }

    public Boolean validarLogin(String email, String senha, String local) throws SQLException, ClassNotFoundException {
        
        Class.forName(this.getDriver(local)); /* Aqui registra */
        Connection conexão = DriverManager.getConnection(this.getURL(local), this.getLogin(local), this.getSenha(local));
        PreparedStatement pesquisa = conexão.prepareStatement(String.format("select * from tb_usuario where email = '%s' and  senha = '%s'", email, senha));
        ResultSet resultado = pesquisa.executeQuery();

        if (resultado.next()) {
            return true;
        } else {
            return false;
        }

    }

    public Boolean existeHostname(String local) throws SQLException, ClassNotFoundException {


        TotemRepository totem = new TotemRepository();
        // Class.forName(this.getDriver(local)); /* Aqui registra */
        Connection connection = DriverManager.getConnection(this.getURL(local), this.getLogin(local), this.getSenha(local));
        PreparedStatement pesquisa = connection.prepareStatement(String.format("select hostname from totem where hostname = '%s'", totem.getHostname()));
        ResultSet resultado = pesquisa.executeQuery();

        if (resultado.next()) {
            return true;
        } else {
            return false;
        }
    }
    
        

}