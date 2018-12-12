package pob.filanti.gui;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import pob.filanti.core.GameManager;

public class PlayPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton backButton; 
	JButton leftButton; 
	JButton rightButton; 
	JButton roundRightButton; 
	JButton roundLeftButton; 
	JButton speedButton; 
	GameManager matrix;
	Runnable runnable; //esecutore
	JButton r;
	JButton v;
	JButton b;
	JButton gi;
	
	public PlayPanel(GameFrame gameFrame) {
		this.setVisible(true);
		this.setPreferredSize(new Dimension(HEIGHT, WIDTH));
		
		backButton = new JButton(new ImageIcon(ImageProvider.getBack2()));
		backButton.setRolloverIcon(new ImageIcon(ImageProvider.getBack1()));
		backButton.addActionListener(e -> gameFrame.startMenuPanel());
		
		leftButton = new JButton(new ImageIcon(ImageProvider.getLeft2())); 
		leftButton.setRolloverIcon(new ImageIcon(ImageProvider.getLeft()));
		
		rightButton = new JButton(new ImageIcon(ImageProvider.getRight2())); 
		rightButton.setRolloverIcon(new ImageIcon(ImageProvider.getRight()));
		
		roundRightButton = new JButton(new ImageIcon(ImageProvider.getRoundright2())); 
		roundRightButton.setRolloverIcon(new ImageIcon(ImageProvider.getRoundright()));
		
		roundLeftButton = new JButton(new ImageIcon(ImageProvider.getRoundleft2())); 
		roundLeftButton.setRolloverIcon(new ImageIcon(ImageProvider.getRoundleft()));
		
		speedButton = new JButton(new ImageIcon(ImageProvider.getSpeed2())); 
		speedButton.setRolloverIcon(new ImageIcon(ImageProvider.getSpeed()));
	
		r = new JButton(new ImageIcon(ImageProvider.getPallinaRossa()));
		v = new JButton(new ImageIcon(ImageProvider.getPallinaVerde()));
		gi = new JButton(new ImageIcon(ImageProvider.getPallinaGialla()));
		b = new JButton(new ImageIcon(ImageProvider.getPallinaBlu()));
		
		this.add(backButton);
		this.add(leftButton);
		this.add(rightButton);
		this.add(roundRightButton);
		this.add(roundLeftButton);
		this.add(speedButton);
		this.add(r);
		this.add(v);
		this.add(gi);
		this.add(b);
		this.setVisible(true);
		
		// CREO UN NUOVO TREAD, USANDO L'INTERFACCIA RUNNABLE, CHE VIENE
				// RIDEFINITO ATTRAVERSO UNA INNER CLASS PER EFFETTUARE IL REPAINT.
				this.runnable = new Runnable() {

					@Override 
					public void run() {
						repaint();
					}

				};
				this.matrix = new GameManager(4, runnable);
				//this.matrix.printMatrix();
	}
	 
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(ImageProvider.getBackgroundPlayPanel(), 0, 0, null);
		// BOTTONE BACK
		backButton.setBounds(35,615,100,100);
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		
		leftButton.setBounds(885,50,100,100);
		leftButton.setOpaque(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setBorderPainted(false);
		
		rightButton.setBounds(885,175,100,100);
		rightButton.setOpaque(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setBorderPainted(false);
		
		roundLeftButton.setBounds(885,312,100,100);
		roundLeftButton.setOpaque(false);
		roundLeftButton.setContentAreaFilled(false);
		roundLeftButton.setBorderPainted(false);
		
		roundRightButton.setBounds(885,462,100,100);
		roundRightButton.setOpaque(false);
		roundRightButton.setContentAreaFilled(false);
		roundRightButton.setBorderPainted(false);
				
		speedButton.setBounds(885,625,100,100);
		speedButton.setOpaque(false);
		speedButton.setContentAreaFilled(false);
		speedButton.setBorderPainted(false);
		
		r.setBounds(229,36,50,50);
		r.setOpaque(false);
		r.setContentAreaFilled(false);
		r.setBorderPainted(false);
		
		v.setBounds(179,36,50,50);
		v.setOpaque(false);
		v.setContentAreaFilled(false);
		v.setBorderPainted(false);
		
		b.setBounds(200,200,50,50);
		b.setOpaque(false);
		b.setContentAreaFilled(false);
		b.setBorderPainted(false);
		
		gi.setBounds(250,200,50,50);
		gi.setOpaque(false);
		gi.setContentAreaFilled(false);
		gi.setBorderPainted(false);
		
		// LINEE DI CONTORNO DELLA MATRICE
		g.drawLine(179, 36, 179, 734);
		g.drawLine(229, 36, 229, 734);
		g.drawLine(279, 36, 279, 734);
		g.drawLine(329, 36, 329, 734);
		g.drawLine(379, 36, 379, 734);
		g.drawLine(429, 36, 429, 734);
		g.drawLine(479, 36, 479, 734);
		g.drawLine(529, 36, 529, 734);
		g.drawLine(579, 36, 579, 734);
		g.drawLine(629, 36, 629, 734);
		g.drawLine(679, 36, 679, 734);
		g.drawLine(729, 36, 729, 734);
		g.drawLine(779, 36, 779, 734);
		g.drawLine(829, 36, 829, 734);
		
		g.drawLine(179, 36, 845, 36);
		g.drawLine(179, 86, 845, 86);
		g.drawLine(179, 136, 845, 136);
		g.drawLine(179, 186, 845, 186);
		g.drawLine(179, 236, 845, 236);
		g.drawLine(179, 286, 845, 286);
		g.drawLine(179, 336, 845, 336);
		g.drawLine(179, 386, 845, 386);
		g.drawLine(179, 436, 845, 436);
		g.drawLine(179, 486, 845, 486);
		g.drawLine(179, 536, 845, 536);
		g.drawLine(179, 586, 845, 586);
		g.drawLine(179, 636, 845, 636);
		g.drawLine(179, 686, 845, 686);
		g.drawLine(179, 736, 845, 736);
		g.drawLine(179, 786, 845, 786);
	}
	
	public void start() {
		//matrix.start();
	}
	
}
