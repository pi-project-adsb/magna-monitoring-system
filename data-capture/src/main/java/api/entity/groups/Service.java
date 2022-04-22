package api.entity.groups;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.servicos.Servico;
import com.github.britooo.looca.api.group.servicos.ServicosGroup;

import java.util.List;

public class Service {
    public void listServices() {

        Looca looca = new Looca();
        ServicosGroup servicosGroup = looca.getGrupoDeServicos();

        List<Servico> servicos = servicosGroup.getServicos();

        for (Servico servico : servicos) {
            System.out.println(servico);
        }

        System.out.println("-".repeat(30));
    }
}
