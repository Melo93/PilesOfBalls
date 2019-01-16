package pob.filanti.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton newGameButton; 
	JButton exitButton; 
	private GameFrame gameframe; 
	
	public MenuPanel(GameFrame gameFrame) {
		this.setVisible(true);
		this.setPreferredSize(new Dimension(HEIGHT, WIDTH));
		this.gameframe = gameFrame;
		
		newGameButton = new JButton(new ImageIcon(ImageProvider.getNewgame2()));
		newGameButton.setRolloverIcon(new ImageIcon(ImageProvider.getNewgame1()));
		newGameButton.addActionListener(e -> gameframe.startPlayPanel());
		exitButton = new JButton(new ImageIcon(ImageProvider.getExit2()));
		exitButton.setRolloverIcon(new ImageIcon(ImageProvider.getExit1()));
		exitButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
		});
		this.add(newGameButton);
		this.add(exitButton);
		
		this.setVisible(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(ImageProvider.getBackgroundMenuPanel(), 0, 0, null);
		newGameButton.setBounds(450,300,150,40);
		newGameButton.setOpaque(false);
		newGameButton.setContentAreaFilled(false);
		newGameButton.setBorderPainted(false);
		
		exitButton.setBounds(475,500,90,40);
		exitButton.setOpaque(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setBorderPainted(false);
		
	}
}