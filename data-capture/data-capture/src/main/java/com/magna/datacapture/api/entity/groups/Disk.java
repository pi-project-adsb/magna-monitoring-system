package com.magna.datacapture.api.entity.groups;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.discos.Volume;
import com.magna.datacapture.database.Connection;
import org.springframework.jdbc.core.JdbcTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

public class Disk {
    Connection config = new Connection();
    JdbcTemplate con = new JdbcTemplate(config.getDatasource());

    public void listDisks() {
        Looca looca = new Looca();
        List<Volume> volumeGroup = looca.getGrupoDeDiscos().getVolumes();

        for (Volume volume : volumeGroup) {
            System.out.println((volume.getTotal() - volume.getDisponivel()) / 1024 / 1024 / 1024);
            System.out.println(volume.getDisponivel() / 1024 / 1024 /1024);
            System.out.println(volume.getTotal() / 1024 / 1024 /1024);
        }

        System.out.println("-".repeat(30));
    }

    public void saveDisk() throws InterruptedException, UnknownHostException {
        Looca looca = new Looca();
        List<Volume> volumeGroup = looca.getGrupoDeDiscos().getVolumes();
        DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();
        List<Disco> discos = grupoDeDiscos.getDiscos();

        System.out.println("Coletando dados dos discos...");

        for (Disco disco : discos) {
            for (Volume volume : volumeGroup) {
                Long memUso = (volume.getTotal() - volume.getDisponivel()) / 1024 / 1024 / 1024;

                Integer fkTotem = con.queryForObject("SELECT TOP 1 id FROM totem WHERE hostname = " +
                        "'" + InetAddress.getLocalHost().getHostName() + "' ORDER BY id DESC", Integer.class);

                con.update("INSERT INTO armazenamento(modelo, uso, disponivel, total,fk_totem) VALUES(?, ?, ?, ?, ?) ",
                        disco.getModelo(), memUso, volume.getDisponivel() / 1024 / 1024 / 1024, volume.getTotal() / 1024 / 1024 / 1024, fkTotem);
            }
        }
    }
}
