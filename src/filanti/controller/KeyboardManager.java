package filanti.controller;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import filanti.core.GameManager;
import filanti.gui.PlayPanel;
import filanti.updater.Updater;


public class KeyboardManager implements KeyListener{

	private PlayPanel pp;

	public KeyboardManager(PlayPanel p) {
		this.pp=p;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		e.toString();
		pp.requestFocus();
		switch(e.getKeyCode()) {

		case KeyEvent.VK_LEFT:
			if(GameManager.getInstance().getCurrent().getB1().x-1>=10 && GameManager.getInstance().getCurrent().getB2().x-1>=10 && GameManager.getInstance().getCurrent().getB3().x-1>=10) {
				if(GameManager.getInstance().getCurrent().getB1().isTrisball() && GameManager.getInstance().getCurrent().getB2().isTrisball() && GameManager.getInstance().getCurrent().getB3().isTrisball()) {
					GameManager.getInstance().getCurrent().getB1().setCenter(new Point(GameManager.getInstance().getCurrent().getB1().getCenter().x-1,GameManager.getInstance().getCurrent().getB1().getCenter().y));
					GameManager.getInstance().getCurrent().getB1().translate(-1, 0);
					GameManager.getInstance().getCurrent().getB2().setCenter(new Point(GameManager.getInstance().getCurrent().getB2().getCenter().x-1,GameManager.getInstance().getCurrent().getB2().getCenter().y));
					GameManager.getInstance().getCurrent().getB2().translate(-1, 0);
					GameManager.getInstance().getCurrent().getB3().setCenter(new Point(GameManager.getInstance().getCurrent().getB3().getCenter().x-1,GameManager.getInstance().getCurrent().getB3().getCenter().y));
					GameManager.getInstance().getCurrent().getB3().translate(-1, 0);
				}
			}
			break;

		case KeyEvent.VK_RIGHT:
			if(GameManager.getInstance().getCurrent().getB1().x+1<=28 && GameManager.getInstance().getCurrent().getB2().x+1<=28 && GameManager.getInstance().getCurrent().getB3().x+1<=28) {
				if(GameManager.getInstance().getCurrent().getB1().isTrisball() && GameManager.getInstance().getCurrent().getB2().isTrisball() && GameManager.getInstance().getCurrent().getB3().isTrisball()) {
					GameManager.getInstance().getCurrent().getB1().setCenter(new Point(GameManager.getInstance().getCurrent().getB1().getCenter().x+1,GameManager.getInstance().getCurrent().getB1().getCenter().y));
					GameManager.getInstance().getCurrent().getB1().translate(+1, 0);
					GameManager.getInstance().getCurrent().getB2().setCenter(new Point(GameManager.getInstance().getCurrent().getB2().getCenter().x+1,GameManager.getInstance().getCurrent().getB2().getCenter().y));
					GameManager.getInstance().getCurrent().getB2().translate(+1, 0);
					GameManager.getInstance().getCurrent().getB3().setCenter(new Point(GameManager.getInstance().getCurrent().getB3().getCenter().x+1,GameManager.getInstance().getCurrent().getB3().getCenter().y));
					GameManager.getInstance().getCurrent().getB3().translate(+1, 0);
				}
			}
			break;


		case KeyEvent.VK_UP:
			if(GameManager.getInstance().getCurrent().getB1().isTrisball() && GameManager.getInstance().getCurrent().getB2().isTrisball() && GameManager.getInstance().getCurrent().getB3().isTrisball()) {
				if(GameManager.getInstance().getCurrent().getRotate()>=7) {
					GameManager.getInstance().getCurrent().setRotate(1);
				}
				//				if(GameManager.getInstance().getCurrent().getRotateRight()<=1) {
				//					GameManager.getInstance().getCurrent().setRotateRight(7);
				//				}
				GameManager.getInstance().getCurrent().setRotate(GameManager.getInstance().getCurrent().getRotate()+1);
				//				GameManager.getInstance().getCurrent().setRotateRight(GameManager.getInstance().getCurrent().getRotateRight()-1);
				GameManager.getInstance().getCurrent().rotateLeft();
			}
			break;
		case KeyEvent.VK_ESCAPE:
			pp.getUpdate().setStop(true);
			break;
		case KeyEvent.VK_ENTER:
			pp.getUpdate().setStop(false);
			break;

			//		case KeyEvent.VK_DOWN:
			//			if(GameManager.getInstance().getCurrent().getB1().isTrisball() && GameManager.getInstance().getCurrent().getB2().isTrisball() && GameManager.getInstance().getCurrent().getB3().isTrisball()) {
			//				if(GameManager.getInstance().getCurrent().getRotateLeft()<=1) {
			//					GameManager.getInstance().getCurrent().setRotateLeft(7);
			//				}
			//				if(GameManager.getInstance().getCurrent().getRotateRight()>=7) {
			//					GameManager.getInstance().getCurrent().setRotateRight(1);
			//				}
			//				GameManager.getInstance().getCurrent().setRotateLeft(GameManager.getInstance().getCurrent().getRotateLeft()-1);
			//				GameManager.getInstance().getCurrent().setRotateRight(GameManager.getInstance().getCurrent().getRotateRight()+1);
			//				GameManager.getInstance().getCurrent().rotateRight();
			//				System.out.println(GameManager.getInstance().getCurrent().toString());
			//			}
			//			break;	
			//		case KeyEvent.VK_SPACE:
			//			GameManager.getInstance().getCurrent().setSpeed(3);
			//			break;
			//
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		//		switch(e.getKeyCode()) {
		//		case KeyEvent.VK_SPACE:
		//			GameManager.getInstance().getCurrent().setSpeed(1);
		//			break;
		//		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
