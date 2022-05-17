package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    static final int PORT = 23420;
    private ArrayList<ClientThread> clients = new ArrayList<>();
    Logger logger = Logger.getInstance();

    public Server() {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;

        try {
            serverSocket = new ServerSocket(PORT);
            logger.log("Чат запущен!");
            while (true) {
                clientSocket = serverSocket.accept();
                ClientThread client = new ClientThread(clientSocket, this);
                clients.add(client);
                new Thread(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
                logger.log("Сервер остановлен");
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMsgToAll(String msg) {
        for (ClientThread cl : clients) {
            cl.sendMessage(msg);
        }
    }

    public void removeClient(ClientThread client) {
        clients.remove(client);
    }
}