package pob.filanti.core;

public class Ball extends Circle{
	
	public int getColor() {
		return color;
	}


	private int color;
	
	public Ball(int color, int x, int y) {
		super(x,y);
		this.color=color;
	}
	
	
	
	
}
