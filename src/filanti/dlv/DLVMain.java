package filanti.dlv;

import java.util.concurrent.CopyOnWriteArrayList;


import filanti.core.Ball;
import filanti.core.GameManager;
import filanti.core.TrisBalls;
import it.unical.mat.embasp.base.Handler;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.languages.asp.ASPInputProgram;
import it.unical.mat.embasp.languages.asp.AnswerSet;
import it.unical.mat.embasp.languages.asp.AnswerSets;
import it.unical.mat.embasp.platforms.desktop.DesktopHandler;
import it.unical.mat.embasp.specializations.dlv.desktop.DLVDesktopService;

public class DLVMain {

	private static Handler handler;
	
	public void dlv(){
		
		GameManager.getInstance();
		
		handler=new DesktopHandler(new DLVDesktopService("lib/dlv.mingw.exe"));
		InputProgram fact = new ASPInputProgram();
		
		try {
			fact.addObjectInput(new TrisballDlv(DLVMain.xMedia(), GameManager.getInstance().getCurrent().getRotateLeft(),
					GameManager.getInstance().getCurrent().getB1().getColor(),GameManager.getInstance().getCurrent().getB2().getColor(),
					GameManager.getInstance().getCurrent().getB3().getColor()));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(Ball b:GameManager.getInstance().getBalls()) {
			if(!b.isTrisball()) {
				try {
					fact.addObjectInput(new BallDLV(b.x, b.y, b.getColor()));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		for(int i=11;i<28;i++) {
			for(int j=1;j<7;j++) {
				try {
					fact.addObjectInput(findPossiblePosition(i,j));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		handler.addProgram(fact);
		
		Output o = handler.startSync();
		
		AnswerSets answers= (AnswerSets) o;
		for(AnswerSet a:answers.getAnswersets()) {
			try {
				for(Object obj:a.getAtoms()) {
					if(obj instanceof TrisballDlv) {
						TrisballDlv tb=(TrisballDlv) obj;
						System.out.println(tb.toString());
					}
					else if(obj instanceof BallDLV) {
						BallDLV b=(BallDLV) obj;
						System.out.println(b.toString());
					}
					else if(obj instanceof FinalPositionDlv) {
						FinalPositionDlv fp= (FinalPositionDlv) obj;
						System.out.println(fp.toString());
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
	}
	
	private FinalPositionDlv findPossiblePosition(int xmedia, int rotation) {
		TrisBalls t=new TrisBalls();
		t.initTrisBall();
		CopyOnWriteArrayList<Ball> ball=new CopyOnWriteArrayList<>();
		ball.addAll(GameManager.getInstance().getBalls());
		
		t.getB1().x=xmedia;
		t.getB2().x=xmedia-1;
		t.getB3().x=xmedia+1;
		t.getB1().setColor(GameManager.getInstance().getCurrent().getB1().getColor());
		t.getB2().setColor(GameManager.getInstance().getCurrent().getB2().getColor());
		t.getB3().setColor(GameManager.getInstance().getCurrent().getB3().getColor());
		
		t.setRotateLeft(rotation);
		if(rotation!=1) t.rotateLeft();
		
		while(!t.getB1().posizioneFinaleTrovata(ball) || !t.getB2().posizioneFinaleTrovata(ball)||!t.getB3().posizioneFinaleTrovata(ball) ) {
			t.update(ball);
		}
		
		return new FinalPositionDlv(new BallDLV(t.getB1().x,t.getB1().y,t.getB1().getColor()),
									new BallDLV(t.getB2().x,t.getB2().y,t.getB2().getColor()),
									new BallDLV(t.getB3().x,t.getB3().y,t.getB3().getColor()));
	}

	private static int xMedia() {
		return (GameManager.getInstance().getCurrent().getB1().x+
				GameManager.getInstance().getCurrent().getB2().x+
				GameManager.getInstance().getCurrent().getB3().x)/3;
	}

}
