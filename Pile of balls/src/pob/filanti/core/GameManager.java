package pob.filanti.core;

import java.awt.Point;
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



	public ArrayList<Ball> getBalls() {
		return balls;
	}


	public void update() {
		current.update();
		if(!current.canMove()) {
			if(checkCollision()!=null) {
				if(current.getB1().getCenter().x<=checkCollision().getCenter().x)
					current.getB1().setCenter(new Point(current.getB1().getCenter().x-1, current.getB1().getCenter().y+1));
				else if(current.getB1().getCenter().x>checkCollision().getCenter().x) {
					current.getB1().setCenter(new Point(current.getB1().getCenter().x+1, current.getB1().getCenter().y+1));
				}
				if(current.getB2().getCenter().x<=checkCollision().getCenter().x)
					current.getB2().setCenter(new Point(current.getB2().getCenter().x-1, current.getB2().getCenter().y+1));
				else if(current.getB2().getCenter().x>checkCollision().getCenter().x) {
					current.getB2().setCenter(new Point(current.getB2().getCenter().x+1, current.getB2().getCenter().y+1));
				}
				if(current.getB3().getCenter().x<=checkCollision().getCenter().x)
					current.getB3().setCenter(new Point(current.getB3().getCenter().x-1, current.getB3().getCenter().y+1));
				else if(current.getB3().getCenter().x>checkCollision().getCenter().x) {
					current.getB3().setCenter(new Point(current.getB3().getCenter().x+1, current.getB3().getCenter().y+1));
				}
			}
			balls.add(current.getB1());
			balls.add(current.getB2());
			balls.add(current.getB3());
			current=nextTris;
			current.changeStatus();
			nextTris=new TrisBalls(0);
		}

	}

	private Ball checkCollision() {
		for(Ball b: balls) {
			if(current.getB1().Intersects(b) || current.getB2().Intersects(b) || current.getB3().Intersects(b)) {
				current.setCanMove(false);
				return b;
			}

		}
		current.setCanMove(true);
		return null;
	}


}
