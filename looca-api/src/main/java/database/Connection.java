package database;

import org.apache.commons.dbcp2.BasicDataSource;

public class Connection {

    private BasicDataSource datasource;

    public Connection() {
        this.datasource = new BasicDataSource();
        this.datasource.setDriverClassName("org.h2.Driver");
        this.datasource.setUrl("jdbc:h2:file:./meu_banco");
        this.datasource.setUsername("sa");
        this.datasource.setPassword("");
    }

    public BasicDataSource getDatasource() {
        return datasource;
    }
}
