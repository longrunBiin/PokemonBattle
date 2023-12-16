package pokemonBattle;

import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.SwingWorker;

public class Server {
    private static List<ClientHandler> clients = new ArrayList<>();
    private static int clientIDCounter = 0; // ���� ID ī����

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("���� ���� ��...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Ŭ���̾�Ʈ ���ӵ�");

                String clientID = "Client" + (++clientIDCounter); // ���� ID ����
                ClientHandler client = new ClientHandler(clientSocket, clientID);
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
        private String clientID; // Ŭ���̾�Ʈ ���� ID
        private boolean isReady = false; //�غ� ���� ����

        public ClientHandler(Socket socket, String clientID) {
        	this.clientID = clientID;
            try {
                this.clientSocket = socket;
                reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                writer = new PrintWriter(clientSocket.getOutputStream(), true);
                
                writer.println("ID:" + clientID); // Ŭ���̾�Ʈ�� ID ����
                              
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
                    
                    if (message.startsWith("READY:")) {
                        String clientId = message.split(":")[1];
                        if (clientId.equals(this.clientID)) {
                            isReady = !isReady;
                            checkAllReady();
                        }
                      
                    sendToAll(message);
                    }}
                } catch (IOException e) {
                    System.out.println("Ŭ���̾�Ʈ [" + clientName + "] ������ ���������ϴ�.");
                    e.printStackTrace();
                    
                }
            
        }
        
        private void checkAllReady() {
            // ��� Ŭ���̾�Ʈ�� �غ�Ǿ����� Ȯ���ϴ� ����
            boolean allReady = clients.stream().allMatch(client -> client.isReady);
            if (allReady) {
                // ��� Ŭ���̾�Ʈ���� ���� ���� �޽��� ������
                for (ClientHandler client : clients) {
                    client.sendMessage("GAME_START");
                }             
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

