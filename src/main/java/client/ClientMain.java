package client;

import server.ServerSettings;

public class ClientMain {

    public static void main(String[] args) {
        ServerSettings serverSettings = new ServerSettings();
        final String serverHost = serverSettings.getHost();
        final int serverPort = serverSettings.getPort();
        Client client = new Client(serverHost,serverPort);
    }
}
