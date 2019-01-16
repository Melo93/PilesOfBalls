package filanti.gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import filanti.core.GameConfig;


public class GameFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GamePanel gamePanel; 
	
	public GameFrame() {
		this.setTitle("Pile of Balls"); //setto Titolo
		this.setPreferredSize(new Dimension(GameConfig.GRAPHIC_GAME_WIDTH ,GameConfig.GRAPHIC_GAME_HEIGHT));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true); // visibilità si del frame
		gamePanel = new GamePanel(this); // // crea il nuovo pannello nella classe frame
		this.setContentPane(gamePanel); // aggiungo il pannello al frame
		this.setLocationRelativeTo(gamePanel); //Imposto la posizione della finestra rispetto al gamepanel
		this.pack(); //adattamento layout delle componenti
//		this.setSize(new Dimension(HEIGHT, WIDTH));
	}
	
	public void startMenuPanel() {
		JPanel p = new MenuPanel(this);
		this.setContentPane(p);
		p.requestFocus();
		p.updateUI();
		p.setVisible(true);
	}
	
	public void startPlayPanel() {
		PlayPanel p1 = new PlayPanel(this);
		this.setContentPane(p1);
		p1.requestFocus();
		p1.updateUI();
		p1.setVisible(true);
		p1.start();
	}
}
