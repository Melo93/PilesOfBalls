package pob.filanti.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import pob.filanti.controller.KeyboardManager;
import pob.filanti.core.GameConfig;
import pob.filanti.core.GameManager;
import pob.filanti.core.TrisBalls;
import pob.filanti.updater.Updater;

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
	Updater update;
	TrisBalls t;
	KeyboardManager keyManager;
	
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
		t=GameManager.getInstance().getCurrent();
		
		
		this.add(backButton);
		this.add(leftButton);
		this.add(rightButton);
		this.add(roundRightButton);
		this.add(roundLeftButton);
		this.add(speedButton);
	//	this.add(r);
	//	this.add(v);
		this.add(gi);
		this.add(b);
		this.setVisible(true);
		
		keyManager=new KeyboardManager(this);
		addKeyListener(keyManager);
		
		update=new Updater(this);
		update.start();
		
		
		// CREO UN NUOVO TREAD, USANDO L'INTERFACCIA RUNNABLE, CHE VIENE
				// RIDEFINITO ATTRAVERSO UNA INNER CLASS PER EFFETTUARE IL REPAINT.
			
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
		
		
		if(t.getB1().getColor()==0) g.drawImage(ImageProvider.getPallinaRossa(),GameConfig.logicToGraphic(t.getB1().getCenter().x, t.getB1().getCenter().y).x ,GameConfig.logicToGraphic(t.getB1().getCenter().x, t.getB1().getCenter().y).y , null);
		else if(t.getB1().getColor()==1) g.drawImage(ImageProvider.getPallinaBlu(),GameConfig.logicToGraphic(t.getB1().getCenter().x, t.getB1().getCenter().y).x ,GameConfig.logicToGraphic(t.getB1().getCenter().x, t.getB1().getCenter().y).y, null);
		else if(t.getB1().getColor()==2) g.drawImage(ImageProvider.getPallinaVerde(), GameConfig.logicToGraphic(t.getB1().getCenter().x, t.getB1().getCenter().y).x ,GameConfig.logicToGraphic(t.getB1().getCenter().x, t.getB1().getCenter().y).y, null);
		
		if(t.getB2().getColor()==0) g.drawImage(ImageProvider.getPallinaRossa(),GameConfig.logicToGraphic(t.getB2().getCenter().x, t.getB2().getCenter().y).x ,GameConfig.logicToGraphic(t.getB2().getCenter().x, t.getB2().getCenter().y).y, null);
		else if(t.getB2().getColor()==1) g.drawImage(ImageProvider.getPallinaBlu(),GameConfig.logicToGraphic(t.getB2().getCenter().x, t.getB2().getCenter().y).x ,GameConfig.logicToGraphic(t.getB2().getCenter().x, t.getB2().getCenter().y).y, null);
		else if(t.getB2().getColor()==2) g.drawImage(ImageProvider.getPallinaVerde(),GameConfig.logicToGraphic(t.getB2().getCenter().x, t.getB2().getCenter().y).x ,GameConfig.logicToGraphic(t.getB2().getCenter().x, t.getB2().getCenter().y).y, null);
		
		if(t.getB3().getColor()==0) g.drawImage(ImageProvider.getPallinaRossa(),GameConfig.logicToGraphic(t.getB3().getCenter().x, t.getB3().getCenter().y).x ,GameConfig.logicToGraphic(t.getB3().getCenter().x, t.getB3().getCenter().y).y, null);
		else if(t.getB3().getColor()==1) g.drawImage(ImageProvider.getPallinaBlu(),GameConfig.logicToGraphic(t.getB3().getCenter().x, t.getB3().getCenter().y).x ,GameConfig.logicToGraphic(t.getB3().getCenter().x, t.getB3().getCenter().y).y, null);
		else if(t.getB3().getColor()==2) g.drawImage(ImageProvider.getPallinaVerde(),GameConfig.logicToGraphic(t.getB3().getCenter().x, t.getB3().getCenter().y).x ,GameConfig.logicToGraphic(t.getB3().getCenter().x, t.getB3().getCenter().y).y, null);
		
		
//		
//		r.setBounds(229,36,50,50);
//		r.setOpaque(false);
//		r.setContentAreaFilled(false);
//		r.setBorderPainted(false);
//		
//		v.setBounds(179,36,50,50);
//		v.setOpaque(false);
//		v.setContentAreaFilled(false);
//		v.setBorderPainted(false);
		
		b.setBounds(200,200,50,50);
		b.setOpaque(false);
		b.setContentAreaFilled(false);
		b.setBorderPainted(false);
		
		gi.setBounds(250,200,50,50);
		gi.setOpaque(false);
		gi.setContentAreaFilled(false);
		gi.setBorderPainted(false);
	
	}
	
	public void start() {
		//matrix.start();
	}
	
}
