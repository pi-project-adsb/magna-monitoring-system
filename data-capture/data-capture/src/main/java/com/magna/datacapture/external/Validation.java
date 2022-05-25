package com.magna.datacapture.external;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.magna.datacapture.api.entity.Network;
import com.magna.datacapture.database.Connection;
import com.magna.datacapture.database.Database;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.magna.datacapture.repository.EmpresaRepository;

import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Validation {

    Connection configMysql = new Connection("mysql");
    JdbcTemplate conMysql = new JdbcTemplate(configMysql.getDatasource());

    Connection configAzure = new Connection("azure");
    JdbcTemplate conAzure = new JdbcTemplate(configAzure.getDatasource());

    Scanner leitor = new Scanner(System.in);
    String testString;
    String emailaddress;
    String userPass;
    Integer fkEmpresa;
    List<EmpresaRepository> userAdvancedUse;

    public void inputEmail() {
        boolean b = false;

        do {
            System.out.println("\nMAGNA MONITORING SYSTEM\n");
            System.out.println("Seja bem vindo, para prosseguir, vamos realizar o seu login.\n");
            System.out.println("Digite um email conforme o formato padrão. Ex: email@dominio.com");
            emailaddress = leitor.nextLine();

            String email_regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
            testString = emailaddress;
            b = testString.matches(email_regex);

        } while (!b);
    }

    public void inputPass() {
        System.out.println("Digite sua senha: ");
        userPass = leitor.nextLine();

        System.out.println("\nCarregando...");

        userAdvancedUse = conAzure.query("SELECT * FROM empresa WHERE email = ? AND senha = ?",
                new BeanPropertyRowMapper<>(EmpresaRepository.class), emailaddress, userPass);

        if (userAdvancedUse.isEmpty()) {
            System.out.println("\nUsuário não encontrado.\n");
        }
    }

    public void sendValidation() {
        boolean a = false;

        do {
            inputEmail();
            inputPass();

            if (!userAdvancedUse.isEmpty()) {
                a = true;
            }
        } while (!a);
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void saveTotem() throws UnknownHostException, SocketException, SQLException, ClassNotFoundException {
        Network network = new Network();
        Looca looca = new Looca();
        DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();
        Processador processador = new Processador();
        Memoria memoria = new Memoria();
        Double frequencia = processador.getFrequencia() * 0.000000001;

        String osName = System.getProperty("os.name");
        InetAddress addr = InetAddress.getLocalHost();

        System.out.println(testString);

        Database database = new Database();

        Integer fkEmpresaAzure = database.getFkEmpresa(emailaddress, "azure");
        Integer fkEmpresaMysql = database.getFkEmpresa(emailaddress, "mysql");

        System.out.println("Inserindo na Azure");
        conAzure.update(
                "INSERT INTO totem (hostname, localizacao, totem_status, endereco_mac,sistema_op, "
                + "total_disco, modelo_cpu, frequencia_cpu, nucleos_cpu, threads_cpu, total_ram, fk_empresa) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                InetAddress.getLocalHost().getHostName(), null, null, network.getMAC(addr), osName,
                grupoDeDiscos.getTamanhoTotal() / 1024 / 1024 / 1024, processador.getNome(), frequencia, processador.getNumeroCpusFisicas(),
                processador.getNumeroCpusLogicas(), memoria.getTotal() / 1024 / 1024, fkEmpresaAzure);

        System.out.println("Inserindo no MySQL");
        conMysql.update(
                "INSERT INTO totem (hostname, localizacao, totem_status, endereco_mac,sistema_op, "
                + "total_disco, modelo_cpu, frequencia_cpu, nucleos_cpu, threads_cpu, total_ram, fk_empresa) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                InetAddress.getLocalHost().getHostName(), null, null, network.getMAC(addr), osName,
                grupoDeDiscos.getTamanhoTotal() / 1024 / 1024 / 1024, processador.getNome(), frequencia, processador.getNumeroCpusFisicas(),
                processador.getNumeroCpusLogicas(), memoria.getTotal() / 1024 / 1024, fkEmpresaMysql);

    }

}
