package pob.filanti.core;

import java.awt.Point;
import java.util.Random;

public class TrisBalls {
	private Ball b1;
	private Ball b2;
	private Ball b3;
	
	public TrisBalls() {
		b1=new Ball(new Random().nextInt(3),20,2);
		b2=new Ball(new Random().nextInt(3),19,4);
		b3=new Ball(new Random().nextInt(3),21,4);
	}

	public Ball getB1() {
		return b1; 
	}

	public Ball getB2() {
		return b2;
	}


	public Ball getB3() {
		return b3;
	}

	@Override
	public String toString() {
		return "TrisBalls [b1 x=" + b1.getCenter().x + " b1 y=" + b1.getCenter().y +", b2 x=" + b2.getCenter().x +", b2 y="+ b2.getCenter().y +
				", b3 x=" + b3.getCenter().x + ", b3 y="+b3.getCenter().y +"]";
	}
	
	public void fall() {
		b1.setCenter(new Point(b1.getCenter().x, b1.getCenter().y+1));
		b2.setCenter(new Point(b2.getCenter().x, b2.getCenter().y+1));
		b3.setCenter(new Point(b3.getCenter().x, b3.getCenter().y+1));
	}
	
	public void update() {
		fall();
	}
	
}
