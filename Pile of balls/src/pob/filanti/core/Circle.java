package pob.filanti.core;

import java.awt.Point;



public abstract class Circle {
	private Point center;
	private final double radius=1;
	
	public Circle(int x, int y) {
		center=new Point(x,y);
	}

	public boolean Intersects(Circle circle)
	{
		double distanceX = center.getX() - circle.center.getX();
		double distanceY = center.getY() - circle.center.getY();
		double radiusSum = circle.radius + radius;
		return distanceX * distanceX + distanceY * distanceY <= radiusSum * radiusSum;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}
	
	
}
