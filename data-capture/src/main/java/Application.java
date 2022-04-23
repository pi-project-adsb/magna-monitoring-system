import api.entity.*;
import api.entity.groups.Disk;
import api.entity.groups.Process;
import database.Connection;
import external.Validation;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import repository.TotemRepository;

import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws InterruptedException, UnknownHostException, SocketException, RuntimeException {
        Disk disk = new Disk();
        Cpu cpu = new Cpu();
        Totem totem = new Totem();
        Memory memory = new Memory();
        Process process = new Process();
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());
        Network network = new Network();
        InetAddress addr = InetAddress.getLocalHost();
        Validation validation = new Validation();

        validation.sendValidation();


        List<TotemRepository> macAdvancedUse = con.query("SELECT endereco_mac FROM totem WHERE endereco_mac = ?",
                new BeanPropertyRowMapper<>(TotemRepository.class), new Object[]{network.getMAC(addr)});

        if (macAdvancedUse.isEmpty()) {
            totem.saveTotem();
        }

        System.out.println("\nSeu sistema está rodando!\n");

        while (true) {
            memory.saveMemory();
            cpu.saveCpu();
            disk.saveDisk();
            process.saveProcess();
        }
    }
}


