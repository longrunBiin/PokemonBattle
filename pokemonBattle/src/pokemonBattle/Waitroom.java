package pokemonBattle;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Waitroom extends JFrame {
    private JTextArea textArea;
    private JTextField inputBox;
    private JButton sendButton;
    private JScrollPane scrollPane;

    public Waitroom(String title) {
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
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
        add(imageLabel);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(new Color(1, 49, 100));
        textArea.setForeground(Color.WHITE);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(20, 370, 710, 100);
        scrollPane.setBorder(new LineBorder(Color.YELLOW, 3));
        add(scrollPane);

        inputBox = new JTextField();
        inputBox.setBackground(new Color(1, 49, 100));
        inputBox.setForeground(Color.WHITE);
        inputBox.setBorder(new LineBorder(Color.YELLOW, 3));
        inputBox.setBounds(20, 480, 580, 30);
        add(inputBox);

        sendButton = new JButton("������");
        sendButton.setBounds(620, 480, 110, 30);
        sendButton.setBackground(Color.YELLOW);
        sendButton.setFocusPainted(false);
        add(sendButton);

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