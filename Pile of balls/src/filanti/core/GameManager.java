package filanti.core;

import java.util.concurrent.CopyOnWriteArrayList;
/*
 * 1)accertata collisione
 * 2)scoperta di chi si è permesso
 * 3)chi si è permesso avrà il lock sulla nuova posizione giusta
 * 4)controllo collisione altre palline, nel caso di non collisione, discesa
 */
public class GameManager {
	private static GameManager instance;
	private TrisBalls current;
	private TrisBalls next;
	private CopyOnWriteArrayList<Ball> balls;
	
	public static GameManager getInstance() {
		if(instance==null) {
			instance=new GameManager();
		}
		return instance;
	}

	private GameManager() {
		balls=new CopyOnWriteArrayList();
		current=new TrisBalls(1);
		balls.add(current.getB1());
		balls.add(current.getB2());
		balls.add(current.getB3());
		next=new TrisBalls(0);
		
	}
	
	public void update() {
		current.update(balls);
		if(current.getB1().isStop()&&current.getB2().isStop()&&current.getB3().isStop()) {
			for(Ball b: balls) {
				b.scoppia(balls);
//				//b.pallineDaPosizionare(balls);
//				//b.setStop(false);
			}
			boolean pallineTuttePosizionate = false; 
			while(!pallineTuttePosizionate) {
				for(Ball b: balls) {
					b.pallineDaPosizionare(balls);
					//if(b.y+b.height < 32) {
						if(b.checkCollision2(balls)) {
							pallineTuttePosizionate = false;
						}
					//}
					b.pallineDaPosizionare(balls);
					b.scoppia(balls);
				}
				pallineTuttePosizionate = true;
			
			}
			change();
		}
	}
			//			}
//			do{
////				for()
////					b.scoppia(balls);
////					b.pallineDaPosizionare(balls);
//				for(Ball b: balls) {
//					b.scoppia(balls);
//					b.pallineDaPosizionare(balls);
//					
//				}
//				possibileScoppio();
//				tutteLePallineSistemate();
//			}while(!tutteLePallineSistemate() && !possibileScoppio());
//			
//			change();
//		}
//		
//	}
//	private boolean possibileScoppio() {
//		for(Ball b: balls) {
//			if(b.scoppia(balls)) {
//				return true;
//			}
//		}
//		return false;
//	}
//	private boolean tutteLePallineSistemate() {
//		for(Ball b: balls) {
//			b.pallineDaPosizionare(balls);
//			if(b.y+b.height < 32) {
//				if(!b.checkCollision2(balls)) {
//					return false;
//				}
//			}
//		}
//		return true;
//	}
	
	private void change() {
		current=next;
		current.setStatus(1);
		current.setPositionTrisBall();
		balls.add(current.getB1());
		balls.add(current.getB2());
		balls.add(current.getB3());
		next=new TrisBalls(0);
		
	}

	public void print() {
		System.out.println(current.getB1().toString());
		System.out.println(current.getB2().toString());
		System.out.println(current.getB3().toString());
		
		for(Ball b:balls) {
			System.out.println(b.x + " "+ b.y);
		}
		System.out.println();
	}

	public TrisBalls getCurrent() {
		return current;
	}

	public void setCurrent(TrisBalls current) {
		this.current = current;
	}

	public TrisBalls getNext() {
		return next;
	}

	public void setNext(TrisBalls next) {
		this.next = next;
	}

	public CopyOnWriteArrayList<Ball> getBalls() {
		return balls;
	}

	public void setBalls(CopyOnWriteArrayList<Ball> balls) {
		this.balls = balls;
	}	
}
