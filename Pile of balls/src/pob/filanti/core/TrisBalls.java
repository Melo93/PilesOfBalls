package pob.filanti.core;

import java.awt.Point;
import java.util.Random;

public class TrisBalls {
	private Ball b1;	//pallina in alto
	private Ball b2;	//pallina in basso sinistra
	private Ball b3;	//pallina in basso destra
	private int positionLeft;
	private int positionRight;
	private int speed;
	private boolean canMove;

	public TrisBalls(int status) {
		if(status==1) {
			b1=new Ball(new Random().nextInt(3),20,2);
			b2=new Ball(new Random().nextInt(3),19,4);
			b3=new Ball(new Random().nextInt(3),21,4);
			positionLeft=1;
			positionRight=7;
			speed=1;
			canMove=true;
		}
		else if(status==0) {
			b1=new Ball(new Random().nextInt(3),2,6);
			b2=new Ball(new Random().nextInt(3),1,8);
			b3=new Ball(new Random().nextInt(3),3,8);
			positionLeft=1;
			positionRight=7;
			speed=0;
			canMove=false;
		}
	}
	public void changeStatus() {
		b1.setCenter(new Point(20,2));
		b2.setCenter(new Point(19,4));
		b3.setCenter(new Point(21,4));
		positionLeft=1;
		positionRight=7;
		speed=1;
		canMove=true;
	}

	private void checkCollisionBoard() {
		//collisione destra
		if(b3.getCenter().x>=GameConfig.RIGHT || b2.getCenter().x>=GameConfig.RIGHT || b1.getCenter().x>=GameConfig.RIGHT) {
			if(positionLeft==1||positionRight==7 || positionLeft==7 ||positionRight==1) {
				b1.setCenter(new Point(GameConfig.RIGHT-1, b1.getCenter().y));
				b2.setCenter(new Point(GameConfig.RIGHT-2, b2.getCenter().y));
				b3.setCenter(new Point(GameConfig.RIGHT, b3.getCenter().y));
			}
			else if(positionLeft==2||positionRight==6) {
				b1.setCenter(new Point(GameConfig.RIGHT-2, b1.getCenter().y));
				b2.setCenter(new Point(GameConfig.RIGHT-1, b2.getCenter().y));
				b3.setCenter(new Point(GameConfig.RIGHT, b3.getCenter().y));
			}
			else if(positionLeft==3||positionRight==5) {
				b1.setCenter(new Point(GameConfig.RIGHT-2, b1.getCenter().y));
				b2.setCenter(new Point(GameConfig.RIGHT, b2.getCenter().y));
				b3.setCenter(new Point(GameConfig.RIGHT-1, b3.getCenter().y));
			}
			else if(positionLeft==4 ||positionRight==4) {
				b1.setCenter(new Point(GameConfig.RIGHT-1, b1.getCenter().y));
				b2.setCenter(new Point(GameConfig.RIGHT, b2.getCenter().y));
				b3.setCenter(new Point(GameConfig.RIGHT-2, b3.getCenter().y));
			}
			else if(positionLeft==5 ||positionRight==3) {
				b1.setCenter(new Point(GameConfig.RIGHT, b1.getCenter().y));
				b2.setCenter(new Point(GameConfig.RIGHT-1, b2.getCenter().y));
				b3.setCenter(new Point(GameConfig.RIGHT-2, b3.getCenter().y));
			}
			else if(positionLeft==6 ||positionRight==2) {
				b1.setCenter(new Point(GameConfig.RIGHT, b1.getCenter().y));
				b2.setCenter(new Point(GameConfig.RIGHT-2, b2.getCenter().y));
				b3.setCenter(new Point(GameConfig.RIGHT-1, b3.getCenter().y));
			}
		}
		//collisione sinistra
		else if(b3.getCenter().x<=GameConfig.LEFT || b2.getCenter().x<=GameConfig.LEFT || b1.getCenter().x<=GameConfig.LEFT) {
			if(positionLeft==1||positionRight==7 || positionLeft==7 ||positionRight==1) {
				b1.setCenter(new Point(GameConfig.LEFT+1, b1.getCenter().y));
				b2.setCenter(new Point(GameConfig.LEFT, b2.getCenter().y));
				b3.setCenter(new Point(GameConfig.LEFT+2, b3.getCenter().y));
			}
			else if(positionLeft==2||positionRight==6) {
				b1.setCenter(new Point(GameConfig.LEFT, b1.getCenter().y));
				b2.setCenter(new Point(GameConfig.LEFT+1, b2.getCenter().y));
				b3.setCenter(new Point(GameConfig.LEFT+2, b3.getCenter().y));
			}
			else if(positionLeft==3||positionRight==5) {
				b1.setCenter(new Point(GameConfig.LEFT, b1.getCenter().y));
				b2.setCenter(new Point(GameConfig.LEFT+2, b2.getCenter().y));
				b3.setCenter(new Point(GameConfig.LEFT+1, b3.getCenter().y));
			}
			else if(positionLeft==4 ||positionRight==4) {
				b1.setCenter(new Point(GameConfig.LEFT+1, b1.getCenter().y));
				b2.setCenter(new Point(GameConfig.LEFT+2, b2.getCenter().y));
				b3.setCenter(new Point(GameConfig.LEFT, b3.getCenter().y));
			}
			else if(positionLeft==5 ||positionRight==3) {
				b1.setCenter(new Point(GameConfig.LEFT+2, b1.getCenter().y));
				b2.setCenter(new Point(GameConfig.LEFT+1, b2.getCenter().y));
				b3.setCenter(new Point(GameConfig.LEFT, b3.getCenter().y));
			}
			else if(positionLeft==6 ||positionRight==2) {
				b1.setCenter(new Point(GameConfig.LEFT+2, b1.getCenter().y));
				b2.setCenter(new Point(GameConfig.LEFT, b2.getCenter().y));
				b3.setCenter(new Point(GameConfig.LEFT+1, b3.getCenter().y));
			}
		}
	}

	private void checkCollisionFloor() {
		if(b3.getCenter().y>=GameConfig.FLOOR || b2.getCenter().y>=GameConfig.FLOOR || b1.getCenter().y>=GameConfig.FLOOR) {
			speed=0;
			if(positionLeft==1||positionRight==7 || positionLeft==7 ||positionRight==1) {
				b1.setCenter(new Point(b1.getCenter().x, GameConfig.FLOOR-2));
				b2.setCenter(new Point(b2.getCenter().x, GameConfig.FLOOR));
				b3.setCenter(new Point(b3.getCenter().x, GameConfig.FLOOR));
			}
			else if(positionLeft==2||positionRight==6) {
				b1.setCenter(new Point(b1.getCenter().x, GameConfig.FLOOR-2));
				b2.setCenter(new Point(b2.getCenter().x, GameConfig.FLOOR));
				b3.setCenter(new Point(b3.getCenter().x, GameConfig.FLOOR-2));
			}

			else if(positionLeft==3||positionRight==5) {
				b1.setCenter(new Point(b1.getCenter().x, GameConfig.FLOOR));
				b2.setCenter(new Point(b2.getCenter().x, GameConfig.FLOOR));
				b3.setCenter(new Point(b3.getCenter().x, GameConfig.FLOOR-2));
			}
			else if(positionLeft==4 ||positionRight==4) {
				b1.setCenter(new Point(b1.getCenter().x, GameConfig.FLOOR));
				b2.setCenter(new Point(b2.getCenter().x, GameConfig.FLOOR-2));
				b3.setCenter(new Point(b3.getCenter().x, GameConfig.FLOOR-2));
			}
			else if(positionLeft==5 ||positionRight==3 ) {
				b1.setCenter(new Point(b1.getCenter().x, GameConfig.FLOOR));
				b2.setCenter(new Point(b2.getCenter().x, GameConfig.FLOOR-2));
				b3.setCenter(new Point(b3.getCenter().x, GameConfig.FLOOR));
			}
			else if(positionLeft==6 ||positionRight==2 ) {
				b1.setCenter(new Point(b1.getCenter().x, GameConfig.FLOOR-2));
				b2.setCenter(new Point(b2.getCenter().x, GameConfig.FLOOR-2));
				b3.setCenter(new Point(b3.getCenter().x, GameConfig.FLOOR));
			}
			canMove=false;
		}

	}

	public void fall() {
		b1.setCenter(new Point(b1.getCenter().x, b1.getCenter().y+speed));
		b2.setCenter(new Point(b2.getCenter().x, b2.getCenter().y+speed));
		b3.setCenter(new Point(b3.getCenter().x, b3.getCenter().y+speed));

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

	public int getPositionLeft() {
		return positionLeft;
	}

	public int getPositionRight() {
		return positionRight;
	}

	public int getSpeed() {
		return speed;
	}

	public void rotateLeft() {
		switch(positionLeft) {
		case 1:
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
			b1.setCenter(new Point(b1.getCenter().x,b1.getCenter().y-2));	//pallina in alto a destra
			b2.setCenter(new Point(b2.getCenter().x-1,b2.getCenter().y));	//pallina in alto a sinistra
			b3.setCenter(new Point(b3.getCenter().x+1,b3.getCenter().y));	//pallina in basso centrale
			break;
		case 7:
			b1.setCenter(new Point(b1.getCenter().x-1,b1.getCenter().y));	//pallina in alto centrale
			b2.setCenter(new Point(b2.getCenter().x,b2.getCenter().y+2));	//pallina in basso a sinistra
			b3.setCenter(new Point(b3.getCenter().x+1,b3.getCenter().y));   //pallina in basso a destra
			break;
		}

	}

	public void rotateRight() {
		switch(positionRight) {
		case 1:
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
			break;
		case 7:
			b1.setCenter(new Point(b1.getCenter().x+1,b1.getCenter().y));	//pallina in alto a centrale
			b2.setCenter(new Point(b2.getCenter().x-1,b2.getCenter().y));	//pallina in basso a destra
			b3.setCenter(new Point(b3.getCenter().x,b3.getCenter().y+2));	//pallina in basso a sinistra
			break;
		}
	}

	public void setPositionLeft(int positionLeft) {
		this.positionLeft = positionLeft;
	}


	public void setPositionRight(int positionRight) {
		this.positionRight = positionRight;
	}



	public void setSpeed(int speed) {
		this.speed = speed;
	}



	public boolean canMove() {
		return canMove;
	}

	public void setCanMove(boolean canMove) {
		this.canMove = canMove;
	}

	@Override
	public String toString() {
		return "TrisBalls [b1 x=" + b1.getCenter().x + " b1 y=" + b1.getCenter().y +", b2 x=" + b2.getCenter().x +", b2 y="+ b2.getCenter().y +
				", b3 x=" + b3.getCenter().x + ", b3 y="+b3.getCenter().y + " position left: "+ positionLeft+" position right: "+ positionRight+"]";
	}

	public void update() {
		fall();
		checkCollisionFloor();
		checkCollisionBoard();

	}
}
