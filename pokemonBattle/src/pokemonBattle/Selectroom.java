package pokemonBattle;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import game.Player;
import pokemon.Charmander;
import pokemon.Pikachu;
import pokemon.Pokemon;

import java.awt.FlowLayout;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Selectroom extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	JButton pikachuButton;
	JButton charmanderButton
	;
	private Client client;

	Player player;
	Pokemon myPokemon;
	Pokemon pikachu = new Pikachu();
	Pokemon charmander = new Charmander();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Selectroom frame = new Selectroom();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Selectroom(Client client) {
		this.client = client;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		ImageIcon pikachuIcon = new ImageIcon(getClass().getResource("/image/Pikachu_front.png"));
//		pikachuButton.setIcon(pikachuIcon);
//		pikachuButton = new JButton("PIKACHU", pikachuIcon);
//		pikachuButton.setVerticalTextPosition(SwingConstants.BOTTOM);
//		pikachuButton.setHorizontalTextPosition(SwingConstants.CENTER);
//		pikachuButton = new JButton("PIKACHU");
//		pikachuButton.setBounds(10, 69, 190, 210);
//		contentPane.add(pikachuButton);
		
		// 이미지 아이콘 생성
		ImageIcon pikachuIcon = new ImageIcon(getClass().getResource("/image/Pikachu_front.png"));

		// 버튼 생성과 동시에 아이콘과 텍스트 설정
		pikachuButton = new JButton("PIKACHU", pikachuIcon);

		// 텍스트 위치 설정
		pikachuButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		pikachuButton.setHorizontalTextPosition(SwingConstants.CENTER);

		// 버튼 위치 및 크기 설정
		pikachuButton.setBounds(10, 69, 190, 229);

		// 콘텐츠 팬에 버튼 추가
		contentPane.add(pikachuButton);

		
//		charmanderButton = new JButton("CHARMANDER");
//		charmanderButton.setBounds(247, 69, 190, 210);
//		contentPane.add(charmanderButton);
		
		// 차맨더 이미지 아이콘 생성
		ImageIcon charmanderIcon = new ImageIcon(getClass().getResource("/image/CHARMANDER_front.png"));

		// 버튼 생성과 동시에 아이콘과 텍스트 설정
		charmanderButton = new JButton("CHARMANDER", charmanderIcon);

		// 텍스트 위치 설정
		charmanderButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		charmanderButton.setHorizontalTextPosition(SwingConstants.CENTER);

		// 버튼 위치 및 크기 설정
		charmanderButton.setBounds(247, 69, 190, 229);

		// 콘텐츠 팬에 버튼 추가
		contentPane.add(charmanderButton);

		
		
		JButton btnNewButton_2 = new JButton("READY");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player = new Player(myPokemon);
				client.sendBattleReadyStatus();
				System.out.println("player ready");
			}
		});
		btnNewButton_2.setBounds(260, 350, 149, 57);
		contentPane.add(btnNewButton_2);
		

		JButton btnNewButton_1_1 = new JButton("POKEMON2");
		btnNewButton_1_1.setBounds(488, 69, 190, 229);
		contentPane.add(btnNewButton_1_1);
		
		pikachuButton.addActionListener(this);
		charmanderButton.addActionListener(this);
		
		JButton btnNewButton_3 = new JButton("POKEMON3");
		btnNewButton_3.setBounds(488, 69, 190, 210);
		contentPane.add(btnNewButton_3);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== pikachuButton) {
			myPokemon = pikachu;
			System.out.println("pikachu select");
		}else if(e.getSource()==charmanderButton) {
			myPokemon = charmander;
			System.out.println("charmander select");
		}

		
		

	}
	public Player getPlayer() {
		return player;
	}
}
