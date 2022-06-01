package com.magna.datacapture;

import com.magna.datacapture.api.entity.Network;
import com.magna.datacapture.api.entity.Record;
import com.magna.datacapture.api.entity.groups.Process;
import com.magna.datacapture.database.Connection;
import com.magna.datacapture.external.Validation;
import com.magna.datacapture.logger.LoggerFile;
import com.magna.datacapture.repository.TotemRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.net.InetAddress;
import java.sql.SQLException;
import java.util.List;

public class Application {

    public static void main(String[] args) throws InterruptedException, IOException, RuntimeException, SQLException, ClassNotFoundException {
        Process process = new Process();
        
        Connection configAzure = new Connection("azure");
        JdbcTemplate conAzure = new JdbcTemplate(configAzure.getDatasource());
        
        Connection configMysql = new Connection("mysql");
        JdbcTemplate conMysql = new JdbcTemplate(configMysql.getDatasource());
        
        Network network = new Network();
        Record record = new Record();
        InetAddress addr = InetAddress.getLocalHost();
        Validation validation = new Validation();

        validation.sendValidation();

        List<TotemRepository> macAdvancedUseAzure = conAzure.query("SELECT endereco_mac FROM totem WHERE endereco_mac = ?",
                new BeanPropertyRowMapper<>(TotemRepository.class), network.getMAC(addr));

        List<TotemRepository> macAdvancedUseMysql = conMysql.query("SELECT endereco_mac FROM totem WHERE endereco_mac = ?",
                new BeanPropertyRowMapper<>(TotemRepository.class), network.getMAC(addr));

        if (macAdvancedUseAzure.isEmpty() || macAdvancedUseMysql.isEmpty()) {
            validation.saveTotem();
        }

        System.out.println("\nSeu sistema está rodando!\n");

        while (true) {
            record.saveRecord();
            process.saveProcess();
            LoggerFile.criarLogger();
            LoggerFile.escreverLogger();
        }
    }
}
