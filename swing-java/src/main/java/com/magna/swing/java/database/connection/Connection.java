package com.magna.swing.java.database.connection;

import org.apache.commons.dbcp2.BasicDataSource;

public class  Connection {
    private final BasicDataSource dataSource;

    public Connection() {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://magna-monitoring-system.database.windows.net:1433;database=bd-magna;user=admin-magna@magna-monitoring-system;password=2ads#grupo6;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
        dataSource.setPassword("2ads#grupo6");

    }

    public BasicDataSource getDataSource() {
        return dataSource;
    }
}