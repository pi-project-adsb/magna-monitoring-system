package api.entity;

import com.github.britooo.looca.api.group.temperatura.Temperatura;

public class Temperature {
    public void showTemperature() {
        Temperatura temperatura = new Temperatura();

        System.out.println(temperatura);
        System.out.println("-".repeat(30));
    }
}
