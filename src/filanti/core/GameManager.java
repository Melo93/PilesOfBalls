package filanti.core;

import java.util.concurrent.CopyOnWriteArrayList;

public class GameManager {
	private static GameManager instance;
	private TrisBalls current;
	private TrisBalls next;
	private CopyOnWriteArrayList<Ball> balls;
	private int score;
	
	public static GameManager getInstance() {
		if(instance==null) {
			instance=new GameManager();
		}
		return instance;
	}
	
	private GameManager() {
		balls=new CopyOnWriteArrayList<Ball>();
		current=new TrisBalls();
		current.initTrisBall();
		balls.add(current.getB1());
		balls.add(current.getB2());
		balls.add(current.getB3());
		next=new TrisBalls();
		score=0;
	}
	
	public void update() {
//		if(current.getB1().posizioneFinaleTrovata(balls) && current.getB2().posizioneFinaleTrovata(balls) && current.getB3().posizioneFinaleTrovata(balls)) {
//			chiamaScoppia();
//			boolean andiamoAvanti = false;
//			while(!andiamoAvanti) {
//				for(Ball b : balls) {
//					b.findPosition(balls);
//				}
//				chiamaScoppia();
//				if(vadaAvanti()) {andiamoAvanti = true;}
//			}
////			chiamaScoppia();
////			while(!vadaAvanti()) {
////				for(Ball b: balls) {
////					b.findPosition(balls);
////				}
////				chiamaScoppia();
////				vadaAvanti();
////			}
//			change();
//		}
////			boolean andiamoAvanti = false; 
////			while(!andiamoAvanti) {
////				for(Ball b: balls) {
////					b.setStop(false);
////					b.findPosition(balls);
////				}
////				boolean flagPalline = true;
////				for(Ball b: balls) {
////					if(!b.checkCollision(balls)) {
////						andiamoAvanti = false; 
////					}
////				}
////				boolean nonScoppio = true;
////				for(Ball b: balls) {
////					if(b.scoppia(balls)) {
////						nonScoppio = false;
////					}
////				}
////				if(flagPalline && nonScoppio) {
////					andiamoAvanti = true;
////				}
////			}
//
//		else {
//			current.update(balls);
//			System.out.println(balls.toString());
//		}
	}
//	public void chiamaScoppia() {
//		for(Ball b: balls) {
//			b.scoppia(balls);
//			
//		}
//	}
	public boolean vadaAvanti() {
		for(Ball b: balls) {
			if(!b.posizioneFinaleTrovata(balls)) {
				return false;
			}
		}
		return true;
	}
	
	public void change() {
		current=next;
		current.initTrisBall();
		balls.add(current.getB1());
		balls.add(current.getB2());
		balls.add(current.getB3());
		next=new TrisBalls();
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	
	
}
