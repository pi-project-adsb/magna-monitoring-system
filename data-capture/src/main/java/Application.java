import api.entity.*;
import api.entity.groups.Disk;
import api.entity.groups.Process;
import api.entity.groups.Service;
import database.Connection;
import external.EmailValidation;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import repository.MemoryRespository;
import repository.TotemRepository;

import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws InterruptedException, UnknownHostException, SocketException, RuntimeException {
        Disk disk = new Disk();
        Cpu cpu = new Cpu();
        Totem totem = new Totem();
        Memory memory = new Memory();
        SystemInfo systemInfo = new SystemInfo();
        Temperature temperature = new Temperature();
        Process process = new Process();
        Service service = new Service();
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());
        Network network = new Network();
        TotemRepository totemRespository = new TotemRepository();
        InetAddress addr = InetAddress.getLocalHost();
        Scanner leitor1 = new Scanner(System.in);
        EmailValidation emailValidation = new EmailValidation();

        emailValidation.sendValidation();

        List<TotemRepository> macAdvancedUse = con.query("SELECT endereco_mac FROM totem WHERE endereco_mac = ?",
                new BeanPropertyRowMapper<>(TotemRepository.class), new Object[]{network.getMAC(addr)});

        if (macAdvancedUse.isEmpty()) {
            totem.saveTotem();
        }

        System.out.println("Seu sistema está rodando!");

        while (true) {
            memory.saveMemory();

            cpu.saveCpu();
        }
    }
}


