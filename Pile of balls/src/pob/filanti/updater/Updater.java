package pob.filanti.updater;

import pob.filanti.core.GameConfig;
import pob.filanti.core.GameManager;
import pob.filanti.gui.PlayPanel;

public class Updater extends Thread {
	
	private PlayPanel pp;
	
	
	public Updater(PlayPanel pp) {
		this.pp=pp;
	}
	
	@Override
	public void run() {
		super.run();
		while(!stopTrisBalls()) {
			try {
				GameManager.getInstance().update();
				pp.repaint();
				sleep(800);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public boolean stopMoveLeftTrisBalls() {
		if(GameManager.getInstance().getCurrent().getB3().getCenter().y>=GameConfig.LEFT | GameManager.getInstance().getCurrent().getB2().getCenter().y>=GameConfig.LEFT | GameManager.getInstance().getCurrent().getB1().getCenter().y>=GameConfig.LEFT) {
			return false;
		}
		return true;
	}
	
	public boolean stopTrisBalls() {
		if(GameManager.getInstance().getCurrent().getB3().getCenter().y>=GameConfig.FLOOR | GameManager.getInstance().getCurrent().getB2().getCenter().y>=GameConfig.FLOOR | GameManager.getInstance().getCurrent().getB1().getCenter().y>=GameConfig.FLOOR) {
			return true;
		}
		return false;
	}
}
