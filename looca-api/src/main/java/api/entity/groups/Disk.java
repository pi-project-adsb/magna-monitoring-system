package api.entity.groups;

import api.entity.SystemInfo;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;

import java.util.List;

public class Disk {
    public void listDisks() {
        Looca looca = new Looca();
        DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();

        List<Disco> discos = grupoDeDiscos.getDiscos();

        for (Disco disco : discos) {
            System.out.println("Modelo: " + disco.getModelo());
            System.out.println("Tamanho: " + disco.getTamanho() / 1000 / 1000 / 1000);
        }

        System.out.println("-".repeat(30));


    }
}
