package pokemonBattle;

import java.io.*;
import java.net.*;

import javax.swing.*;

import game.GameLogic;
import game.Player;
import pokemon.Charizard;
import pokemon.Pikachu;
import pokemon.Pokemon;

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

    public Client() {
        loginFrame = new Login("Login", this::createChatScreen);
    }

    private void createChatScreen() {
        Point location = loginFrame.getLocation();
        loginFrame.setVisible(false);

        waitroom = new Waitroom("���� (User1)");
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

            SwingWorker<Void, String> worker = new SwingWorker<>() {
                @Override
                protected Void doInBackground() throws Exception {
                    String message;
                    while ((message = in.readLine()) != null) {
                        publish(message);
                    }
                    return null;
                }

                @Override
                protected void process(List<String> chunks) {
                    for (String message : chunks) {
                        waitroom.appendText("����: " + message + "\n");
                    }
                }
            };
            worker.execute();

        } catch (IOException e) {
            e.printStackTrace();
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
//        SwingUtilities.invokeLater(Client::new);
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
		
		GameLogic logic = new GameLogic(poke, poke2);
		
		System.out.println(logic.calculateDamage(poke, poke2));
    }
}