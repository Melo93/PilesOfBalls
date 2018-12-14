package pob.filanti.core;

import java.awt.Point;
import java.util.Random;

public class TrisBalls {
	private Ball b1;	//pallina in alto
	private Ball b2;	//pallina in basso sinistra
	private Ball b3;	//pallina in basso destra
	private int position;
	
	public TrisBalls() {
		b1=new Ball(new Random().nextInt(3),20,2);
		b2=new Ball(new Random().nextInt(3),19,4);
		b3=new Ball(new Random().nextInt(3),21,4);
		position=1;
	}

	public void fall() {
		b1.setCenter(new Point(b1.getCenter().x, b1.getCenter().y+1));
		b2.setCenter(new Point(b2.getCenter().x, b2.getCenter().y+1));
		b3.setCenter(new Point(b3.getCenter().x, b3.getCenter().y+1));
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

	public int getPosition() {
		return position;
	}

	public void rotateLeft() {
		switch(position) {
		case 1:
			b1.setCenter(new Point(b1.getCenter().x,b1.getCenter().y));	//pallina in alto
			b2.setCenter(new Point(b2.getCenter().x,b2.getCenter().y));	//pallina in basso sinistra
			b3.setCenter(new Point(b3.getCenter().x,b3.getCenter().y));	//pallina in basso destra
			break;
		case 2:
			b1.setCenter(new Point(b1.getCenter().x-1,b1.getCenter().y));	//pallina in alto a sinistra
			b2.setCenter(new Point(b2.getCenter().x+1,b2.getCenter().y));	//pallina in basso centrale
			b3.setCenter(new Point(b3.getCenter().x,b3.getCenter().y-2));	//pallina in alto a destra
			break;
		case 3:
			b1.setCenter(new Point(b1.getCenter().x,b1.getCenter().y+2));	//pallina in basso a sinistra
			b2.setCenter(new Point(b2.getCenter().x+1,b2.getCenter().y));	//pallina in basso a destra
			b3.setCenter(new Point(b3.getCenter().x-1,b3.getCenter().y));	//pallina in alto centrale
			break;
		case 4:
			b1.setCenter(new Point(b1.getCenter().x+1,b1.getCenter().y));	//pallina in basso centrale
			b2.setCenter(new Point(b2.getCenter().x,b2.getCenter().y-2));	//pallina in alto a destra
			b3.setCenter(new Point(b3.getCenter().x-1,b3.getCenter().y));	//pallina in alto a sinistra
			break;
		case 5:
			b1.setCenter(new Point(b1.getCenter().x+1,b1.getCenter().y));	//pallina in basso destra
			b2.setCenter(new Point(b2.getCenter().x-1,b2.getCenter().y));	//pallina in alto centrale
			b3.setCenter(new Point(b3.getCenter().x,b3.getCenter().y+2));	//pallina in basso a sinistra
			break;
		case 6: 
			b1.setCenter(new Point(b1.getCenter().x-1,b1.getCenter().y));	//pallina in alto a destra
			b2.setCenter(new Point(b2.getCenter().x,b2.getCenter().y-2));	//pallina in alto a sinistra
			b3.setCenter(new Point(b3.getCenter().x+1,b3.getCenter().y));	//pallina in basso centrale
		}
		
	}
	
	public void rotateRight() {
		switch(position) {
		case 1:
			b1.setCenter(new Point(b1.getCenter().x,b1.getCenter().y));	//pallina in alto
			b2.setCenter(new Point(b2.getCenter().x,b2.getCenter().y));	//pallina in basso sinistra
			b3.setCenter(new Point(b3.getCenter().x,b3.getCenter().y));	//pallina in basso destra
			break;
		case 2:
			b1.setCenter(new Point(b1.getCenter().x+1,b1.getCenter().y));	//pallina in alto a destra
			b2.setCenter(new Point(b2.getCenter().x,b2.getCenter().y-2));	//pallina in alto a sinistra
			b3.setCenter(new Point(b3.getCenter().x-1,b3.getCenter().y));	//pallina in basso centrale
			break;
		case 3:
			b1.setCenter(new Point(b1.getCenter().x,b1.getCenter().y+2));	//pallina in basso a destra
			b2.setCenter(new Point(b2.getCenter().x+1,b2.getCenter().y));	//pallina in alto centrale
			b3.setCenter(new Point(b3.getCenter().x-1,b3.getCenter().y));	//pallina in basso a sinistra
			break;
		case 4:
			b1.setCenter(new Point(b1.getCenter().x-1,b1.getCenter().y));	//pallina in basso centrale
			b2.setCenter(new Point(b2.getCenter().x+1,b2.getCenter().y));	//pallina in alto a destra
			b3.setCenter(new Point(b3.getCenter().x,b3.getCenter().y-2));	//pallina in alto a sinistra
			break;
		case 5:
			b1.setCenter(new Point(b1.getCenter().x-1,b1.getCenter().y));	//pallina in basso a sinistra
			b2.setCenter(new Point(b2.getCenter().x,b2.getCenter().y+2));	//pallina in basso a destra
			b3.setCenter(new Point(b3.getCenter().x+1,b3.getCenter().y));	//pallina in altro centrale
			break;
		case 6: 
			b1.setCenter(new Point(b1.getCenter().x,b1.getCenter().y-2));	//pallina in alto a sinistra
			b2.setCenter(new Point(b2.getCenter().x-1,b2.getCenter().y));	//pallina in basso centrale
			b3.setCenter(new Point(b3.getCenter().x+1,b3.getCenter().y));	//pallina in alto a destra
		}
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	
	@Override
	public String toString() {
		return "TrisBalls [b1 x=" + b1.getCenter().x + " b1 y=" + b1.getCenter().y +", b2 x=" + b2.getCenter().x +", b2 y="+ b2.getCenter().y +
				", b3 x=" + b3.getCenter().x + ", b3 y="+b3.getCenter().y +"]";
	}
	
	public void update() {
		fall();
	}
	
}
