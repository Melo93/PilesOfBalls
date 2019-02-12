package filanti.core;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class TrisBalls {
	private Ball b1;	//pallina in alto
	private Ball b2;	//pallina in basso sinistra
	private Ball b3;	//pallina in basso destra
	private int rotate;
	public TrisBalls() {
		rotate=1;
		b1=new Ball(new Random().nextInt(4),3,6);
		b2=new Ball(new Random().nextInt(4),2,8);
		b3=new Ball(new Random().nextInt(4),4,8);
	}




	public int getRotate() {
		return rotate;
	}


	public void setRotate(int rotate) {
		this.rotate = rotate;
	}


	public void initTrisBall(){
		//			b1.x = 19; 
		//			b1.y = 2;
		//			b1.setCenter(b1.x+1, b1.y+1);
		//			b2.x = 18;
		//			b2.y = 0;
		//			b2.setCenter(b2.x+1, b2.y+1);
		//			b3.x = 20;
		//			b3.y = 0; 
		//			b3.setCenter(b3.x+1, b3.y+1);
		b1.setPositionBall(19,2); 
		b1.setCenter(b1.x+1, b1.y+1);
		b2.setPositionBall(18, 4);
		b2.setCenter(b2.x+1, b2.y+1);
		b3.setPositionBall(20, 4); 
		b3.setCenter(b3.x+1, b3.y+1);
	}
	
	public void update(CopyOnWriteArrayList<Ball> balls) {
		updateOrder(balls);	
	}

	public void updateOrder(CopyOnWriteArrayList<Ball> balls) {
		if(b1.checkCollision(balls)&&b2.checkCollision(balls)&&b3.checkCollision(balls) || !b1.checkCollision(balls)&&!b2.checkCollision(balls)&&!b3.checkCollision(balls)) {
			if(b1.y>=b2.y && b1.y>=b3.y) {
				b1.update(balls,this);
				if(b2.y>=b3.y) {
					b2.update(balls,this);
					b3.update(balls,this);
				}
				else {
					b3.update(balls,this);
					b2.update(balls,this);
				}
			}
			else if(b2.y>=b1.y && b2.y>=b3.y) {
				b2.update(balls,this);
				if(b1.y>=b3.y) {
					b1.update(balls,this);
					b3.update(balls,this);
				}
				else {
					b3.update(balls,this);
					b1.update(balls,this);
				}
			}
			else {
				b3.update(balls,this);
				if(b2.y>=b1.y) {
					b2.update(balls,this);
					b1.update(balls,this);
				}
				else {
					b1.update(balls,this);
					b2.update(balls,this);
				}
			}
		}

		else if(b1.checkCollision(balls)&&b2.checkCollision(balls)&&!b3.checkCollision(balls)){
			if(b1.y>=b2.y) {
				b1.update(balls,this);
				b2.update(balls,this);
			}
			else {
				b2.update(balls,this);
				b1.update(balls,this);
			}
			b3.update(balls,this);
		}

		else if(b1.checkCollision(balls)&&!b2.checkCollision(balls)&&b3.checkCollision(balls)){
			if(b1.y>=b3.y) {
				b1.update(balls,this);
				b3.update(balls,this);
			}
			else {
				b3.update(balls,this);
				b1.update(balls,this);
			}
			b2.update(balls,this);
		}

		else if(!b1.checkCollision(balls)&&b2.checkCollision(balls)&&b3.checkCollision(balls)){
			if(b3.y>=b2.y) {
				b3.update(balls,this);
				b2.update(balls,this);
			}
			else {
				b2.update(balls,this);
				b3.update(balls,this);
			}
			b1.update(balls,this);
		}

		else if(b1.checkCollision(balls)&&!b2.checkCollision(balls)&&!b3.checkCollision(balls)){
			b1.update(balls,this);
			if(b2.y>=b3.y) {
				b2.update(balls,this);
				b3.update(balls,this);
			}
			else {
				b3.update(balls,this);
				b2.update(balls,this);
			}
		}

		else if(!b1.checkCollision(balls)&&b2.checkCollision(balls)&&!b3.checkCollision(balls)){
			b2.update(balls,this);
			if(b1.y>=b3.y) {
				b1.update(balls,this);
				b3.update(balls,this);
			}
			else {
				b3.update(balls,this);
				b1.update(balls,this);
			}
		}

		else if(!b1.checkCollision(balls)&&!b2.checkCollision(balls)&&b3.checkCollision(balls)){
			b3.update(balls,this);
			if(b1.y>=b2.y) {
				b1.update(balls,this);
				b2.update(balls,this);
			}
			else {
				b2.update(balls,this);
				b1.update(balls,this);
			}
		}
	}

	
	
	public void rotateLeft() {
		if(rotate==1 ||rotate==7) {
			b1.setPositionBall(b1.x-1, b1.y);
			b2.setPositionBall(b2.x, b2.y+2);
			b3.setPositionBall(b3.x+1, b3.y);
			b1.setCenter(b1.x+1,b1.y+1);
			b2.setCenter(b2.x+1,b2.y+1);
			b3.setCenter(b3.x+1, b3.y+1);
		}
		else if(rotate==2 ) {
			b1.setPositionBall(b1.x-1, b1.y);
			b2.setPositionBall(b2.x+1, b2.y);
			b3.setPositionBall(b3.x, b3.y-2);
			b1.setCenter(b1.x+1,b1.y+1);
			b2.setCenter(b2.x+1,b2.y+1);
			b3.setCenter(b3.x+1, b3.y+1);
		}
		else if(rotate==3) {
			b1.setPositionBall(b1.x, b1.y+2);
			b2.setPositionBall(b2.x+1, b2.y);
			b3.setPositionBall(b3.x-1, b3.y);
			b1.setCenter(b1.x+1,b1.y+1);
			b2.setCenter(b2.x+1,b2.y+1);
			b3.setCenter(b3.x+1, b3.y+1);
		}
		else if(rotate==4) {
			b1.setPositionBall(b1.x+1, b1.y);
			b2.setPositionBall(b2.x, b2.y-2);
			b3.setPositionBall(b3.x-1, b3.y);
			b1.setCenter(b1.x+1,b1.y+1);
			b2.setCenter(b2.x+1,b2.y+1);
			b3.setCenter(b3.x+1, b3.y+1);
		}
		else if(rotate==5) {
			b1.setPositionBall(b1.x+1, b1.y);
			b2.setPositionBall(b2.x-1, b2.y);
			b3.setPositionBall(b3.x, b3.y+2);
			b1.setCenter(b1.x+1,b1.y+1);
			b2.setCenter(b2.x+1,b2.y+1);
			b3.setCenter(b3.x+1, b3.y+1);
		}
		else if(rotate==6) {
			b1.setPositionBall(b1.x, b1.y-2);
			b2.setPositionBall(b2.x-1, b2.y);
			b3.setPositionBall(b3.x+1, b3.y);
			b1.setCenter(b1.x+1,b1.y+1);
			b2.setCenter(b2.x+1,b2.y+1);
			b3.setCenter(b3.x+1, b3.y+1);
		}
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
}
