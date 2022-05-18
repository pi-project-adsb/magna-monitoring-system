package com.magna.datacapture.api.entity;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.magna.datacapture.database.Connection;
import org.springframework.jdbc.core.JdbcTemplate;

import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;

public class Totem {

    public void saveTotem() throws UnknownHostException {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());
        Network network = new Network();
        Looca looca = new Looca();
        List<Volume> volumeGroup = looca.getGrupoDeDiscos().getVolumes();
        DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();
        List<Disco> discos = grupoDeDiscos.getDiscos();
        Processador processador = new Processador();
        Memoria memoria = new Memoria();
        Double frequencia = processador.getFrequencia() * 0.000000001;

        String osName = System.getProperty("os.name");
        InetAddress addr = InetAddress.getLocalHost();

        try {
            for (Disco disco : discos) {
                for (Volume volume : volumeGroup) {
                    con.update(
                            "INSERT INTO totem (hostname, localizacao, totem_status, endereco_mac,sistema_op, " +
                            "modelo_disco, total_disco, modelo_cpu, frequencia_cpu, nucleos_cpu, threads_cpu" +
                            "total_ram, fk_empresa) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                            InetAddress.getLocalHost().getHostName(), null, null, network.getMAC(addr), osName, disco.getModelo(),
                            volume.getTotal() / 1024 / 1024 / 1024, processador.getNome(), frequencia, processador.getNumeroCpusFisicas(),
                            processador.getNumeroCpusLogicas(), memoria.getTotal(), 1);
                }
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }
}
