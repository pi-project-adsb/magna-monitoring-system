package api.entity;

import com.github.britooo.looca.api.group.sistema.Sistema;

public class SystemInfo {
    public void showSystemInfo() {
        Sistema sistema = new Sistema();

        System.out.println(sistema);
        System.out.println("-".repeat(30));
    }
}
