package filanti.updater;

import filanti.core.Ball;
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
				//pp.repaint();
				//GameManager.getInstance().update();
				if(GameManager.getInstance().getCurrent().getB1().posizioneFinaleTrovata(GameManager.getInstance().getBalls()) && GameManager.getInstance().getCurrent().getB2().posizioneFinaleTrovata(GameManager.getInstance().getBalls()) && GameManager.getInstance().getCurrent().getB3().posizioneFinaleTrovata(GameManager.getInstance().getBalls())) {
					for(Ball b:GameManager.getInstance().getBalls()) {
						b.scoppia(GameManager.getInstance().getBalls());
//						sleep(100);
						pp.repaint();
					}
//					pp.repaint();
					//GameManager.getInstance().chiamaScoppia();
					boolean andiamoAvanti = false;
					while(!andiamoAvanti) {
						
						for(Ball b : GameManager.getInstance().getBalls()) {
							b.findPosition(GameManager.getInstance().getBalls());
							sleep(20);
							pp.repaint();
						}
						for(Ball b:GameManager.getInstance().getBalls()) {
							b.scoppia(GameManager.getInstance().getBalls());
//							sleep(10);
							pp.repaint();
						}
//						pp.repaint();
						//GameManager.getInstance().chiamaScoppia();
						if(GameManager.getInstance().vadaAvanti()) {andiamoAvanti = true;}
					}
					GameManager.getInstance().change();
					pp.repaint();
				}
				else {
					GameManager.getInstance().getCurrent().update(GameManager.getInstance().getBalls());
					pp.repaint();
				}
				sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	

}
