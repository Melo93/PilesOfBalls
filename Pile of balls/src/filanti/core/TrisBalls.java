package filanti.core;

import java.awt.Point;
import java.util.Random;

public class TrisBalls {
	private Ball b1;	//pallina in alto
	private Ball b2;	//pallina in basso sinistra
	private Ball b3;	//pallina in basso destra
	private boolean stop;
	private int status;


	public TrisBalls(Board b, int status) {
		this.status=status;
		setPositionTrisBall(b);
	}
	
	public void setPositionTrisBall(Board b)
	{
		if(status==1) {
			b1=new Ball(new Random().nextInt(3)+1,0,30);
			b2=new Ball(new Random().nextInt(3)+1,2,29);
			b3=new Ball(new Random().nextInt(3)+1,2,31);

			b.fillBoard(0, 30, b1.getColor());
			b.fillBoard(2, 29, b2.getColor());
			b.fillBoard(2, 31, b3.getColor());
			stop=false;

		}
		else if(status==0) {
			b1=new Ball(new Random().nextInt(3),2,6);
			b2=new Ball(new Random().nextInt(3),1,8);
			b3=new Ball(new Random().nextInt(3),3,8);
			stop=true;

		}
	}

	public void fall(Board b) {
		if(!stop) {
			if(b1.x+b1.getSpeed()<(b.getROW()*2)-1&&b2.x+b2.getSpeed()<(b.getROW()*2)-1&&b3.x+b3.getSpeed()<(b.getROW()*2)-1) {
				b.clearPosition(b1.x, b1.y);
				b.clearPosition(b2.x, b2.y);
				b.clearPosition(b3.x, b3.y);
				b1.translate(b1.getSpeed(), 0);
				b2.translate(b2.getSpeed(), 0);
				b3.translate(b3.getSpeed(), 0);
				b1.setCenter(b1.getCenter().x+b1.getSpeed(), b1.getCenter().y);
				b2.setCenter(b2.getCenter().x+b2.getSpeed(), b2.getCenter().y);
				b3.setCenter(b3.getCenter().x+b3.getSpeed(), b3.getCenter().y);
				b.fillBoard(b1.x, b1.y, b1.getColor());
				b.fillBoard(b2.x, b2.y, b2.getColor());
				b.fillBoard(b3.x, b3.y, b3.getColor());
			}
			else stop=true;
		}

	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Ball getB1() {
		return b1;
	}
	
	public void setB1(Ball b1) {
		this.b1 = b1;
	}
	
	public Ball getB2() {
		return b2;
	}
	
	public void setB2(Ball b2) {
		this.b2 = b2;
	}
	
	public Ball getB3() {
		return b3;
	}
	
	public void setB3(Ball b3) {
		this.b3 = b3;
	}



}
