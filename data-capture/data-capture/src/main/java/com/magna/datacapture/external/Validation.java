package com.magna.datacapture.external;

import com.magna.datacapture.database.Connection;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.magna.datacapture.repository.EmpresaRepository;

import java.util.List;
import java.util.Scanner;

public class Validation {
    Connection config = new Connection();
    JdbcTemplate con = new JdbcTemplate(config.getDatasource());
    Scanner leitor = new Scanner(System.in);
    String testString;
    String emailaddress;
    String userPass;
    List<EmpresaRepository> userAdvancedUse;

    public void inputEmail(){
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

    public void inputPass(){
        System.out.println("Digite sua senha: ");
        userPass = leitor.nextLine();

        System.out.println("\nCarregando...");

        userAdvancedUse = con.query("SELECT * FROM empresa WHERE email = ? AND senha = ?",
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
}