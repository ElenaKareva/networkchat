package server;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Logger {
    File fileLog = new File("/Users/SIREN-A/IdeaProjects/Online_chat_version2", "file.log");
    private static Logger logger = null;

    private Logger() {

    }

    public void log(String msg) {

        System.out.println("[" + LocalDateTime.now().format(DateTimeFormatter
                .ofPattern("dd.MM.yyyy HH:mm")) + "] " + msg);

        try (FileWriter writer = new FileWriter("file.log", true)) {

            writer.write("[" + LocalDateTime.now().format(DateTimeFormatter
                    .ofPattern("dd.MM.yyyy HH:mm")) + "] " + msg + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger getInstance() {
        if (logger == null) logger = new Logger();
        return logger;
    }

}
