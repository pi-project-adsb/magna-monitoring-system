package api.entity;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;

public class Memory {
    public void showMemory() {
        Memoria memoria = new Memoria();

        System.out.println("-".repeat(30));
        System.out.println(memoria);
        System.out.println("-".repeat(30));
    }
}
