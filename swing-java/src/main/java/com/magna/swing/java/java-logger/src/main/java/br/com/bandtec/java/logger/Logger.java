package br.com.bandtec.java.logger;

import com.github.britooo.looca.api.core.Looca;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.h2.engine.Session;
import org.h2.util.json.JSONObject;
import org.json.JSONObject;

/**
 *
 * @author vinic
 */
public class Logger {

    static FileOutputStream arquivo;
    static String timeStamp;
    static Integer caminho;

    public static void criarLogger() throws IOException {
        timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        Looca looca = new Looca();
        String caminhoPasta = String.format("%s/magna-loggers", System.getProperty("user.home"));

        if (looca.getSistema().getSistemaOperacional().equals("Linux")
                || looca.getSistema().getSistemaOperacional().equals("Ubuntu")) {
            File magna = new File(caminhoPasta);
            if (!magna.exists()) {
                magna.mkdirs();
            }
            arquivo = new FileOutputStream(caminhoPasta + "/" + timeStamp + ".txt");
            caminho = 1;
        } else if (looca.getSistema().getSistemaOperacional().equals("Windows")) {
            File magna = new File(caminhoPasta);
            if (!magna.exists()) {
                magna.mkdirs();
            }
            arquivo = new FileOutputStream(caminhoPasta + "/" + timeStamp + ".txt");
            caminho = 2;
        }
    }

    public static void criarJson() throws FileNotFoundException, UnsupportedEncodingException {
        String caminho = null;
        if (System.getProperty("os.name").startsWith("Windows")) {
            caminho = String.format("%s\\AppData", System.getProperty("user.home"));
        } else if (System.getProperty("os.name").startsWith("Linux")) {
            caminho = String.format("~/.config");
        }
        JSONObject json = new JSONObject();
        json.put("");

        File magna = new File(caminho);
        if (!magna.exists());
        {
            magna.mkdirs();
        }
        PrintWriter writer = new PrintWriter(caminho + "\\data.json", "UTF-8");
        writer.println(json);
        writer.close();
    }

    public static void escreverLogger(String texto) throws IOException {
        String caminhoPasta = String.format("%s\\magna-loggers\\", System.getProperty("user.home"));

        if (caminho >= 1) {
            try {
                FileWriter caminhoTxt = new FileWriter(caminhoPasta + timeStamp + ".txt", true);
                BufferedWriter loopEscrever = new BufferedWriter(caminhoTxt);
                PrintWriter escreverTexto = new PrintWriter(loopEscrever);
            } catch (IOException e) {
                Logger.loggerException(e);
            }
        } else {
            System.out.println("Sem Sucesso, não temos suporte para esse sistema operacional");
        }
    }

    public static void fecharLogger() throws IOException {
        arquivo.close();
    }

    private static void loggerException(IOException e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static String geradorDatas() {
        String dataFormatada = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss").format(Calendar.getInstance().getTime());
        return dataFormatada;
    }
}
