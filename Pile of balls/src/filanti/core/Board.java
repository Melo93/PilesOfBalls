package filanti.core;

public class Board {
	private int board[][];
	private final int COL=31;
	private final int ROW=40;
	
	public Board() {
		board=new int [COL*2][ROW*2];
	}

	public void fillBoard(int x, int y, int color ) {
		for(int i=x;i<GameConfig.BALL_HEIGHT+x;i++) {
			for(int j=y;j<GameConfig.BALL_WIDTH+y;j++) {
				board[i][j]=color;
			}
		}
	}
	
	public void clearPosition(int x, int y) {
		for(int i=x;i<GameConfig.BALL_HEIGHT+x;i++) {
			for(int j=y;j<GameConfig.BALL_WIDTH+y;j++) {
				board[i][j]=0;
			}
		}
	}
	
	public boolean checkPosition(int x, int y) {
		for(int i=x;i<GameConfig.BALL_HEIGHT+x;i++) {
			for(int j=y;j<GameConfig.BALL_WIDTH+y;j++) {
				if(board[i][j]!=0) return false;
			}
		}
		return true;
	}

	public void print() {
		for(int i=0;i<ROW*2;i++) {
			for(int j=0;j<COL*2;j++) {
				System.out.print(board[j][i] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public int getCOL() {
		return COL;
	}

	public int getROW() {
		return ROW;
	}
	
	
	

}
