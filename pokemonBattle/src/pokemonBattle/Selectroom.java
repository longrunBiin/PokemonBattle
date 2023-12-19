package pokemonBattle;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import game.Player;
import pokemon.Bulbasaur;
import pokemon.Charmander;
import pokemon.Pikachu;
import pokemon.Pokemon;
import pokemon.Squirtle;

import java.awt.FlowLayout;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Selectroom extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	JButton pikachuButton;
	JButton charmanderButton;
	JButton squirtleButton;
	JButton bulbasaurButton;
	private Client client;

	Player player;
	Pokemon myPokemon;
	Pokemon pikachu = new Pikachu();
	Pokemon charmander = new Charmander();
	Pokemon squirtle = new Squirtle();
	Pokemon bulbasaur = new Bulbasaur();
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

		
		// 이미지 아이콘 생성
		ImageIcon pikachuIcon = new ImageIcon(getClass().getResource("/image/Pikachu_front.png"));

		// 버튼 생성과 동시에 아이콘과 텍스트 설정
		pikachuButton = new JButton("PIKACHU", pikachuIcon);

		// 텍스트 위치 설정
		pikachuButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		pikachuButton.setHorizontalTextPosition(SwingConstants.CENTER);

		// 버튼 위치 및 크기 설정
		pikachuButton.setBounds(10, 69, 138, 225);

		// 콘텐츠 팬에 버튼 추가
		contentPane.add(pikachuButton);
		
		// 차맨더 이미지 아이콘 생성
		ImageIcon charmanderIcon = new ImageIcon(getClass().getResource("/image/CHARMANDER_front.png"));
		charmanderButton = new JButton("CHARMANDER", charmanderIcon);
		charmanderButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		charmanderButton.setHorizontalTextPosition(SwingConstants.CENTER);
		charmanderButton.setBounds(174, 69, 149, 225);
		contentPane.add(charmanderButton);
		
		// 꼬북이 생성
		ImageIcon squirtleIcon = new ImageIcon(getClass().getResource("/image/SQUIRTLE.png"));		
		squirtleButton = new JButton("SQUIRTLE", squirtleIcon);	
		squirtleButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		squirtleButton.setHorizontalTextPosition(SwingConstants.CENTER);
		squirtleButton.setBounds(350, 69, 149, 225);		
		contentPane.add(squirtleButton);
		
		//이상해씨 생성
		ImageIcon bulbasaurIcon = new ImageIcon(getClass().getResource("/image/BULBASAUR.png"));		
		bulbasaurButton = new JButton("BULBASAUR", bulbasaurIcon);
		bulbasaurButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		bulbasaurButton.setHorizontalTextPosition(SwingConstants.CENTER);
		bulbasaurButton.setBounds(522, 69, 156, 225);
		contentPane.add(bulbasaurButton);
		
		
		
		pikachuButton.addActionListener(this);
		charmanderButton.addActionListener(this);
		squirtleButton.addActionListener(this);
		bulbasaurButton.addActionListener(this);

		
		
		JButton btnNewButton_2 = new JButton("READY");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player = new Player(myPokemon);
				client.sendBattleReadyStatus();
				try {
					client.sendPlayerReady();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("player ready");
			}
		});
		btnNewButton_2.setBounds(260, 350, 149, 57);
		contentPane.add(btnNewButton_2);
		

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== pikachuButton) {
			myPokemon = pikachu;
			System.out.println("pikachu select");
		}else if(e.getSource()==charmanderButton) {
			myPokemon = charmander;
			System.out.println("charmander select");
		}else if(e.getSource()==squirtleButton) {
			myPokemon = charmander;
			System.out.println("squirtle select");
		}
		else if(e.getSource()==bulbasaurButton) {
			myPokemon = charmander;
			System.out.println("bulbasaur select");
			}

	}
	public Player getPlayer() {
		return player;
	}
}
