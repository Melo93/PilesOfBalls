package pob.filanti.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

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
	Updater update;
	TrisBalls t;
	KeyboardManager keyManager;
	KeyEvent key;
	
	public PlayPanel(GameFrame gameFrame) {
		this.setVisible(true);
		this.setPreferredSize(new Dimension(HEIGHT, WIDTH));
		keyManager=new KeyboardManager(this);
		addKeyListener(keyManager);
				
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
		
		t=GameManager.getInstance().getCurrent();
		
		roundRightButton.addKeyListener(keyManager);
		
		this.add(backButton);
		this.add(leftButton);
		this.add(rightButton);
		this.add(roundRightButton);
		this.add(roundLeftButton);
		this.add(speedButton);
		this.setVisible(true);	
		
		update=new Updater(this);
		update.start();
		rightButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GameManager.getInstance().getCurrent().getB1().setCenter(new Point(GameManager.getInstance().getCurrent().getB1().getCenter().x+1,GameManager.getInstance().getCurrent().getB1().getCenter().y));
				GameManager.getInstance().getCurrent().getB2().setCenter(new Point(GameManager.getInstance().getCurrent().getB2().getCenter().x+1,GameManager.getInstance().getCurrent().getB2().getCenter().y));
				GameManager.getInstance().getCurrent().getB3().setCenter(new Point(GameManager.getInstance().getCurrent().getB3().getCenter().x+1,GameManager.getInstance().getCurrent().getB3().getCenter().y));			
			}
		});
		
		leftButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GameManager.getInstance().getCurrent().getB1().setCenter(new Point(GameManager.getInstance().getCurrent().getB1().getCenter().x-1,GameManager.getInstance().getCurrent().getB1().getCenter().y));
				GameManager.getInstance().getCurrent().getB2().setCenter(new Point(GameManager.getInstance().getCurrent().getB2().getCenter().x-1,GameManager.getInstance().getCurrent().getB2().getCenter().y));
				GameManager.getInstance().getCurrent().getB3().setCenter(new Point(GameManager.getInstance().getCurrent().getB3().getCenter().x-1,GameManager.getInstance().getCurrent().getB3().getCenter().y));
			}
		});
	}
	 
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(ImageProvider.getBackgroundPlayPanel(), 0, 0, null);

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
		
		
		if(t.getB1().getColor()==0) {
			g.drawImage(ImageProvider.getPallinaRossa(),GameConfig.logicToGraphic(t.getB1().getCenter().x, t.getB1().getCenter().y).x ,GameConfig.logicToGraphic(t.getB1().getCenter().x, t.getB1().getCenter().y).y , null);
		} else if(t.getB1().getColor()==1) {
			g.drawImage(ImageProvider.getPallinaBlu(),GameConfig.logicToGraphic(t.getB1().getCenter().x, t.getB1().getCenter().y).x ,GameConfig.logicToGraphic(t.getB1().getCenter().x, t.getB1().getCenter().y).y, null);
		} else if(t.getB1().getColor()==2) {
			g.drawImage(ImageProvider.getPallinaVerde(), GameConfig.logicToGraphic(t.getB1().getCenter().x, t.getB1().getCenter().y).x ,GameConfig.logicToGraphic(t.getB1().getCenter().x, t.getB1().getCenter().y).y, null);
		} else {
			g.drawImage(ImageProvider.getPallinaGialla(), GameConfig.logicToGraphic(t.getB1().getCenter().x, t.getB1().getCenter().y).x ,GameConfig.logicToGraphic(t.getB1().getCenter().x, t.getB1().getCenter().y).y, null);
		}
		if(t.getB2().getColor()==0) {
			g.drawImage(ImageProvider.getPallinaRossa(),GameConfig.logicToGraphic(t.getB2().getCenter().x, t.getB2().getCenter().y).x ,GameConfig.logicToGraphic(t.getB2().getCenter().x, t.getB2().getCenter().y).y, null);
		} else if(t.getB2().getColor()==1) {
			g.drawImage(ImageProvider.getPallinaBlu(),GameConfig.logicToGraphic(t.getB2().getCenter().x, t.getB2().getCenter().y).x ,GameConfig.logicToGraphic(t.getB2().getCenter().x, t.getB2().getCenter().y).y, null);
		} else if(t.getB2().getColor()==2) {
			g.drawImage(ImageProvider.getPallinaVerde(),GameConfig.logicToGraphic(t.getB2().getCenter().x, t.getB2().getCenter().y).x ,GameConfig.logicToGraphic(t.getB2().getCenter().x, t.getB2().getCenter().y).y, null);
		} else {
			g.drawImage(ImageProvider.getPallinaGialla(),GameConfig.logicToGraphic(t.getB2().getCenter().x, t.getB2().getCenter().y).x ,GameConfig.logicToGraphic(t.getB2().getCenter().x, t.getB2().getCenter().y).y, null);
		}
		if(t.getB3().getColor()==0) {
			g.drawImage(ImageProvider.getPallinaRossa(),GameConfig.logicToGraphic(t.getB3().getCenter().x, t.getB3().getCenter().y).x ,GameConfig.logicToGraphic(t.getB3().getCenter().x, t.getB3().getCenter().y).y, null);
		} else if(t.getB3().getColor()==1) {
			g.drawImage(ImageProvider.getPallinaBlu(),GameConfig.logicToGraphic(t.getB3().getCenter().x, t.getB3().getCenter().y).x ,GameConfig.logicToGraphic(t.getB3().getCenter().x, t.getB3().getCenter().y).y, null);
		} else if(t.getB3().getColor()==2) {
			g.drawImage(ImageProvider.getPallinaVerde(),GameConfig.logicToGraphic(t.getB3().getCenter().x, t.getB3().getCenter().y).x ,GameConfig.logicToGraphic(t.getB3().getCenter().x, t.getB3().getCenter().y).y, null);
		} else {
			g.drawImage(ImageProvider.getPallinaGialla(),GameConfig.logicToGraphic(t.getB3().getCenter().x, t.getB3().getCenter().y).x ,GameConfig.logicToGraphic(t.getB3().getCenter().x, t.getB3().getCenter().y).y, null);
		}
		
	
	}
	
	public void start() {
		//matrix.start();
	}
	
}
