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
	private boolean stopRip;
	public Ball( int color,int x, int y) {
		super(x,y,GameConfig.BALL_WIDTH,GameConfig.BALL_HEIGHT);
		this.speed=2;
		this.color=color;
		this.center=new Point((x+(x+GameConfig.BALL_WIDTH))/2,(y+(y+GameConfig.BALL_HEIGHT))/2);
		stop=false;
		canMove = true;
		stopRip=false;
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
			scoppia(balls,c);
		}
	}
		
	public boolean isCanMove() {
		return canMove;
	}

	public void setCanMove(boolean canMove) {
		this.canMove = canMove;
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

	public void riposizionati(CopyOnWriteArrayList<Ball> balls,Collision c) {
		while(!stopRip) {
			for(Ball b: balls) {
				if(b.y != 32) {
					findPosition(balls);
				}
			}
		}		
	}
	public void findPosition( CopyOnWriteArrayList<Ball> balls) {
		boolean left=false;
		boolean right=false;
		boolean center=false;
		stopRip = false;
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
			stopRip = true;
		}
		else if(right) {
			moveLeft();
		} else if(left) {
			moveRight();
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
				moveCenter(-1,0);
			} else if(rightC) {
				moveCenter(-2,2);
			} else {
				moveCenter(2, 2);
			}
		}
	}

	private void moveCenter(int dx, int dy) {
		this.translate(dx,dy);
		this.setCenter(center.x+dx,center.y+dy);
	}

	private void moveRight() {
		this.translate(1,2);
		this.setCenter(center.x+1,center.y+2);
	}

	public void moveLeft() {
		this.translate(-1,2);
		this.setCenter(center.x-1,center.y+2);
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
	
	public void scoppia(CopyOnWriteArrayList<Ball> balls, Collision c) {
		for(Ball b: balls) {
			CopyOnWriteArrayList<Ball> controllate = new CopyOnWriteArrayList<>();
			CopyOnWriteArrayList<Ball> daControllare = new CopyOnWriteArrayList<>();
			daControllare.add(b);
			if(cercaUguali(b, balls, controllate, daControllare)) {
				if(controllate.size() >= 4) {
					balls.removeAll(controllate);
					//riposizionati(balls, c);
				}
			}
		}
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

	public int getColor() {
		return color;

	}

	public Point getCenter() {
		return center;
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
