package api.entity.groups;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;

import java.util.List;

public class Process {
    public void listProcess() {
        Looca looca = new Looca();
        ProcessosGroup processosGroup = looca.getGrupoDeProcessos();

        List<Processo> processos = processosGroup.getProcessos();

        for (Processo processo : processos) {
            System.out.println(processo);
        }

        System.out.println("-".repeat(30));
    }
}
