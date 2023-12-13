package pokemonBattle;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    private static List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("���� ���� ��...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Ŭ���̾�Ʈ ���ӵ�");

                ClientHandler client = new ClientHandler(clientSocket);
                clients.add(client);

                Thread clientThread = new Thread(client);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private BufferedReader reader;
        private PrintWriter writer;
        private String clientName;

        public ClientHandler(Socket socket) {
            try {
                this.clientSocket = socket;
                reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                writer = new PrintWriter(clientSocket.getOutputStream(), true);
                
                
                clientName = reader.readLine();
                System.out.println("Ŭ���̾�Ʈ [" + clientName + "] ���ӵ�");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                while (true) {
                    String message = reader.readLine();
                    if (message == null) {
                        break;
                    }
                    System.out.println("Ŭ���̾�Ʈ [" + clientName + "] �޽��� :" + message);
                    sendToAll(message);
                }
            } catch (IOException e) {
            	System.out.println("Ŭ���̾�Ʈ [" + clientName + "] ������ ���������ϴ�.");
                
                e.printStackTrace();
            }
        }

        private void sendToAll(String message) {
            for (ClientHandler client : clients) {
                if (client != this) {
                    client.sendMessage(message);
                }
            }
        }

        private void sendMessage(String message) {
            writer.println(message);
        }
    }
}

