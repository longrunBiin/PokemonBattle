package pokemonBattle;

import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.SwingWorker;

import game.GameLogic;
import game.Player;

public class Server {
    private static List<ClientHandler> clients = new ArrayList<>();
    private static int clientIDCounter = 0; // 고유 ID 카운터
    private static String pokemon1;
    private static String pokemon2;

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
        
        
        private List<Player> players = new ArrayList<>();
        
        public ClientHandler(Socket socket, String clientID) {
        	this.clientID = clientID;
            try {
                this.clientSocket = socket;
                
                reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                writer = new PrintWriter(clientSocket.getOutputStream(), true);
                
                

                
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
                    
                    
                    int playerIndex = message.indexOf("POKEMON:");
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
                    	String playerPokemon = message.substring(playerIndex).split(":")[1];
                        String clientId = message.split(":")[1].split("P")[0];

                        System.out.println("clientId = " + clientId + " playerId = " + playerPokemon);
                        if(clientId.equals("Client1"))
                        	pokemon1 = playerPokemon;
                        else
                        	pokemon2 = playerPokemon;
                        System.out.println("pokemon1 = " + pokemon1 + " pokemon2 = " + pokemon2);
                        
                        if(pokemon1 != null && pokemon2 != null)
                        	sendEnemyPokemon(message);
                        	
                    }
//                    
//                    
                  }
                } 
            	catch (IOException e) {
                    System.out.println("클라이언트 [" + clientName + "] 연결이 끊어졌습니다.");
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
        
        private void sendEnemyPokemon(String message) {
            	clients.get(0).sendMessage("ENEMY :"+ pokemon2);
            	clients.get(1).sendMessage("ENEMY :"+ pokemon1);
          
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
        public GameLogic getGameLogic() {
        	String clientId = clientID.split("t")[1];
        	int id = Integer.parseInt(clientId);
        	int id2;
        	if(id==1) id2=2;
        	else id2=1;
        	
        	GameLogic gameLogic = new GameLogic(players.get(id).getPokemon(), players.get(id2).getPokemon());
        	return gameLogic;
        }   
    }
}

