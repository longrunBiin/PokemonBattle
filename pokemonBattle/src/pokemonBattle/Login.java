package pokemonBattle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Login extends JFrame {
	
    public Login(String title, Runnable onStartChat) {
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        String imagePath = "/image/login.png";
        URL iconURL = getClass().getResource(imagePath);
        if (iconURL == null) {
            // 
            System.err.println("����.: " + imagePath);
            return;
        }
        ImageIcon backgroundIcon = new ImageIcon(iconURL);
        Image image = backgroundIcon.getImage().getScaledInstance(750, 550, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);

        
        JPanel loginPanel = new JPanel(new BorderLayout());
        loginPanel.setOpaque(false);

        
        
        JButton startButton = new JButton("�����ϱ�");
        startButton.setFont(new Font("Arial Black", Font.BOLD, 20));
        startButton.setForeground(Color.WHITE);
        startButton.setBackground(Color.RED);
        startButton.setFocusPainted(false);
        startButton.addActionListener(e -> onStartChat.run());
        
        startButton.setFont(new Font("����", Font.BOLD, 20));
        startButton.setFocusPainted(false);

        
        JLabel backgroundLabel = new JLabel(scaledIcon);

        
        JPanel panel = new JPanel(new BorderLayout());
        
        panel.add(startButton, BorderLayout.SOUTH);
        panel.add(backgroundLabel, BorderLayout.CENTER);

        setContentPane(panel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        
        
    }
    
    
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Login frame = new Login("Login", () -> {
                System.out.println("���ӿ� �����մϴ�..");             
                SwingUtilities.invokeLater(() -> new Waitroom("����"));
            });
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}