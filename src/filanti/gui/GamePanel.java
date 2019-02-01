package filanti.gui;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private GameFrame mainFrame; 
	JButton startButton;
	
	public GamePanel(GameFrame gf) {
		
		this.mainFrame = gf; 
		
		this.setLayout(null);
		
		this.setPreferredSize(new Dimension(HEIGHT, WIDTH));
		
		startButton = new JButton(new ImageIcon(ImageProvider.getStartGame2()));
		
		startButton.addActionListener(e -> mainFrame.startMenuPanel());
		
		startButton.setBounds(0, 0, ImageProvider.getNewgame1().getWidth(null), ImageProvider.getNewgame1().getHeight(null));
		
		startButton.setOpaque(false);
		
		startButton.setRolloverIcon(new ImageIcon(ImageProvider.getStartGame1()));
		
		this.add(startButton);
		
		this.setVisible(true);
	}
	
	@Override 
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(ImageProvider.getBackgroundStartPanel(), 0, 0, null);
		startButton.setBounds(475,350,90,40);
		startButton.setOpaque(false);
		startButton.setContentAreaFilled(false);
		startButton.setBorderPainted(false);
		//startButton.setBorder(new LineBorder(Color.BLACK));
		
		
	}
}
