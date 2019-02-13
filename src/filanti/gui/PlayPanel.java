package filanti.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import filanti.controller.KeyboardManager;
import filanti.controller.MouseManager;
import filanti.core.Ball;
import filanti.core.GameConfig;
import filanti.core.GameManager;
import filanti.core.TrisBalls;
import filanti.updater.Updater;


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
	Updater update;
	TrisBalls t;
	TrisBalls t1;
	KeyboardManager keyManager;
	MouseManager mouseManager;
	KeyEvent key;

	public PlayPanel(GameFrame gameFrame) {
		this.setVisible(true);
		this.setPreferredSize(new Dimension(HEIGHT, WIDTH));
		mouseManager=new MouseManager(this);
		addMouseListener(mouseManager);
		addMouseMotionListener(mouseManager);
		
		backButton = new JButton(new ImageIcon(ImageProvider.getBack2()));
		backButton.setRolloverIcon(new ImageIcon(ImageProvider.getBack1()));
		backButton.addActionListener(e -> gameFrame.startMenuPanel());

		leftButton = new JButton(new ImageIcon(ImageProvider.getLeft2())); 
		leftButton.setRolloverIcon(new ImageIcon(ImageProvider.getLeft()));
		leftButton.addMouseListener(mouseManager);

		rightButton = new JButton(new ImageIcon(ImageProvider.getRight2())); 
		rightButton.setRolloverIcon(new ImageIcon(ImageProvider.getRight()));
		rightButton.addMouseListener(mouseManager);

		roundRightButton = new JButton(new ImageIcon(ImageProvider.getRoundright2())); 
		roundRightButton.setRolloverIcon(new ImageIcon(ImageProvider.getRoundright()));
		roundRightButton.addMouseListener(mouseManager);

		roundLeftButton = new JButton(new ImageIcon(ImageProvider.getRoundleft2())); 
		roundLeftButton.setRolloverIcon(new ImageIcon(ImageProvider.getRoundleft()));
		roundLeftButton.addMouseListener(mouseManager);

		speedButton = new JButton(new ImageIcon(ImageProvider.getSpeed2())); 
		speedButton.setRolloverIcon(new ImageIcon(ImageProvider.getSpeed()));
		speedButton.addMouseListener(mouseManager);

		keyManager=new KeyboardManager(this);
		addKeyListener(keyManager);
//		if(GameManager.getInstance()!=null) {
//			GameManager.getInstance().clear();
//		}
	
		this.add(backButton);
		this.add(leftButton);
		this.add(rightButton);
		this.add(roundRightButton);
		this.add(roundLeftButton);
		this.add(speedButton);
		this.setVisible(true);	

		update=new Updater(this);
		update.start();

	}
	public JButton getLeftButton() {
		return leftButton;
	}

	public JButton getRightButton() {
		return rightButton;
	}

	public JButton getRoundLeftButton() {
		return roundLeftButton;
	}

	public JButton getRoundRightButton() {
		return roundRightButton;
	}

	public JButton getSpeedButton() {
		return speedButton;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		t=GameManager.getInstance().getCurrent();
		t1=GameManager.getInstance().getNext();

		g.drawImage(ImageProvider.getBackgroundPlayPanel(), 0, 0, null);

		backButton.setBounds(80,615,100,100);
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);

		leftButton.setBounds(850,73,100,100);
		leftButton.setOpaque(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setBorderPainted(false);

		rightButton.setBounds(850,213,100,100);
		rightButton.setOpaque(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setBorderPainted(false);

		roundLeftButton.setBounds(850,353,100,100);
		roundLeftButton.setOpaque(false);
		roundLeftButton.setContentAreaFilled(false);
		roundLeftButton.setBorderPainted(false);

		roundRightButton.setBounds(850,493,100,100);
		roundRightButton.setOpaque(false);
		roundRightButton.setContentAreaFilled(false);
		roundRightButton.setBorderPainted(false);

		speedButton.setBounds(850,633,100,100);
		speedButton.setOpaque(false);
		speedButton.setContentAreaFilled(false);
		speedButton.setBorderPainted(false);
		
		
		g.setFont(new Font("TimesRoman", Font.PLAIN, 50)); 
		g.setColor(new Color(255, 0, 0));
		g.drawString(String.valueOf(GameManager.getInstance().getScore()), GameConfig.logicToGraphic(5,22).x ,GameConfig.logicToGraphic(5,22).y );

//		paintTrisBall(g, t);
		paintTrisBall(g, t1);
		paintBalls(g);
		
	}
	
	private void paintBalls(Graphics g) {
		for(Ball t: GameManager.getInstance().getBalls()) {
			if(t.getColor()==0) {
				g.drawImage(ImageProvider.getPallinaRossa(),GameConfig.logicToGraphic(t.getCenter().x, t.getCenter().y).x ,GameConfig.logicToGraphic(t.getCenter().x, t.getCenter().y).y , null);
			} else if(t.getColor()==1) {
				g.drawImage(ImageProvider.getPallinaBlu(),GameConfig.logicToGraphic(t.getCenter().x, t.getCenter().y).x ,GameConfig.logicToGraphic(t.getCenter().x, t.getCenter().y).y, null);
			} else if(t.getColor()==2) {
				g.drawImage(ImageProvider.getPallinaVerde(), GameConfig.logicToGraphic(t.getCenter().x, t.getCenter().y).x ,GameConfig.logicToGraphic(t.getCenter().x, t.getCenter().y).y, null);
			} else {
				g.drawImage(ImageProvider.getPallinaGialla(), GameConfig.logicToGraphic(t.getCenter().x, t.getCenter().y).x ,GameConfig.logicToGraphic(t.getCenter().x, t.getCenter().y).y, null);
			}
		}
		
	}
	private void paintTrisBall(Graphics g, TrisBalls t) {
		
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

	public void setLeftButton(int button1) {
		// TODO Auto-generated method stub

	}

	public void setLeftButton(JButton leftButton) {
		this.leftButton = leftButton;
	}

	public void setRightButton(JButton rightButton) {
		this.rightButton = rightButton;
	}

	public void setRoundLeftButton(JButton roundLeftButton) {
		this.roundLeftButton = roundLeftButton;
	}

	public void setRoundRightButton(JButton roundRightButton) {
		this.roundRightButton = roundRightButton;
	}

	public void setSpeedButton(JButton speedButton) {
		this.speedButton = speedButton;
	}

	public void start() {
		//matrix.start();
	}

}
