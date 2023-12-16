package pokemonBattle;

import java.io.*;
import java.net.*;

import javax.swing.*;

import game.GameLogic;
import game.Player;
import pokemon.Charizard;
import pokemon.Pikachu;
import pokemon.Pokemon;

import java.awt.EventQueue;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class Client {
    private JFrame loginFrame;
    private Waitroom waitroom;
    private PrintWriter out;
    private BufferedReader in;
    private String thisPlayerID;

    public Client() {
        loginFrame = new Login("Login", this::createChatScreen);
    }

    private void createChatScreen() {
        Point location = loginFrame.getLocation();
        loginFrame.setVisible(false);

        waitroom = new Waitroom("����", this);
        waitroom.setLocation(location);
        waitroom.getSendButton().addActionListener(e -> sendMessage());
        String username = JOptionPane.showInputDialog("���� �̸��� �Է��ϼ���:");

        startClient(username);
    }

    private void startClient(String username) {
        try {
            Socket socket = new Socket("localhost", 9999);
            waitroom.appendText(username + "���ӿ� �����Ͽ����ϴ�..\n\n");

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
                }
                    return null;
                }

                @Override
                protected void process(List<String> chunks) {
                    for (String message : chunks) {
                        waitroom.appendText("����: " + message + "\n");
                        processServerMessage(message);
                    }
                }
            };
            worker.execute();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
    public void sendReadyStatus() {
    	out.println("READY:" + thisPlayerID); //������ �غ� ����
    }
    
    public void processServerMessage(String message) {
        System.out.println("Received message: " + message); // �α� ���

        if (message.equals("GAME_START")) {
            // ���� ���� ó��
            EventQueue.invokeLater(() -> {
                Selectroom selectRoom = new Selectroom();
                selectRoom.setVisible(true);
                waitroom.setVisible(false);
            });
        } else {
            // �ٸ� �޽��� ó��
            //appendText("����: " + message + "\n");
        }
    }
    
    private void sendMessage() {
        String message = waitroom.getInputBox().getText();
        if (!message.isEmpty()) {
            waitroom.appendText("��: " + message + "\n");
            out.println(message);
            waitroom.getInputBox().setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Client::new);
        Pokemon poke2 = new Pikachu();
		Pokemon poke = new Charizard();
		
		Player player1 = new Player(poke);
		Player player2 = new Player(poke2);
		
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