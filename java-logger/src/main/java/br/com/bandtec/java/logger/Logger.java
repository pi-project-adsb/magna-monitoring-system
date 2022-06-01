package br.com.bandtec.java.logger;

import br.com.bandtec.java.database.Connection;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author vinic
 */
public class Logger {

    Connection configAzure = new Connection("azure");
    JdbcTemplate conAzure = new JdbcTemplate(configAzure.getDatasource());

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

    public void importData(Connection con, String filename) {

        try {
            System.out.println("Inserindo na Azure");
            // Insert para Azure
            conAzure.update("LOAD DATA INFILE ? INTO TABLE testtable (text,price);",
                    filename);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void criarJson() throws FileNotFoundException, UnsupportedEncodingException {
//        String caminho = null;
//        if (System.getProperty("os.name").startsWith("Windows")) {
//            caminho = String.format("%s\\AppData", System.getProperty("user.home"));
//        } else if (System.getProperty("os.name").startsWith("Linux")) {
//            caminho = String.format("~/.config");
//        }
//        JSONObject json = new org.json.JSONObject();
//        json.put();
//
//        File magna = new File(caminho);
//        if (!magna.exists());
//        {
//            magna.mkdirs();
//        }
//        PrintWriter writer = new PrintWriter(caminho + "\\data.json", "UTF-8");
//        writer.println(json);
//        writer.close();
//    }
    public static void escreverLogger() throws IOException {
        Processador processador = new Processador();
        Looca looca = new Looca();
        Memoria memoria = new Memoria();
        DiscosGroup discosGroup = new DiscosGroup();

        String caminhoPasta = String.format("%s\\magna-loggers\\", System.getProperty("user.home"));

        if (caminho >= 1) {
            try {
                FileWriter caminhoTxt = new FileWriter(caminhoPasta + timeStamp + ".txt", true);
                BufferedWriter loopEscrever = new BufferedWriter(caminhoTxt);
                PrintWriter escreverTexto = new PrintWriter(loopEscrever);

                escreverTexto.printf((looca.getSistema() + "\n"));

                LocalDateTime agora = LocalDateTime.now();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/y h:m:s");

                String agoraFormatado = agora.format(formatter);

                for (int i = 0; i < 10; i++) {
                    if (memoria.getEmUso() > 5000) {
                        escreverTexto.printf(agoraFormatado + " highMemory: " + memoria.getTotal() / 1024 / 1024 + ", " + memoria.getEmUso() / 1024 / 1024 + ", " + memoria.getDisponivel() / 1024 / 1024 + "\n");
                    }

                    if (processador.getUso() > 20) {
                        escreverTexto.printf(agoraFormatado + " highCpu: " + processador.getNome() + processador.getFrequencia() / 1024 / 1024 + processador.getUso() + "\n");
                    }

                    escreverTexto.printf(agoraFormatado + " memory: " + memoria.getTotal() / 1024 / 1024 + ", " + memoria.getEmUso() / 1024 / 1024 + ", " + memoria.getDisponivel() / 1024 / 1024 + "\n");
                    escreverTexto.printf(agoraFormatado + " cpu: " + processador.getNome() + processador.getFrequencia() / 1024 / 1024 + processador.getUso() + "\n");
                    escreverTexto.printf(agoraFormatado + " disk: " + discosGroup.getTamanhoTotal() + "\n");
                }

                loopEscrever.close();

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
