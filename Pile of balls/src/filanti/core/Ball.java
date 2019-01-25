package filanti.core;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.concurrent.CopyOnWriteArrayList;

public class Ball extends Rectangle{

	private static final long serialVersionUID = 1L;
	private int speed;
	private int color;
	private Point center;
	private boolean stop;
	private boolean canMove;
	
	public Ball( int color,int x, int y) {
		super(x,y,GameConfig.BALL_WIDTH,GameConfig.BALL_HEIGHT);
		this.speed=2;
		this.color=color;
		this.center=new Point((x+(x+GameConfig.BALL_WIDTH))/2,(y+(y+GameConfig.BALL_HEIGHT))/2);
		stop=false;
		canMove = true;
	}

	public boolean collisione(Ball b) {
		if(this.y+this.height==b.y) {
			if(this.x==b.x || this.x+1==b.x || this.x-1==b.x) {
				return true;
			}
		}
		return false;
	}

	public void update( CopyOnWriteArrayList<Ball> balls,Collision c) {
		if(!checkCollision(balls,c)) {
			this.fall();
		}
		else {
			canMove = false;
			findPosition(balls);	
			//scoppia(balls);
		}
	}
	
	public void update2(CopyOnWriteArrayList<Ball> balls) {
		if(!checkCollision2(balls)) {
			this.fall();
		}
		else {
			canMove = false;
			findPosition(balls);	
			//scoppia(balls);
		}
	}
		
	public boolean checkCollision2(CopyOnWriteArrayList<Ball> balls) {
			for(Ball b:balls) {
				if(this.collisione(b) || this.y==32 || this.y+this.height==30) {
					return true;
				}
			}
			return false;
	}

	public void fall() {
		if(!stop) {
			if(this.y+this.getSpeed()<32) {
				this.translate(0,this.getSpeed());
				this.setCenter(center.x,center.y+speed);
			} else {
				stop=true;
				canMove = false;
			}
		}
	}

	public void findPosition(CopyOnWriteArrayList<Ball> balls) {
		boolean left=false;
		boolean right=false;
		boolean center=false;
		for(Ball b:balls) {
			if(this.y+this.height==b.y) {
				if(this.x==b.x) {
					center=true;
				} else if(this.x+1==b.x) {
					right=true;
				} else if(this.x-1==b.x) {
					left=true;
				}
			}
		}
		if(right && left) {
			stop=true;
		}
		else if(right) {
			moveBall(-1,2);
		} else if(left) {
			moveBall(1,2);
		} else if(center) {
			boolean leftC=false;
			boolean rightC=false;
			for(Ball b:balls) {
				if(this.x+2==b.x && this.y+2==b.y) {
					rightC=true;
				} else if (this.x-2==b.x&&this.y+2==b.y) {
					leftC=true;
				}
			}
			if(leftC&&rightC) {
				moveBall(-1,0);
			} else if(rightC) {
				moveBall(-2,2);
			} else {
				moveBall(2, 2);
			}
		}
	}

	private void moveBall(int dx, int dy) {
		this.translate(dx,dy);
		this.setCenter(center.x+dx,center.y+dy);
	}

	
	
	public boolean checkCollision( CopyOnWriteArrayList<Ball> balls, Collision c) {
		for(Ball b:balls) {
			if(this.collisione(b)) {
				if(this.x<=b.x) {
					c=Collision.Right;
				} else {
					c=Collision.Left;
				}
				return true;
			}
		}
		return false;
	}
	
	public boolean scoppia(CopyOnWriteArrayList<Ball> balls) {
		for(Ball b: balls) {
			CopyOnWriteArrayList<Ball> controllate = new CopyOnWriteArrayList<>();
			CopyOnWriteArrayList<Ball> daControllare = new CopyOnWriteArrayList<>();
			daControllare.add(b);
			if(cercaUguali(b, balls, controllate, daControllare)) {
				if(controllate.size() >= 4) {
					balls.removeAll(controllate);
					for(Ball b1 : balls) {
						b1.setStop(false);
						b1.update2(balls);
					}
					return true;
				}
			}
		}
		return false;
	}
	public void pallineDaPosizionare(CopyOnWriteArrayList<Ball> balls) {
		for(Ball b: balls) {
			b.setStop(false);
			b.update2(balls);
		}
	}
		
    
	public boolean tuttePosizionateFinale(CopyOnWriteArrayList<Ball> balls) {
		if(this.checkCollision2(balls)) {
				return false; 
		}
		return true;
	}
	
	public boolean cercaUguali(Ball temp,CopyOnWriteArrayList<Ball> balls, CopyOnWriteArrayList<Ball> controllate, CopyOnWriteArrayList<Ball> daControllare) {
		if(daControllare.isEmpty()) {
			return true;
		}
		for(Ball b:balls) {
			if(temp!=b) {
				if(temp.getColor() == b.getColor()) {
					if(esisteAdiacente(b, temp)){
						if(!daControllare.contains(b) && !controllate.contains(b)) {
							daControllare.add(b);
						}
					}
				}
			}
		}
		if(!controllate.contains(temp)) {
			controllate.add(temp);
		}
		if(daControllare.contains(temp)) {
			daControllare.remove(temp);
		}
		if(daControllare.size() == 0) {
			return true;
		}
		else {
			return cercaUguali(daControllare.get(0), balls, controllate, daControllare);
		}
	}
	
	public boolean esisteAdiacente(Ball b, Ball temp) {
		// C'è a sinitra?
		if(temp.x-2 == b.x && temp.y == b.y) {
			return true;
		}
		// C'è a destra?
		else if(temp.x+2 == b.x && temp.y == b.y) {
			return true;
		}
		// C'è in alto a sinistra?
		else if(temp.x-1 == b.x && temp.y == b.y-2) {
			return true;
		}
		// C'è in alto a destra?
		else if(temp.x+1 == b.x && temp.y == b.y-2) {
			return true;
		}
		// C'è in basso a sinistra?
		else if(temp.x-1 == b.x && temp.y == b.y+2) {
			return true;
		}
		// C'è in basso a destra?
		else if(temp.x+1 == b.x && temp.y == b.y+2) {
			return true;
		}
		else {
			return false;
		}
	}
	
//	public boolean riposizionati(CopyOnWriteArrayList<Ball> balls) {
//		if(controllaDiagonale(balls, -1) && controllaDiagonale(balls, 1)){
//				return true;
//		}
//		else if(controllaDiagonale(balls, -1) && !controllaDiagonale(balls, 1)) {
//			this.translate(1, 2);
//			this.setCenter(center.x+1, center.y+2);
//			return riposizionati(balls);
//		}
//		else if(!controllaDiagonale(balls, -1) && controllaDiagonale(balls, 1)) {
//			this.translate(-1, 2);
//			this.setCenter(center.x+1, center.y+2);
//			return riposizionati(balls);
//		}
//		if(this.y == 32) {
//			return true;
//		}
//		//this.setStop(false);
//		//this.update2(balls);
//		//this.translate(0, 2);
//		//this.setCenter(center.x, center.y+2);
//		return riposizionati(balls);
//	}
//	public void posFinal(CopyOnWriteArrayList<Ball> balls) {
//		boolean sinistraOccupata = false;
//		boolean destraOccupata = false;
//		
//			for(Ball b: balls) {
//				if(this.y+this.getSpeed()<32) {
//				if(this.y+this.height==b.y) {
//					if(b.x == this.x-2 && b.y == this.y+2) {
//						sinistraOccupata = true;
//					}
//					if(b.x == this.x+2 && b.y == this.y+2) {
//						destraOccupata = true;	
//					}
//				}
//			}
//			if(sinistraOccupata && destraOccupata) {
//				this.translate(this.x,this.y);
//				this.setCenter(this.x,this.y);
//			}
//			
//			else if(sinistraOccupata) {
//				this.translate(this.x+2,this.y+2);
//				this.setCenter(this.x+2,this.y+2);
//			}
//			else if(destraOccupata) {
//				this.translate(this.x-2,this.y+2);
//				this.setCenter(center.x-2,center.y+2);
//			}
//			else {
//				this.translate(this.x+2,this.y+2);
//				this.setCenter(center.x+2,center.y+2);
//			}
//		}
//	}
	
	public int getColor() {
		return color;
	}

	public Point getCenter() {
		return center;
	}

	public boolean isCanMove() {
		return canMove;
	}

	public void setCanMove(boolean canMove) {
		this.canMove = canMove;
	}
	
	public void setCenter(Point center) {
		this.center = center;
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

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	@Override
	public String toString() {
		return this.x + "-" + this.y + "centro: " +  center.x + "-" + center.y;
	}
}
