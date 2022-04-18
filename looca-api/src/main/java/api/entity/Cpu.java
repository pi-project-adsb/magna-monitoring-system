package api.entity;

import com.github.britooo.looca.api.group.processador.Processador;

public class Cpu {
    public void showCpu() {
        Processador processador = new Processador();

        System.out.println(processador);
        System.out.println("-".repeat(30));

    }
}
