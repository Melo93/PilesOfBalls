package pob.filanti.core;

import java.util.ArrayList;

public class GameManager {
	
	private static GameManager instance;
	
	public static GameManager getInstance() {
		if(instance==null) {
			instance=new GameManager();
		}
		return instance;
	}
	
	private TrisBalls current;
	private TrisBalls nextTris;
	private ArrayList<Ball> balls;
	
	public void clear() {
		current=null;
		current=new TrisBalls(1);
		balls=new ArrayList <>();
	}
	
//	37x 115y
	
	private GameManager() {
		current=new TrisBalls(1);
		nextTris=new TrisBalls(0);
	}
	
	public TrisBalls getCurrent() {
		return current;
	}
	
	

	public TrisBalls getNextTris() {
		return nextTris;
	}

	public void update() {
		current.update();
		if(!current.canMove()) {
			balls.add(current.getB1());
			balls.add(current.getB2());
			balls.add(current.getB3());
			current=null;
		}
	}

	
}
