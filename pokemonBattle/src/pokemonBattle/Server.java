package pokemonBattle;

import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.SwingWorker;

import game.Player;

public class Server {
    private static List<ClientHandler> clients = new ArrayList<>();
    private static int clientIDCounter = 0; // 고유 ID 카운터

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("서버 실행중...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("클라이언트 접속됨");

                String clientID = "Client" + (++clientIDCounter); // 고유 ID 생성
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
        private String clientID; // 클라이언트 고유 ID
        private boolean isReady = false; //준비 상태 추적
        private boolean battleIsReady = false;
        
        InputStream is;
        OutputStream os;
        ObjectInputStream ois;
        ObjectOutputStream oos;
        
        private List<Player> players = new ArrayList<>();
        
        public ClientHandler(Socket socket, String clientID) {
        	this.clientID = clientID;
            try {
                this.clientSocket = socket;
                reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                writer = new PrintWriter(clientSocket.getOutputStream(), true);
                
                is = clientSocket.getInputStream();
//    			os = socket.getOutputStream();
                
//    			oos = new ObjectOutputStream(os);
                
                writer.println("ID:" + clientID); // 클라이언트에 ID 전송                              
                clientName = reader.readLine();
                System.out.println("클라이언트 [" + clientName + "] 접속됨");
                
               
                
                
                
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
                    
                   
                    System.out.println("클라이언트 [" + clientName + "] 메시지 : " + message);
                    sendToAll(message);
                    
                    
                    if (message.startsWith("READY:")) {
                        String clientId = message.split(":")[1];
                        if (clientId.equals(this.clientID)) {
                            isReady = !isReady;
                            checkAllReady();
                        }
                        sendToAll(message);
                    }
                    else if (message.startsWith("BATTLE:")) {
                        String clientId = message.split(":")[1];
                        if (clientId.equals(this.clientID)) {
                            battleIsReady = !battleIsReady;
                            checkBattleReady();
                        }
                        sendToAll(message);
                    }
                    else if (message.startsWith("PLAYER:")) {
                        String clientId = message.split(":")[1];
                        if (clientId.equals(this.clientID)) {
                        	ois = new ObjectInputStream(is);
                        	Player player = (Player)ois.readObject();
                            players.add(clientIDCounter, player);
                            System.out.println("player received " + clientIDCounter + " " + player.getPokemon().getName());
                            for (ClientHandler client : clients) {
                                client.sendMessage("PLAYER_MATCH");
                            }
                        }
                        sendToAll(message);
                    }
//                    
//                    
                  }
                } 
            	catch (IOException e) {
                    System.out.println("클라이언트 [" + clientName + "] 연결이 끊어졌습니다.");
                    e.printStackTrace();
                    
                } catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            
        }
        
        private void checkAllReady() {
        	// 모든 클라이언트가 준비되었는지 확인하는 로직
        	boolean allReady = clients.stream().allMatch(client -> client.isReady);
            if (allReady) {
            	// 모든 클라이언트에게 게임 시작 메시지 보내기
                for (ClientHandler client : clients) {
                    client.sendMessage("GAME_START");
                }             
            }
        }
        private void checkBattleReady() {
        	// 모든 클라이언트가 준비되었는지 확인하는 로직
            boolean allReady = clients.stream().allMatch(client -> client.battleIsReady);
            if (allReady) {
            	// 모든 클라이언트에게 게임 시작 메시지 보내기
                for (ClientHandler client : clients) {
                    client.sendMessage("BATTLE_START");
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
        
        private void handleClientMessage(Object message) {
            String msg = (String) message;
            if (msg.startsWith("SKILL_DAMAGE:")) {
                int damage = Integer.parseInt(msg.split(":")[1]);
                // 데미지 처리 로직...
            }
            // 기타 메시지 처리...
        } 
        

        private void sendMessage(String message) {
            writer.println(message);
        }
        
    }
}

