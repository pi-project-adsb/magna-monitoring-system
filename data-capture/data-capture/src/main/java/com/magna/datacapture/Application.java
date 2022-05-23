package com.magna.datacapture;

import com.magna.datacapture.api.entity.Network;
import com.magna.datacapture.api.entity.Record;
import com.magna.datacapture.api.entity.groups.Process;
import com.magna.datacapture.database.Connection;
import com.magna.datacapture.external.Validation;
import com.magna.datacapture.repository.TotemRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;

public class Application {
    public static void main(String[] args) throws InterruptedException, IOException, RuntimeException {

        Process process = new Process();
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());
        Network network = new Network();
        Record record =  new Record();
        InetAddress addr = InetAddress.getLocalHost();
        Validation validation = new Validation();

        validation.sendValidation();


        List<TotemRepository> macAdvancedUse = con.query("SELECT endereco_mac FROM totem WHERE endereco_mac = ?",
                new BeanPropertyRowMapper<>(TotemRepository.class), network.getMAC(addr));

        if (macAdvancedUse.isEmpty()) {
            validation.saveTotem();
        }

        System.out.println("\nSeu sistema está rodando!\n");

        while (true) {
            record.saveRecord();
            process.saveProcess();
        }
    }
}


