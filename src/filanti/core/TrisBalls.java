package filanti.core;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class TrisBalls {
	private Ball b1;	//pallina in alto
	private Ball b2;	//pallina in basso sinistra
	private Ball b3;	//pallina in basso destra
	private int rotateRight;
	private int rotateLeft;
	public TrisBalls() {
		rotateRight=7;
		rotateLeft=1;
		b1=new Ball(new Random().nextInt(4),3,6);
		b2=new Ball(new Random().nextInt(4),2,8);
		b3=new Ball(new Random().nextInt(4),4,8);
	}


	public int getRotateRight() {
		return rotateRight;
	}


	public void setRotateRight(int rotateRight) {
		this.rotateRight = rotateRight;
	}


	public int getRotateLeft() {
		return rotateLeft;
	}


	public void setRotateLeft(int rotateLeft) {
		this.rotateLeft = rotateLeft;
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
				b1.update(balls);
				if(b2.y>=b3.y) {
					b2.update(balls);
					b3.update(balls);
				}
				else {
					b3.update(balls);
					b2.update(balls);
				}
			}
			else if(b2.y>=b1.y && b2.y>=b3.y) {
				b2.update(balls);
				if(b1.y>=b3.y) {
					b1.update(balls);
					b3.update(balls);
				}
				else {
					b3.update(balls);
					b1.update(balls);
				}
			}
			else {
				b3.update(balls);
				if(b2.y>=b1.y) {
					b2.update(balls);
					b1.update(balls);
				}
				else {
					b1.update(balls);
					b2.update(balls);
				}
			}
		}

		else if(b1.checkCollision(balls)&&b2.checkCollision(balls)&&!b3.checkCollision(balls)){
			if(b1.y>=b2.y) {
				b1.update(balls);
				b2.update(balls);
			}
			else {
				b2.update(balls);
				b1.update(balls);
			}
			b3.update(balls);
		}

		else if(b1.checkCollision(balls)&&!b2.checkCollision(balls)&&b3.checkCollision(balls)){
			if(b1.y>=b3.y) {
				b1.update(balls);
				b3.update(balls);
			}
			else {
				b3.update(balls);
				b1.update(balls);
			}
			b2.update(balls);
		}

		else if(!b1.checkCollision(balls)&&b2.checkCollision(balls)&&b3.checkCollision(balls)){
			if(b3.y>=b2.y) {
				b3.update(balls);
				b2.update(balls);
			}
			else {
				b2.update(balls);
				b3.update(balls);
			}
			b1.update(balls);
		}

		else if(b1.checkCollision(balls)&&!b2.checkCollision(balls)&&!b3.checkCollision(balls)){
			b1.update(balls);
			if(b2.y>=b3.y) {
				b2.update(balls);
				b3.update(balls);
			}
			else {
				b3.update(balls);
				b2.update(balls);
			}
		}

		else if(!b1.checkCollision(balls)&&b2.checkCollision(balls)&&!b3.checkCollision(balls)){
			b2.update(balls);
			if(b1.y>=b3.y) {
				b1.update(balls);
				b3.update(balls);
			}
			else {
				b3.update(balls);
				b1.update(balls);
			}
		}

		else if(!b1.checkCollision(balls)&&!b2.checkCollision(balls)&&b3.checkCollision(balls)){
			b3.update(balls);
			if(b1.y>=b2.y) {
				b1.update(balls);
				b2.update(balls);
			}
			else {
				b2.update(balls);
				b1.update(balls);
			}
		}
	}

	public void rotateRight() {
		if((rotateLeft==1 && rotateRight==7) || (rotateLeft==7 && rotateRight==1)) {
			b1.setPositionBall(b1.x+1, b1.y);
			b2.setPositionBall(b2.x-1, b2.y);
			b3.setPositionBall(b3.x, b3.y+2);
			b1.setCenter(b1.x+1,b1.y+1);
			b2.setCenter(b2.x+1,b2.y+1);
			b3.setCenter(b3.x+1, b3.y+1);
		}
		else if(rotateLeft==2 && rotateRight==6) {
			b1.setPositionBall(b1.x, b1.y-2);
			b2.setPositionBall(b2.x-1, b2.y);
			b3.setPositionBall(b3.x+1, b3.y);
			b1.setCenter(b1.x+1,b1.y+1);
			b2.setCenter(b2.x+1,b2.y+1);
			b3.setCenter(b3.x+1, b3.y+1);
		}
		else if(rotateLeft==3 && rotateRight==5) {
			b1.setPositionBall(b1.x-1, b1.y);
			b2.setPositionBall(b2.x, b2.y+2);
			b3.setPositionBall(b3.x+1, b3.y);
			b1.setCenter(b1.x+1,b1.y+1);
			b2.setCenter(b2.x+1,b2.y+1);
			b3.setCenter(b3.x+1, b3.y+1);
		}
		else if(rotateLeft==4 && rotateRight==4) {
			b1.setPositionBall(b1.x-1, b1.y);
			b2.setPositionBall(b2.x+1, b2.y);
			b3.setPositionBall(b3.x, b3.y-2);
			b1.setCenter(b1.x+1,b1.y+1);
			b2.setCenter(b2.x+1,b2.y+1);
			b3.setCenter(b3.x+1, b3.y+1);
		}
		else if(rotateLeft==5 && rotateRight==3) {
			b1.setPositionBall(b1.x, b1.y+2);
			b2.setPositionBall(b2.x+1, b2.y);
			b3.setPositionBall(b3.x-1, b3.y);
			b1.setCenter(b1.x+1,b1.y+1);
			b2.setCenter(b2.x+1,b2.y+1);
			b3.setCenter(b3.x+1, b3.y+1);
		}
		else if(rotateLeft==6 && rotateRight==2) {
			b1.setPositionBall(b1.x+1, b1.y);
			b2.setPositionBall(b2.x, b2.y-2);
			b3.setPositionBall(b3.x-1, b3.y);
			b1.setCenter(b1.x+1,b1.y+1);
			b2.setCenter(b2.x+1,b2.y+1);
			b3.setCenter(b3.x+1, b3.y+1);
		}
	}
	
	public void rotateLeft() {
		if((rotateLeft==1 && rotateRight==7) || (rotateLeft==7 && rotateRight==1)) {
			b1.setPositionBall(b1.x-1, b1.y);
			b2.setPositionBall(b2.x, b2.y+2);
			b3.setPositionBall(b3.x+1, b3.y);
			b1.setCenter(b1.x+1,b1.y+1);
			b2.setCenter(b2.x+1,b2.y+1);
			b3.setCenter(b3.x+1, b3.y+1);
		}
		else if(rotateLeft==2 && rotateRight==6) {
			b1.setPositionBall(b1.x-1, b1.y);
			b2.setPositionBall(b2.x+1, b2.y);
			b3.setPositionBall(b3.x, b3.y-2);
			b1.setCenter(b1.x+1,b1.y+1);
			b2.setCenter(b2.x+1,b2.y+1);
			b3.setCenter(b3.x+1, b3.y+1);
		}
		else if(rotateLeft==3 && rotateRight==5) {
			b1.setPositionBall(b1.x, b1.y+2);
			b2.setPositionBall(b2.x+1, b2.y);
			b3.setPositionBall(b3.x-1, b3.y);
			b1.setCenter(b1.x+1,b1.y+1);
			b2.setCenter(b2.x+1,b2.y+1);
			b3.setCenter(b3.x+1, b3.y+1);
		}
		else if(rotateLeft==4 && rotateRight==4) {
			b1.setPositionBall(b1.x+1, b1.y);
			b2.setPositionBall(b2.x, b2.y-2);
			b3.setPositionBall(b3.x-1, b3.y);
			b1.setCenter(b1.x+1,b1.y+1);
			b2.setCenter(b2.x+1,b2.y+1);
			b3.setCenter(b3.x+1, b3.y+1);
		}
		else if(rotateLeft==5 && rotateRight==3) {
			b1.setPositionBall(b1.x+1, b1.y);
			b2.setPositionBall(b2.x-1, b2.y);
			b3.setPositionBall(b3.x, b3.y+2);
			b1.setCenter(b1.x+1,b1.y+1);
			b2.setCenter(b2.x+1,b2.y+1);
			b3.setCenter(b3.x+1, b3.y+1);
		}
		else if(rotateLeft==6 && rotateRight==2) {
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
