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
		while((GameManager.getInstance().getCurrent().getB3().getCenter().y<GameConfig.FLOOR)) {
			try {
				GameManager.getInstance().update();
				pp.repaint();
				sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
