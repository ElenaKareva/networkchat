package server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ServerSettings {

    private static final File SETTING_TXT = new File("settings.txt");
    private  final String[] settings;


    public ServerSettings() {
        this.settings = settingFileRead();
    }

    public String[] settingFileRead () {
        String result = "";
        try (BufferedReader br = new BufferedReader(new FileReader(SETTING_TXT))) {
            String line;
            while ((line = br.readLine()) != null) {
                result = line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.split(":");
    }

    public String getHost() {
        return settings[0];
    }

    public int getPort() {
        return Integer.parseInt(settings[1]);
    }
}
