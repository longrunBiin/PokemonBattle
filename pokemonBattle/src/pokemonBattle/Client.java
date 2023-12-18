package pokemonBattle;

import java.io.*;
import java.net.*;

import javax.swing.*;

import game.GameLogic;
import game.Player;
import pokemon.Charmander;
import pokemon.Pikachu;
import pokemon.Pokemon;

import java.awt.EventQueue;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private JFrame loginFrame;
    private Waitroom waitroom;
    private PrintWriter out;
    private BufferedReader in;
    private String thisPlayerID;
    
    OutputStream os;
	InputStream is;
	ObjectOutputStream oos;
	ObjectInputStream ois;
    
    Selectroom selectRoom;
    PokemonBattleGUI battleRoom;
    
    String myPokemon, yourPokemon;
    private Player player;
    
    public Client() {
        loginFrame = new Login("Login", this::createChatScreen);
    }

    private void createChatScreen() {
        Point location = loginFrame.getLocation();
        loginFrame.setVisible(false);

        waitroom = new Waitroom("대기실", this);
        waitroom.setLocation(location);
        waitroom.getSendButton().addActionListener(e -> sendMessage());
        String username = JOptionPane.showInputDialog("유저 이름을 입력하세요:");

        startClient(username);
    }

    private void startClient(String username) {
        try {
            Socket socket = new Socket("localhost", 9999);
            waitroom.appendText(username + "게임에 접속하였습니다..\n\n");

            out = new PrintWriter(socket.getOutputStream(), true);
            out.println(username);
            
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           

            SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
                @Override
                protected Void doInBackground() throws Exception {
                    String message;
                    while ((message = in.readLine()) != null) {
                        if (message.startsWith("ID:")) {
                            thisPlayerID = message.substring(3);
                        }
                        publish(message);
                        processServerMessage(message);
                        
                }
                    return null;
                }

                @Override
                protected void process(List<String> chunks) {
                    for (String message : chunks) {
                        waitroom.appendText("상대방: " + message + "\n");
                    }
                }
            };
            worker.execute();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
    public void sendReadyStatus() {
    	out.println("READY:" + thisPlayerID); //서버에 준비 전송
    }
    public void sendBattleReadyStatus() {
    	out.println("BATTLE:" + thisPlayerID); //배틀 준비 완료 시 전송 
    }
    public void sendPlayerReady() throws IOException {
    	 Player player = selectRoom.getPlayer();
		    if (player != null) {
		    	String mypokemon = player.getPokemon().getName();
		    	
		    	out.println("PLAYER:" + thisPlayerID + "POKEMON:" + mypokemon); //플레이어 준비 완료 시 전송
				  
   	 }
		    else {
		    	 System.out.println("No Player");
		    	
		    }
    }
    
    
    private void sendMessage() {
        String message = waitroom.getInputBox().getText();
        if (!message.isEmpty()) {
            waitroom.appendText("나: " + message + "\n");
            out.println(message);
            waitroom.getInputBox().setText("");
        }
    }
    
    public void processServerMessage(String message) throws ClassNotFoundException, IOException {
    	if (message.equals("GAME_START")) {
            EventQueue.invokeLater(() -> {
                selectRoom = new Selectroom(this);
                selectRoom.setVisible(true);
                waitroom.setVisible(false);
            });
    	}
    	else if(message.equals("BATTLE_START")) {
        	EventQueue.invokeLater(() -> {
        		PokemonBattleGUI battleRoom = new PokemonBattleGUI(this, selectRoom.getPlayer());
                battleRoom.setVisible(true);
                selectRoom.setVisible(false);
               
                System.out.println("배틀룸 연결 ");
            	});
    	}else if (message.equals("PLAYER_MATCH")) {
//             다른 플레이어의 선택한 포켓몬 정보를 수신
            Player player = (Player)ois.readObject();
            out.println("player received " + player.getPokemon().getName());

//             해당 플레이어 정보를 UI에 표시
//            selectRoom.updatePlayerInfo(player);
        }
        
        else {
        	// 다른 메시지 처리
            //appendText("����: " + message + "\n");
        
        }
     }
    
    
    public Selectroom getSelectRoom() {
    	return selectRoom; 
    }
    public void useSkill(String skillName) {
        Player player = getPlayer(); // 현재 플레이어 객체 가져오기
        int damage = player.getPokemon().useSkill(skillName); // 데미지 계산

        sendDamageToServer(damage); // 서버에 데미지 전송
    }
    private void sendDamageToServer(int damage) {
        try {
            out.writeObject("SKILL_DAMAGE:" + damage);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Client::new);
        
		
//		player1.useSkill("1");
//		player2.useSkill("1");
//		
//		poke.useSkill("1");
//		poke2.useSkill("1");
//		poke.useSkill("2");
//		poke2.useSkill("2");
		
		//GameLogic logic = new GameLogic(poke, poke2);
		
		//System.out.println(logic.calculateDamage(poke, poke2));
    }
}
