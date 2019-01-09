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
		while(true) {
			try {
				GameManager.getInstance().update();
				pp.repaint();
				sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	

}
