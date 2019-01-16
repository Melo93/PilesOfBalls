package filanti.core;

import java.awt.Point;
import java.awt.Rectangle;

public class Ball extends Rectangle{

	private static final long serialVersionUID = 1L;
	private int speed;
	private int color;
	private Point center;
	
	public Ball( int color,int x, int y) {
		super(x,y,GameConfig.BALL_WIDTH,GameConfig.BALL_HEIGHT);
		this.speed=1;
		this.color=color;
		this.center=new Point((x+GameConfig.BALL_WIDTH)/2,(y+GameConfig.BALL_HEIGHT)/2);
	}
	
	public boolean intersect(Ball b) {
		if(this.x + this.width >= (b.x) && (this.x) <= (b.x + b.width) && (this.y + this.height) >= (b.y) && (this.y) <= (b.y + b.height)) {
			return true;
		}
		return false;
	}
	public int getColor() {
		return color;
		
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(int x, int y) {
		this.center.x=x;
		this.center.y=y;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}


	
	
	
}
