
package pokemonBattle;

import javax.swing.*;

import game.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PokemonBattleGUI extends JFrame implements ActionListener{

    private JLabel player1PokemonHP, player2PokemonHP;
    private JLabel player1PokemonImageLabel, player2PokemonImageLabel;
    private JTextArea battleLog;
    private JProgressBar player1HPBar, player2HPBar;
    
    JButton skill1;
    JButton skill2;
    JButton skill3;
    JButton skill4;
    
    Player player;
    Client client;
    
    List<String> skillNames = new ArrayList<>();


    public PokemonBattleGUI(Client client, Player player) {
    	this.player = player;
    	this.client = client;
    	
    	
    	
        setTitle("포켓몬 배틀");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        // 포켓몬 이미지
        //player1PokemonImageLabel = new JLabel(new ImageIcon("/image/login.png"));
        // 이미지 예시
        player1PokemonImageLabel = new JLabel(new ImageIcon(getClass().getResource("/image/waitroom.png")));
        player1PokemonImageLabel.setBounds(10, 119, 258, 232); // 위치와 크기 조정
        getContentPane().add(player1PokemonImageLabel);

        //player2PokemonImageLabel = new JLabel(new ImageIcon("/image/Waitroom.png"));
        player2PokemonImageLabel = new JLabel(new ImageIcon(getClass().getResource("/image/login.png")));
        player2PokemonImageLabel.setBounds(520, 10, 258, 232); // 위치와 크기 조정
        getContentPane().add(player2PokemonImageLabel);
        
        updatePokemonImages(player.getPokemon().getName(), client.getEnemyPokemon());

        // HP 바 
        player1HPBar = new JProgressBar(0, 100);
        player1HPBar.setValue(100); // 예시 HP
        player1HPBar.setBounds(318, 291, 200, 20); // 위치와 크기 조정
        getContentPane().add(player1HPBar);

        player2HPBar = new JProgressBar(0, 100);
        player2HPBar.setValue(100); // 예시 HP
        player2HPBar.setBounds(284, 10, 200, 20); // 위치와 크기 조정
        getContentPane().add(player2HPBar);

        // HP 레이블
        player1PokemonHP = new JLabel("100 / 100");
        player1PokemonHP.setBounds(318, 310, 200, 20); // 위치와 크기 조정
        getContentPane().add(player1PokemonHP);

        player2PokemonHP = new JLabel("100 / 100");
        player2PokemonHP.setBounds(284, 26, 200, 20); // 위치와 크기 조정
        getContentPane().add(player2PokemonHP);

        // 배틀 로그
        battleLog = new JTextArea();
        battleLog.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(battleLog);
        scrollPane.setBounds(318, 365, 472, 200); // 위치와 크기 조정
        getContentPane().add(scrollPane);
        
        JPanel panel = new JPanel();
        panel.setBounds(10, 365, 298, 200);
        getContentPane().add(panel);
        panel.setLayout(null);
        
        skillNames = player.getPokemonSkill();
        skill1 = new JButton(skillNames.get(0));
        skill1.setBounds(10, 10, 118, 85);
        panel.add(skill1);
        
        skill2 = new JButton(skillNames.get(1));
        skill2.setBounds(161, 10, 127, 85);
        panel.add(skill2);
        
        skill3 = new JButton(skillNames.get(2));
        skill3.setBounds(10, 105, 118, 85);
        panel.add(skill3);
        
        skill4 = new JButton(skillNames.get(3));
        skill4.setBounds(161, 105, 127, 85);
        panel.add(skill4);
        
        skill1.addActionListener(this);
        skill2.addActionListener(this);
        skill3.addActionListener(this);
        skill4.addActionListener(this);

        // 이벤트 리스너 및 게임 로직은
        }
    private void updatePokemonImages(String myPokemon, String enemyPokemon) {
    	// 내 포켓몬 이미지 업데이트
        String myImagePath = "/image/" + myPokemon + ".png";
        URL myImageResource = getClass().getResource(myImagePath);
        if (myImageResource != null) {
            ImageIcon myImageIcon = new ImageIcon(myImageResource);
            player1PokemonImageLabel.setIcon(myImageIcon);
        } else {
            System.err.println("Image not found: " + myImagePath);
        }

        // 상대 포켓몬 이미지 업데이트
        String enemyImagePath = "/image/" + enemyPokemon + ".png";
        URL enemyImageResource = getClass().getResource(enemyImagePath);
        if (enemyImageResource != null) {
            ImageIcon enemyImageIcon = new ImageIcon(enemyImageResource);
            player2PokemonImageLabel.setIcon(enemyImageIcon);
        } else {
            System.err.println("Image not found: " + enemyImagePath);
        }
        
    }
    
    public void updateHP(String myHp, String enemyHp) {
        // HP 레이블 업데이트
        player1PokemonHP.setText(myHp + " / 100");
        player2PokemonHP.setText(enemyHp + " / 100");
       System.out.println("updateHP : " + myHp + " " + enemyHp);
        // HP 바 업데이트
        try {
            int myHpInt = Integer.parseInt(myHp);
            player1HPBar.setValue(myHpInt);

            int enemyHpInt = Integer.parseInt(enemyHp);
            player2HPBar.setValue(enemyHpInt);
            
            if (myHpInt <= 0 || enemyHpInt <= 0) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        // 여기에 UI 업데이트 코드를 넣습니다.

                        JFrame gameOverWindow = new JFrame("게임 종료");

                        // 레이아웃 관리자를 BorderLayout으로 설정
                        gameOverWindow.setLayout(new BorderLayout());

                        // 중앙에 메시지 표시
                        JLabel messageLabel = new JLabel("게임이 종료되었습니다.");
                        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
                        gameOverWindow.add(messageLabel, BorderLayout.NORTH);

                        // 아래쪽에 승패 표시
                        JLabel winLabel;
                        if (myHpInt <= 0) {
                            winLabel = new JLabel("패배하셨습니다.");
                        } else {
                            winLabel = new JLabel("승리하셨습니다.");
                        }
                        winLabel.setHorizontalAlignment(SwingConstants.CENTER);
                        gameOverWindow.add(winLabel, BorderLayout.CENTER);

                        // 아래쪽에 버튼 배치
                        JButton closeButton = new JButton("창 닫기");
                        closeButton.setAlignmentX(Component.CENTER_ALIGNMENT); // 수평 가운데 정렬
                        gameOverWindow.add(closeButton, BorderLayout.SOUTH);

                        // 창 크기 및 위치 설정
                        gameOverWindow.setSize(300, 200);
                        gameOverWindow.setLocationRelativeTo(null);

                        // 버튼에 이벤트 리스너를 등록합니다.
                        closeButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // 창 닫기 버튼을 누르면 기존에 있던 JFrame도 닫힙니다.
                                gameOverWindow.dispose();
                                client.endGame();
                            }
                        });

                        // 게임 종료 창을 보이게 합니다.
                        gameOverWindow.setVisible(true);
                    }
                });
            }

        } catch (NumberFormatException e) {
            System.err.println("Invalid HP format");
        }
    }

    

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== skill1) {
			client.useSkill("1");
		}else if(e.getSource()==skill2) {
			client.useSkill("2");
		}else if(e.getSource()==skill3) {
			client.useSkill("3");
		}else if(e.getSource()==skill4) {
			client.useSkill("4");
		}
		
	}
}
