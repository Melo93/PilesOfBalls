package filanti.core;

import java.util.ArrayList;

import filanti.updater.Updater;
/*
 * 1)accertata collisione
 * 2)scoperta di chi si è permesso
 * 3)chi si è permesso avrà il lock sulla nuova posizione giusta
 * 4)controllo collisione altre palline, nel caso di non collisione, discesa
 */
public class GameManager {
	private static GameManager instance;

	public static GameManager getInstance() {
		if(instance==null) {
			instance=new GameManager();
		}
		return instance;
	}
	
//	private Board board;
	private TrisBalls current;
	private TrisBalls next;
	private ArrayList<Ball> balls;

	
	
	private GameManager() {
//		board=new Board();
		balls=new ArrayList<>();
		current=new TrisBalls(1);
		balls.add(current.getB1());
		balls.add(current.getB2());
		balls.add(current.getB3());
		next=new TrisBalls(0);
		
	}
	
	public void update() {
		current.update(balls);
		if(current.getB1().isStop()&&current.getB2().isStop()&&current.getB3().isStop())	change();
	}



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

	public ArrayList<Ball> getBalls() {
		return balls;
	}

	public void setBalls(ArrayList<Ball> balls) {
		this.balls = balls;
	}
	
	
	
}
