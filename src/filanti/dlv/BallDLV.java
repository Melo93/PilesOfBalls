package filanti.dlv;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("ball")
public class BallDLV {
	
	@Param(0)
	private int x;
	@Param(1)
	private int y;
	@Param(2)
	private int color;
	
	public BallDLV(int x, int y, int color) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	public BallDLV() {
		// TODO Auto-generated constructor stub
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "BallDLV [x=" + x + ", y=" + y + ", color=" + color + "]";
	}
	
	
	
}
