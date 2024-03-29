package filanti.dlv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import filanti.core.Ball;
import filanti.core.GameManager;
import filanti.core.TrisBalls;
import it.unical.mat.embasp.base.Handler;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.languages.asp.ASPInputProgram;
import it.unical.mat.embasp.languages.asp.ASPMapper;
import it.unical.mat.embasp.languages.asp.AnswerSet;
import it.unical.mat.embasp.languages.asp.AnswerSets;
import it.unical.mat.embasp.platforms.desktop.DesktopHandler;
import it.unical.mat.embasp.specializations.dlv.desktop.DLVDesktopService;

public class DLVMain {

	private static Handler handler;
	private static String encodingResource="encodings/regole";
	private int xMediaFinal;
	private int rotationFInal;
	private List<BestPositionFinalDlv> bpf=new ArrayList<>(); 
	private List<FinalPositionCurrentDlv> fptc=new ArrayList<>(); 

	public void dlv(){

		handler=new DesktopHandler(new DLVDesktopService("lib/dlv.mingw.exe"));
		InputProgram fact = new ASPInputProgram();


//		for(Ball b:GameManager.getInstance().getBalls()) {
//			if(!b.isTrisball()) {
//				try {
//					fact.addObjectInput(new BallDLV(b.x, b.y, b.getColor()));
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
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

		for(FinalPositionCurrentDlv fpc:fptc) {
			for(int i=11;i<28;i++) {
				for(int j=1;j<7;j++) {
					try {
						fact.addObjectInput(findPossiblePositionNext(i,j,fpc));

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		}
		System.out.println(fact.getPrograms().toString());
		InputProgram encoding= new ASPInputProgram();
		encoding.addFilesPath(encodingResource);
		encoding.addProgram(getEncodings(encodingResource));
		handler.addProgram(fact);
		handler.addProgram(encoding);

		try {
			ASPMapper.getInstance().registerClass(BestPositionFinalDlv.class);

		} catch (Exception e) {
			e.printStackTrace();
		}


		Output o = handler.startSync();

		AnswerSets answers= (AnswerSets) o;
		for(AnswerSet a:answers.getAnswersets()) {
			try {
				for(Object obj:a.getAtoms()) {
					if(obj instanceof BestPositionFinalDlv) {
						BestPositionFinalDlv tb=(BestPositionFinalDlv) obj;
						//System.out.println(tb.toString());
						bpf.add(tb);
					}

				}
				//System.out.println();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}

		xMediaFinal=bpf.get(0).getXM();
		rotationFInal=bpf.get(0).getR();
		System.out.println(answers.getAnswersets().size());

	}


	public int getxMediaFinal() {
		return xMediaFinal;
	}

	public void setxMediaFinal(int xMediaFinal) {
		this.xMediaFinal = xMediaFinal;
	}

	public int getRotationFInal() {
		return rotationFInal;
	}

	public void setRotationFInal(int rotationFInal) {
		this.rotationFInal = rotationFInal;
	}

	private FinalPositionCurrentDlv findPossiblePosition(int xmedia, int rotation) {
		TrisBalls t=new TrisBalls();
		t.initTrisBall();
		CopyOnWriteArrayList<Ball> ball=new CopyOnWriteArrayList<>();
		int tempScore=0;
		int equalsColorBall = 0; 
	
		t.getB1().x=xmedia;
		t.getB2().x=xmedia-1;
		t.getB3().x=xmedia+1;
		t.getB1().setColor(GameManager.getInstance().getCurrent().getB1().getColor());
		t.getB2().setColor(GameManager.getInstance().getCurrent().getB2().getColor());
		t.getB3().setColor(GameManager.getInstance().getCurrent().getB3().getColor());

		ball.add(t.getB1());
		ball.add(t.getB2());
		ball.add(t.getB3());

		for(Ball b:GameManager.getInstance().getBalls()) {
			if(!b.isTrisball()) {
				ball.add(b.clone());
			}
		}

		//		System.out.println(t + " " + ball);
		//		System.out.println();



		while (t.getRotate()!=rotation) {
			if(rotation==1) {
				continue;
			}
			t.setRotate(t.getRotate()+1);
			t.rotateLeft();

		}

		while(!t.getB1().posizioneFinaleTrovata(ball) || !t.getB2().posizioneFinaleTrovata(ball)||!t.getB3().posizioneFinaleTrovata(ball) ) {
			t.update(ball);
		}
		for(Ball b: ball) {
			CopyOnWriteArrayList<Ball> controllate = new CopyOnWriteArrayList<>();
			CopyOnWriteArrayList<Ball> daControllare = new CopyOnWriteArrayList<>();
			daControllare.add(b);
			if(b.cercaUguali(b, ball, controllate, daControllare)) {
				if(controllate.size() >= 4) {
					tempScore+=controllate.size();
				}
				equalsColorBall += controllate.size();
			}
			
		}

		fptc.add(new FinalPositionCurrentDlv(t.getB1().x,t.getB1().y,t.getB1().getColor(),
				t.getB2().x,t.getB2().y,t.getB2().getColor(),
				t.getB3().x,t.getB3().y,t.getB3().getColor(),
				xmedia, rotation,tempScore,equalsColorBall));

		return new FinalPositionCurrentDlv(t.getB1().x,t.getB1().y,t.getB1().getColor(),
				t.getB2().x,t.getB2().y,t.getB2().getColor(),
				t.getB3().x,t.getB3().y,t.getB3().getColor(),
				xmedia, rotation,tempScore,equalsColorBall);
	}

	private FinalPositionNextDlv findPossiblePositionNext(int xmedia, int rotation, FinalPositionCurrentDlv current) {
		TrisBalls t=new TrisBalls();
		t.initTrisBall();
		CopyOnWriteArrayList<Ball> ball=new CopyOnWriteArrayList<>();
		int tempScore=0;
		int equalsColorBall=0;
		
		t.getB1().x=xmedia;
		t.getB2().x=xmedia-1;
		t.getB3().x=xmedia+1;
		t.getB1().setColor(GameManager.getInstance().getNext().getB1().getColor());
		t.getB2().setColor(GameManager.getInstance().getNext().getB2().getColor());
		t.getB3().setColor(GameManager.getInstance().getNext().getB3().getColor());

		Ball temp1=new Ball(current.getC1(), current.getX1(), current.getY1());
		Ball temp2=new Ball(current.getC2(), current.getX2(), current.getY2());
		Ball temp3=new Ball(current.getC3(), current.getX3(), current.getY3());
		
		temp1.setTrisball(false);
		temp2.setTrisball(false);
		temp3.setTrisball(false);
		
		ball.add(t.getB1());
		ball.add(t.getB2());
		ball.add(t.getB3());
		ball.add(temp1);
		ball.add(temp2);
		ball.add(temp3);

		for(Ball b:GameManager.getInstance().getBalls()) {
			if(!b.isTrisball()) {
				ball.add(b.clone());
			}
		}

		//	System.out.println(t + " " + ball);
		//	System.out.println();



		while (t.getRotate()!=rotation) {
			if(rotation==1) {
				continue;
			}
			t.setRotate(t.getRotate()+1);
			t.rotateLeft();

		}

		while(!t.getB1().posizioneFinaleTrovata(ball) || !t.getB2().posizioneFinaleTrovata(ball)||!t.getB3().posizioneFinaleTrovata(ball) ) {
			t.update(ball);
		}
		for(Ball b: ball) {
			CopyOnWriteArrayList<Ball> controllate = new CopyOnWriteArrayList<>();
			CopyOnWriteArrayList<Ball> daControllare = new CopyOnWriteArrayList<>();
			daControllare.add(b);
			if(b.cercaUguali(b, ball, controllate, daControllare)) {
				if(controllate.size() >= 4) {
					tempScore+=controllate.size();
				}
				equalsColorBall += controllate.size();
			}


		}

			return new FinalPositionNextDlv(t.getB1().x,t.getB1().y,t.getB1().getColor(),
					t.getB2().x,t.getB2().y,t.getB2().getColor(),
					t.getB3().x,t.getB3().y,t.getB3().getColor(),
					xmedia, rotation,tempScore,equalsColorBall);


	}


	//	private static int xMedia() {
	//		return (GameManager.getInstance().getCurrent().getB1().x+
	//				GameManager.getInstance().getCurrent().getB2().x+
	//				GameManager.getInstance().getCurrent().getB3().x)/3;
	//	}

	private static String getEncodings(String encodingResource2) {
		BufferedReader reader;
		StringBuilder builder = new StringBuilder();
		try {
			reader = new BufferedReader(new FileReader(encodingResource));
			String line = "";
			while ((line = reader.readLine()) != null) {
				builder.append(line);
				builder.append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return builder.toString();
	}


}
