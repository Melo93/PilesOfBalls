package filanti.controller;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import filanti.core.GameManager;
import filanti.gui.PlayPanel;



public class MouseManager implements MouseListener, MouseMotionListener{
	private PlayPanel pp;

	public MouseManager(PlayPanel p) {
		this.pp = p;
	}

	//	public void mouseClickedLeft() {
	//		GameManager.getInstance().getCurrent().getB1().setCenter(new Point(GameManager.getInstance().getCurrent().getB1().getCenter().x-1,GameManager.getInstance().getCurrent().getB1().getCenter().y));
	//		GameManager.getInstance().getCurrent().getB2().setCenter(new Point(GameManager.getInstance().getCurrent().getB2().getCenter().x-1,GameManager.getInstance().getCurrent().getB2().getCenter().y));
	//		GameManager.getInstance().getCurrent().getB3().setCenter(new Point(GameManager.getInstance().getCurrent().getB3().getCenter().x-1,GameManager.getInstance().getCurrent().getB3().getCenter().y));
	//	}
	//	
	//	public void mouseClickedRight() {
	//		GameManager.getInstance().getCurrent().getB1().setCenter(new Point(GameManager.getInstance().getCurrent().getB1().getCenter().x+1,GameManager.getInstance().getCurrent().getB1().getCenter().y));
	//		GameManager.getInstance().getCurrent().getB2().setCenter(new Point(GameManager.getInstance().getCurrent().getB2().getCenter().x+1,GameManager.getInstance().getCurrent().getB2().getCenter().y));
	//		GameManager.getInstance().getCurrent().getB3().setCenter(new Point(GameManager.getInstance().getCurrent().getB3().getCenter().x+1,GameManager.getInstance().getCurrent().getB3().getCenter().y));
	//	}
	//
	//	public void mouseClickedRoundLeftButton() {
	//		if(GameManager.getInstance().getCurrent().getPositionLeft()>6) {
	//			GameManager.getInstance().getCurrent().setPositionLeft(1);
	//		}
	//		GameManager.getInstance().getCurrent().setPositionLeft(GameManager.getInstance().getCurrent().getPositionLeft()+1);
	//		GameManager.getInstance().getCurrent().setPositionRight(7-GameManager.getInstance().getCurrent().getPositionLeft()+1);
	//		GameManager.getInstance().getCurrent().rotateLeft();
	//		System.out.println(GameManager.getInstance().getCurrent().toString());
	//	}
	//
	//	public void mouseClickedRoundRightButton() {
	//		if(GameManager.getInstance().getCurrent().getPositionRight()>6) {
	//			GameManager.getInstance().getCurrent().setPositionRight(1);
	//		}
	//		GameManager.getInstance().getCurrent().setPositionRight(GameManager.getInstance().getCurrent().getPositionRight()+1);
	//		GameManager.getInstance().getCurrent().setPositionLeft(7-GameManager.getInstance().getCurrent().getPositionRight()+1);
	//		GameManager.getInstance().getCurrent().rotateRight();
	//		System.out.println(GameManager.getInstance().getCurrent().toString());
	//	}
	//
	//	public void mouseClickedSpeedButton() {
	//		GameManager.getInstance().getCurrent().setSpeed(3);
	//	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		pp.requestFocus();

		if(e.getSource()==pp.getLeftButton()) {
			GameManager.getInstance().getCurrent().getB1().setCenter(new Point(GameManager.getInstance().getCurrent().getB1().getCenter().x-1,GameManager.getInstance().getCurrent().getB1().getCenter().y));
			GameManager.getInstance().getCurrent().getB2().setCenter(new Point(GameManager.getInstance().getCurrent().getB2().getCenter().x-1,GameManager.getInstance().getCurrent().getB2().getCenter().y));
			GameManager.getInstance().getCurrent().getB3().setCenter(new Point(GameManager.getInstance().getCurrent().getB3().getCenter().x-1,GameManager.getInstance().getCurrent().getB3().getCenter().y));

		}
		else if(e.getSource()==pp.getRightButton()) {
			GameManager.getInstance().getCurrent().getB1().setCenter(new Point(GameManager.getInstance().getCurrent().getB1().getCenter().x+1,GameManager.getInstance().getCurrent().getB1().getCenter().y));
			GameManager.getInstance().getCurrent().getB2().setCenter(new Point(GameManager.getInstance().getCurrent().getB2().getCenter().x+1,GameManager.getInstance().getCurrent().getB2().getCenter().y));
			GameManager.getInstance().getCurrent().getB3().setCenter(new Point(GameManager.getInstance().getCurrent().getB3().getCenter().x+1,GameManager.getInstance().getCurrent().getB3().getCenter().y));

		}

//		else if(e.getSource()==pp.getRoundRightButton()) {
//			if(GameManager.getInstance().getCurrent().getPositionRight()>6) {
//				GameManager.getInstance().getCurrent().setPositionRight(1);
//			}
//			GameManager.getInstance().getCurrent().setPositionRight(GameManager.getInstance().getCurrent().getPositionRight()+1);
//			GameManager.getInstance().getCurrent().setPositionLeft(7-GameManager.getInstance().getCurrent().getPositionRight()+1);
//			GameManager.getInstance().getCurrent().rotateRight();
//			System.out.println(GameManager.getInstance().getCurrent().toString());
//		}
//
//		else if(e.getSource()==pp.getRoundLeftButton()) {
//			if(GameManager.getInstance().getCurrent().getPositionLeft()>6) {
//				GameManager.getInstance().getCurrent().setPositionLeft(1);
//			}
//			GameManager.getInstance().getCurrent().setPositionLeft(GameManager.getInstance().getCurrent().getPositionLeft()+1);
//			GameManager.getInstance().getCurrent().setPositionRight(7-GameManager.getInstance().getCurrent().getPositionLeft()+1);
//			GameManager.getInstance().getCurrent().rotateLeft();
//			System.out.println(GameManager.getInstance().getCurrent().toString());
//		}


	}

	@Override
	public void mousePressed(MouseEvent e) {
//		pp.requestFocus();
//		if(e.getSource()==pp.getSpeedButton()) {
//			GameManager.getInstance().getCurrent().setSpeed(3);
//		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
//		pp.requestFocus();
//		if(e.getSource()==pp.getSpeedButton()) {
//			GameManager.getInstance().getCurrent().setSpeed(1);
//		}
//
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}


}
