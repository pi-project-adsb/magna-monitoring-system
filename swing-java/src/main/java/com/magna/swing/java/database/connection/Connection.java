package com.magna.swing.java.database.connection;

import org.apache.commons.dbcp2.BasicDataSource;

public class Connection {

    private BasicDataSource datasource;

    public Connection(String local) {
        this.datasource = new BasicDataSource();

        if (local.equals("mysql")) {
            datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            datasource.setUrl("jdbc:mysql://127.0.0.1:3308/bd_magna");
            datasource.setUsername("root");
            datasource.setPassword("urubu100");

        } else if (local.equals("azure")) {
            datasource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            datasource.setUrl("jdbc:sqlserver://magna-monitoring-system.database.windows.net:1433;database=bd-magna;user=admin-magna@magna-monitoring-system;password=2ads#grupo6;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
        }

    }

    public BasicDataSource getDatasource() {
        return datasource;
    }
}
