package br.com.bandtec.java.logger;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class App {
    public static void main(String[] args) throws IOException {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    Logger.criarLogger();
                    Logger.escreverLogger();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }, 0, 5000);

       Logger.importData()
    }
}
