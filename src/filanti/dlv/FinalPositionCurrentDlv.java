package filanti.dlv;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("fPt")
public class FinalPositionCurrentDlv {
	
	@Param(0)
	private int x1;
	@Param(1)
	private int y1;
	@Param(2)
	private int c1;
	@Param(3)
	private int x2;
	@Param(4)
	private int y2;
	@Param(5)
	private int c2;
	@Param(6)
	private int x3;
	@Param(7)
	private int y3;
	@Param(8)
	private int c3;
	@Param(9)
	private int xM;
	@Param(10)
	private int rotation;
	@Param(11)
	private int tempScore;
	@Param(12)
	private int equalsColor;
	
	public FinalPositionCurrentDlv() {
		super();
	}

	public FinalPositionCurrentDlv(int x1, int y1, int c1, int x2, int y2, int c2, int x3, int y3, int c3, int xM,
			int rotation,int tempScore, int equalsColor) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.c1 = c1;
		this.x2 = x2;
		this.y2 = y2;
		this.c2 = c2;
		this.x3 = x3;
		this.y3 = y3;
		this.c3 = c3;
		this.xM = xM;
		this.rotation = rotation;
		this.tempScore=tempScore;
		this.equalsColor=equalsColor;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getC1() {
		return c1;
	}

	public void setC1(int c1) {
		this.c1 = c1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public int getC2() {
		return c2;
	}

	public void setC2(int c2) {
		this.c2 = c2;
	}

	public int getX3() {
		return x3;
	}

	public void setX3(int x3) {
		this.x3 = x3;
	}

	public int getY3() {
		return y3;
	}

	public void setY3(int y3) {
		this.y3 = y3;
	}

	public int getC3() {
		return c3;
	}

	public void setC3(int c3) {
		this.c3 = c3;
	}

	public int getXM() {
		return xM;
	}

	public void setXM(int xM) {
		this.xM = xM;
	}

	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
	}

	public int getTempScore() {
		return tempScore;
	}

	public void setTempScore(int tempScore) {
		this.tempScore = tempScore;
	}
	
	

	public int getEqualsColor() {
		return equalsColor;
	}

	public void setEqualsColor(int equalsColor) {
		this.equalsColor = equalsColor;
	}

	@Override
	public String toString() {
		return "FinalPositionCurrentDlv [x1=" + x1 + ", y1=" + y1 + ", c1=" + c1 + ", x2=" + x2 + ", y2=" + y2 + ", c2=" + c2
				+ ", x3=" + x3 + ", y3=" + y3 + ", c3=" + c3 + ", xM=" + xM + ", rotation=" + rotation + ", tempScore="
				+ tempScore + "]";
	}
	
	
}
