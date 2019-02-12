package filanti.core;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.concurrent.CopyOnWriteArrayList;



public class Ball extends Rectangle implements Cloneable{
	private static final long serialVersionUID = 1L;
	private int speed;
	private int color;
	private Point center;
	private boolean stop;
	private boolean isTrisball;

	public Ball( int color,int x, int y) {
		super(x,y,GameConfig.BALL_WIDTH,GameConfig.BALL_HEIGHT);
		this.speed=2;
		this.color=color;
		this.center=new Point((x+(x+GameConfig.BALL_WIDTH))/2,(y+(y+GameConfig.BALL_HEIGHT))/2);
		stop = false; 
		isTrisball = true;
	}

	public boolean checkCollision(CopyOnWriteArrayList<Ball> balls) {
		for(Ball b:balls) {
			if(this.collisione(b)) {
				return true;
			}
			else if(this.y == 30 ) {
				isTrisball=false;
				return true;
			}
		}
		return false;
	}

	public boolean posizioneFinaleTrovata(CopyOnWriteArrayList<Ball>balls) {
		if(this.controllaDiagonale(balls) || this.y == 30) {return true;}
		return false;
	}

	public boolean controllaDiagonale (CopyOnWriteArrayList<Ball>balls) {
		boolean r = false;
		boolean l = false;
		for(Ball b: balls) {
			if(this.y+height == b.y) {
				if(this.x+1 == b.x || this.x == 28) {r = true;}
				if(this.x-1 == b.x || this.x == 10) {l = true;}
			}
		}
		if(r && l) {return true;}
		return false;
	}
	private boolean collisione(Ball b) {
		if(this.y+this.height==b.y) {
			if((this.x==b.x || this.x+1==b.x || this.x-1==b.x) && !b.isTrisball()) {
				return true;}
		}
		return false;
	}

	public void update( CopyOnWriteArrayList<Ball> balls, TrisBalls tb) {
		if(!this.checkCollision(balls) && isTrisball) {
			this.fall(balls, tb);
			
		}
		else {
			//if(!this.posizioneFinaleTrovata(balls)) {
			this.findPosition(balls);
			//}
		}
	}

	private void controllaSuolo(CopyOnWriteArrayList<Ball> balls, TrisBalls tb) {

		if(this.y==30) {
			for(Ball b:balls) {
				for(Ball b1:balls) {
					if(this!=b && this!=b1 && b!=b1) {
						if(b.isTrisball && b1.isTrisball) {
							if(tb.getRotate()%2!=0) {
								if(this.x%2!=0 && b.x%2!=0 && this.x+2==b.x) {
									this.translate(-1, 0);
									this.setCenter(this.x+1,this.y+1);
									b.translate(1, 0);
									b.setCenter(b.x+1, b.y+1);
									break;
								}
								else if(this.x%2!=0 && b.x%2!=0 && this.x-2==b.x) {
									this.translate(1, 0);
									this.setCenter(this.x+1,this.y+1);
									b.translate(-1, 0);
									b.setCenter(b.x+1, b.y+1);
									break;
								}
								if(this.x%2!=0 && b1.x%2!=0 && this.x+2==b1.x) {
									this.translate(-1, 0);
									this.setCenter(this.x+1,this.y+1);
									b1.translate(1, 0);
									b1.setCenter(b1.x+1, b1.y+1);
									break;
								}
								else if(this.x%2!=0 && b1.x%2!=0 && this.x-2==b1.x) {
									this.translate(1, 0);
									this.setCenter(this.x+1,this.y+1);
									b1.translate(-1, 0);
									b1.setCenter(b1.x+1, b1.y+1);
									break;
								}
							}
							else if(tb.getRotate()%2==0) {

								 if(this.x%2!=0 && b1.x%2==0 && b.x%2==0) {
									if(this.x>19) {
										this.translate(-1, 0);
										b.translate(-1, 0);
										b1.translate(-1, 0);
										this.setCenter(this.x+1,this.y+1);
										b.setCenter(b.x+1,b.y+1);
										b1.setCenter(b1.x+1,b1.y+1);
										break;
									}
									else {
										this.translate(1, 0);
										b.translate(1, 0);
										b1.translate(1, 0);
										this.setCenter(this.x+1,this.y+1);
										b.setCenter(b.x+1,b.y+1);
										b1.setCenter(b1.x+1,b1.y+1);
										break;
									}
								}
							}
						}
					}
				}
			}
		}
		
	}



	private void fall( CopyOnWriteArrayList<Ball> balls,TrisBalls tb) {
		this.translate(0,this.getSpeed());
		this.setCenter(center.x,center.y+speed);
		this.controllaSuolo(balls,tb);
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
			isTrisball=false;
		}
		else if(right) {
			if(this.x > 10 && this.x < 28) {
				moveBall(-1,2);
			} 		
			isTrisball=false;
		}
		else if(left) {
			if(this.x > 10 && this.x < 28) {
				moveBall(1,2);
			}
			isTrisball=false;
		}
		else if(center) {
			boolean leftC=false;
			boolean rightC=false;
			for(Ball b:balls) {
				if((this.x+2==b.x || this.x == 10 || this.x == 28) && this.y+2==b.y) {rightC=true;}
				if ((this.x-2==b.x || this.x == 10 || this.x == 28)&&this.y+2==b.y) {leftC=true;}
			}
			if(leftC&&rightC) {
				//				if(this.x > 10 && this.x+2 <= 28) {
				//					moveBall(-1,0);
				//				}
				//				if(this.x >= 10 && this.x < 12) {
				//					moveBall(1, 0);
				//				}else if(this.x <= 28 && this.x>26) {
				//					moveBall(-1,0);
				//				}
				//				else {
				//					moveBall(1,0);
				//				}
				//				if(this.x == 10) {moveBall(1, 0);}
				//				else if (this.x == 28) {moveBall(-1,0);}
				if(this.x >= 10 && this.x < 18) {
					if(this.x == 11) { moveBall(-1,0);}
					else {moveBall(1,0);}
				}
				else{
					if(this.x == 27) { moveBall(1,0);}
					else {moveBall(-1,0);}
				}

			}
			else if(rightC) {
				if(this.x > 10 && this.x < 28) {
					moveBall(-1,0);
				}
				else if(this.x == 27) {
					moveBall(-1,0);
				}
				else if(this.x == 11) {
					moveBall(1,0);
				}
			}
			else if(leftC){
				if(this.x > 10 && this.x < 28) {
					moveBall(1, 0);
				}
				else if(this.x == 27) {
					moveBall(1,0);
				}
				else if(this.x == 11) {
					moveBall(-1,0);
				}
			}
			else {
				if(this.x == 11) {
					moveBall(1,0);
				}
				else if(this.x == 27){
					moveBall(-1,0);
				}
				else {
					if(this.x > 11 && this.x <= 18) {
						moveBall(1,0);
					}
					else {
						moveBall(-1, 0);
					}
				}
			}
			//			else if(leftC){
			//				if(this.x >= 10 && this.x+2 < 28) {
			//					moveBall(2, 2);
			//				}
			//			}
			//			else {
			//				moveBall(-1,0);
			//			}
			isTrisball=false;
		}
		else if(!left && !center && !right) {
			if(!this.checkCollision(balls)) {
				if(this.x >= 10 && this.x < 18) {
					moveBall(1,2);
				}
				else {
					moveBall(-1,2);
				}
			}
			isTrisball=false;
			//			if(this.y + height <= 28) {moveBall(-1,2);}
		}
	}

	private void moveBall(int dx, int dy) {
		this.translate(dx,dy);
		this.setCenter(center.x+dx,center.y+dy);
	}
	public void scoppia(CopyOnWriteArrayList<Ball> balls) {
		for(Ball b: balls) {
			CopyOnWriteArrayList<Ball> controllate = new CopyOnWriteArrayList<>();
			CopyOnWriteArrayList<Ball> daControllare = new CopyOnWriteArrayList<>();
			daControllare.add(b);
			if(cercaUguali(b, balls, controllate, daControllare)) {
				if(controllate.size() >= 4) {
					balls.removeAll(controllate);
					//for(Ball b1 : balls){
					//b1.setStop(false);
					//b1.findPosition(balls);
					//}
					//return true;
				}
			}
		}
		//return false;
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
	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
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

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public boolean isTrisball() {
		return isTrisball;
	}

	public void setTrisball(boolean isTrisball) {		this.isTrisball = isTrisball;
	}

	public void setPositionBall(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	
	public Ball clone() {
		Ball b=(Ball) super.clone();
		b.center=(Point) this.center.clone();
		return b;
	}
	
}
