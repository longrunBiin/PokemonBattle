package pokemonBattle;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Waitroom extends JFrame {
    private JTextArea textArea;
    private JTextField inputBox;
    private JButton sendButton;
    private JScrollPane scrollPane;
    private JPanel contentPane;
    
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Waitroom frame = new Waitroom("test");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    public Waitroom(String title) {
    	setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        int frameWidth = 760;
        int frameHeight = 560;
        setSize(frameWidth, frameHeight);
        
        Color backgroundColor = new Color(1, 49, 100);
        getContentPane().setBackground(backgroundColor);

        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/image/waitroom.png"));
        Image image = originalIcon.getImage();
        Image scaledImage = image.getScaledInstance(frameWidth, 365, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(0, 0, frameWidth, 365);
        getContentPane().add(imageLabel);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(new Color(1, 49, 100));
        textArea.setForeground(Color.WHITE);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(20, 370, 580, 100);
        scrollPane.setBorder(new LineBorder(Color.YELLOW, 3));
        getContentPane().add(scrollPane);

        inputBox = new JTextField();
        inputBox.setBackground(new Color(1, 49, 100));
        inputBox.setForeground(Color.WHITE);
        inputBox.setBorder(new LineBorder(Color.YELLOW, 3));
        inputBox.setBounds(20, 480, 580, 30);
        getContentPane().add(inputBox);

        sendButton = new JButton("º¸³»±â");
        sendButton.setBounds(620, 480, 110, 30);
        sendButton.setBackground(Color.YELLOW);
        sendButton.setFocusPainted(false);
        getContentPane().add(sendButton);
        
        JButton readyBtn = new JButton("READY");
        readyBtn.setBackground(Color.WHITE);
        readyBtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
        readyBtn.setBounds(620, 370, 110, 100);
        getContentPane().add(readyBtn);

        setVisible(true);
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public JTextField getInputBox() {
        return inputBox;
    }

    public JButton getSendButton() {
        return sendButton;
    }

    public void appendText(String text) {
        textArea.append(text);
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}