package server;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ServerSettingsTest {

    @Test
    void settingFileRead()  {
        ServerSettings serverSettings = new ServerSettings();
        String line = "localhost:23420";
        String[] splitLine = line.split(":");

        String[] result = serverSettings.settingFileRead();
        Assertions.assertArrayEquals(result,splitLine);
    }

    @Test
    @DisplayName("Получение хоста")
    void getHost() {
        ServerSettings serverSettings = new ServerSettings();
        String host = "localhost";
        String result = serverSettings.getHost();
        Assertions.assertEquals(result, host);
    }

    @Test
    @DisplayName("Получение порта")
    void getPort() {
        ServerSettings serverSettings = new ServerSettings();
        int port = 23420;
        int result = serverSettings.getPort();
        Assertions.assertEquals(result, port);

    }
}