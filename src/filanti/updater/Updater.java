package filanti.updater;

import java.awt.Point;

import filanti.core.Ball;
import filanti.core.GameManager;
import filanti.dlv.DLVMain;
import filanti.gui.PlayPanel;

public class Updater extends Thread {
	PlayPanel pp;
	DLVMain dlv;
	boolean callDLV;
	boolean stop;

	public Updater(PlayPanel pp) {
		this.pp=pp;
		callDLV=false;
		stop=false;

	}

	@Override
	public void run() {
		super.run();
		while(true) {
			try {
				if(!stop) {

					//				GameManager.getInstance().print();
					//				pp.repaint();
					//GameManager.getInstance().update();
					if(GameManager.getInstance().getCurrent().getB1().posizioneFinaleTrovata(GameManager.getInstance().getBalls()) && GameManager.getInstance().getCurrent().getB2().posizioneFinaleTrovata(GameManager.getInstance().getBalls()) && GameManager.getInstance().getCurrent().getB3().posizioneFinaleTrovata(GameManager.getInstance().getBalls())) {
						for(Ball b:GameManager.getInstance().getBalls()) {
							b.scoppia(GameManager.getInstance().getBalls());
							sleep(10);
							pp.repaint();
						}
						pp.repaint();
						//GameManager.getInstance().chiamaScoppia();
						boolean andiamoAvanti = false;
						while(!andiamoAvanti) {

							for(Ball b : GameManager.getInstance().getBalls()) {
								b.findPosition(GameManager.getInstance().getBalls());
								sleep(10);
								pp.repaint();
							}
							for(Ball b:GameManager.getInstance().getBalls()) {
								b.scoppia(GameManager.getInstance().getBalls());
								sleep(10);
								pp.repaint();
							}
							pp.repaint();
							//GameManager.getInstance().chiamaScoppia();
							if(GameManager.getInstance().vadaAvanti()) {andiamoAvanti = true;}
						}
						GameManager.getInstance().change();
						callDLV=false;
						pp.repaint();
					}
					else {
						if(!callDLV) {
							dlv=new DLVMain();					
							dlv.dlv();
							spostaTris();
							callDLV=true;
						}
						//					System.out.println(GameManager.getInstance().getCurrent() + " " + GameManager.getInstance().getBalls());
						GameManager.getInstance().getCurrent().update(GameManager.getInstance().getBalls());
						pp.repaint();
					}
					sleep(30);

				}
				pp.repaint();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void spostaTris() {
		while(GameManager.getInstance().getCurrent().getRotate() != dlv.getRotationFInal()) {
			GameManager.getInstance().getCurrent().setRotate(GameManager.getInstance().getCurrent().getRotate()+1);
			GameManager.getInstance().getCurrent().rotateLeft();

			try {
				sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pp.repaint();
		}
		while(xMedia() != dlv.getxMediaFinal()) {
			if(dlv.getxMediaFinal()<19) {
				GameManager.getInstance().getCurrent().getB1().translate(-1, 0);
				GameManager.getInstance().getCurrent().getB2().translate(-1, 0);
				GameManager.getInstance().getCurrent().getB3().translate(-1, 0);
				GameManager.getInstance().getCurrent().getB1().setCenter(new Point(GameManager.getInstance().getCurrent().getB1().getCenter().x-1,GameManager.getInstance().getCurrent().getB1().getCenter().y));
				GameManager.getInstance().getCurrent().getB2().setCenter(new Point(GameManager.getInstance().getCurrent().getB2().getCenter().x-1,GameManager.getInstance().getCurrent().getB2().getCenter().y));
				GameManager.getInstance().getCurrent().getB3().setCenter(new Point(GameManager.getInstance().getCurrent().getB3().getCenter().x-1,GameManager.getInstance().getCurrent().getB3().getCenter().y));
			}
			else if(dlv.getxMediaFinal()>19) {
				GameManager.getInstance().getCurrent().getB1().translate(+1, 0);
				GameManager.getInstance().getCurrent().getB2().translate(+1, 0);
				GameManager.getInstance().getCurrent().getB3().translate(+1, 0);
				GameManager.getInstance().getCurrent().getB1().setCenter(new Point(GameManager.getInstance().getCurrent().getB1().getCenter().x+1,GameManager.getInstance().getCurrent().getB1().getCenter().y));
				GameManager.getInstance().getCurrent().getB2().setCenter(new Point(GameManager.getInstance().getCurrent().getB2().getCenter().x+1,GameManager.getInstance().getCurrent().getB2().getCenter().y));
				GameManager.getInstance().getCurrent().getB3().setCenter(new Point(GameManager.getInstance().getCurrent().getB3().getCenter().x+1,GameManager.getInstance().getCurrent().getB3().getCenter().y));
			}

			try {
				sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pp.repaint();
		}
	}

	private int xMedia() {
		return (GameManager.getInstance().getCurrent().getB1().x+
				GameManager.getInstance().getCurrent().getB2().x+
				GameManager.getInstance().getCurrent().getB3().x)/3;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	

}
