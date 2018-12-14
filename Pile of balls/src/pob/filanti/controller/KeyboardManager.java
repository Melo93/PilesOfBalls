package pob.filanti.controller;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import pob.filanti.core.GameManager;
import pob.filanti.gui.PlayPanel;

public class KeyboardManager implements KeyListener{

	private PlayPanel pp;
	
	public KeyboardManager(PlayPanel p) {
		this.pp=pp;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			GameManager.getInstance().getCurrent().getB1().setCenter(new Point(GameManager.getInstance().getCurrent().getB1().getCenter().x-1,GameManager.getInstance().getCurrent().getB1().getCenter().y));
			GameManager.getInstance().getCurrent().getB2().setCenter(new Point(GameManager.getInstance().getCurrent().getB2().getCenter().x-1,GameManager.getInstance().getCurrent().getB2().getCenter().y));
			GameManager.getInstance().getCurrent().getB3().setCenter(new Point(GameManager.getInstance().getCurrent().getB3().getCenter().x-1,GameManager.getInstance().getCurrent().getB3().getCenter().y));
			break;
			
		case KeyEvent.VK_RIGHT:
			GameManager.getInstance().getCurrent().getB1().setCenter(new Point(GameManager.getInstance().getCurrent().getB1().getCenter().x+1,GameManager.getInstance().getCurrent().getB1().getCenter().y));
			GameManager.getInstance().getCurrent().getB2().setCenter(new Point(GameManager.getInstance().getCurrent().getB2().getCenter().x+1,GameManager.getInstance().getCurrent().getB2().getCenter().y));
			GameManager.getInstance().getCurrent().getB3().setCenter(new Point(GameManager.getInstance().getCurrent().getB3().getCenter().x+1,GameManager.getInstance().getCurrent().getB3().getCenter().y));
			break;
		
		case KeyEvent.VK_UP:
			if(GameManager.getInstance().getCurrent().getPosition()>6) {
				GameManager.getInstance().getCurrent().setPosition(1);
				GameManager.getInstance().getCurrent().setPosition(GameManager.getInstance().getCurrent().getPosition());
			}
			GameManager.getInstance().getCurrent().setPosition(GameManager.getInstance().getCurrent().getPosition()+1);
			GameManager.getInstance().getCurrent().rotateLeft();
			System.out.println(GameManager.getInstance().getCurrent().toString());
			
			break;
			
		case KeyEvent.VK_DOWN:
			if(GameManager.getInstance().getCurrent().getPosition()>6) {
				GameManager.getInstance().getCurrent().setPosition(1);
				GameManager.getInstance().getCurrent().setPosition(GameManager.getInstance().getCurrent().getPosition());
			}
			GameManager.getInstance().getCurrent().setPosition(GameManager.getInstance().getCurrent().getPosition()+1);
			GameManager.getInstance().getCurrent().rotateRight();
			System.out.println(GameManager.getInstance().getCurrent().toString());
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_SPACE:
		GameManager.getInstance().getCurrent().getB1().setCenter(new Point(GameManager.getInstance().getCurrent().getB1().getCenter().x,GameManager.getInstance().getCurrent().getB1().getCenter().y+1));
		GameManager.getInstance().getCurrent().getB2().setCenter(new Point(GameManager.getInstance().getCurrent().getB2().getCenter().x,GameManager.getInstance().getCurrent().getB2().getCenter().y+1));
		GameManager.getInstance().getCurrent().getB3().setCenter(new Point(GameManager.getInstance().getCurrent().getB3().getCenter().x,GameManager.getInstance().getCurrent().getB3().getCenter().y+1));		
		break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
