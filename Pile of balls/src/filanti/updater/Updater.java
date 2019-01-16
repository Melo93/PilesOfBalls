package filanti.updater;

import filanti.core.GameManager;

public class Updater extends Thread {
	
	
	@Override
	public void run() {
		super.run();
		while(true) {
			try {
				GameManager.getInstance().print();
				GameManager.getInstance().update();
				sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	

}
