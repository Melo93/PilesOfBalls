package filanti.core;

import java.util.ArrayList;

import filanti.updater.Updater;
/*
 * 1)accertata collisione
 * 2)scoperta di chi si è permesso
 * 3)chi si è permesso avrà il lock sulla nuova posizione giusta
 * 4)controllo collisione altre palline, nel caso di non collisione, discesa
 */
public class GameManager {
	private static GameManager instance;

	public static GameManager getInstance() {
		if(instance==null) {
			instance=new GameManager();
		}
		return instance;
	}
	
	private Board board;
	private TrisBalls current;
	private TrisBalls next;
	private Updater update;
	private ArrayList<Ball> balls;
	private Ball tempB1;
	private Ball tempB2;
	private Ball tempB3;
	
	
	private GameManager() {
		board=new Board();
		balls=new ArrayList<>();
		current=new TrisBalls(board, 1);
		next=new TrisBalls(board, 0);
		tempB1=null;
		tempB2=null;
		tempB3=null;
		update=new Updater();
		update.start();
		
	}
	
	public void update() {

		if(checkCollision(current.getB1())){
			current.setStop(true);
			Ball temp=findCollisionBall(current.getB1());
			findPosition(current.getB1(),temp);
		}
		if(checkCollision(current.getB2())){
			current.setStop(true);
			Ball temp=findCollisionBall(current.getB2());
			findPosition(current.getB2(),temp);
		}
		if(checkCollision(current.getB3())){
			current.setStop(true);
			Ball temp=findCollisionBall(current.getB3());
			findPosition(current.getB3(),temp);
		}
		
		current.fall(board);
		if(current.isStop()) change();
		
		
	}
	

	

	private Ball findCollisionBall(Ball p) {
		for(Ball b:balls) {
			if(p.intersect(b)) {
				return b;
			}
		}
		return null;
	}

	private void findPosition(Ball p, Ball temp) {
		if(p.getCenter().x<=temp.getCenter().x) {
			board.clearPosition(p.x, p.y);
			p.translate(p.getSpeed()+1, -1);
			p.setCenter(p.getCenter().x+p.getSpeed()+1, p.getCenter().y-1);
			board.fillBoard(p.x, p.y, p.getColor());
		}
		else if(p.getCenter().x>temp.getCenter().x) {
			board.clearPosition(p.x, p.y);
			p.translate(p.getSpeed()+1, 1);
			p.setCenter(p.getCenter().x+p.getSpeed()+1, p.getCenter().y-1);
			board.fillBoard(p.x, p.y, p.getColor());
		}
	}

	private boolean checkCollision(Ball p) {
		for(Ball b:balls) {
			if(p.intersect(b)) {
				return true;
			}
		}
		return false;
	}

	private void change() {
		balls.add(current.getB1());
		balls.add(current.getB2());
		balls.add(current.getB3());
		current=null;
		current=next;
		current.setStatus(1);
		current.setPositionTrisBall(board);
		next=new TrisBalls(board, 0);
		
	}

	public void print() {
		board.print();
		System.out.println();
		for(Ball b:balls) {
			System.out.println(b.x + " "+ b.y);
		}
		
	}
	
	public static void main(String[] args) {
		GameManager.getInstance();
	}
	
}
