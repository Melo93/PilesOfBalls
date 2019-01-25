package filanti.updater;

import filanti.core.GameManager;
import filanti.gui.PlayPanel;

public class Updater extends Thread {
	PlayPanel pp;
	
	public Updater(PlayPanel pp) {
		this.pp=pp;
	}
	
	@Override
	public void run() {
		super.run();
		while(true) {
			try {
				//GameManager.getInstance().print();
				pp.repaint();
				GameManager.getInstance().update();
				sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	

}
