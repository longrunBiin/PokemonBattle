package pokemonBattle;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Selectroom extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Selectroom frame = new Selectroom();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Selectroom() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("POKEMON1");
		btnNewButton.setBounds(10, 69, 190, 210);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("POKEMON2");
		btnNewButton_1.setBounds(247, 69, 190, 210);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("READY");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(260, 350, 149, 57);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("POKEMON3");
		btnNewButton_3.setBounds(488, 69, 190, 210);
		contentPane.add(btnNewButton_3);
	}
}
