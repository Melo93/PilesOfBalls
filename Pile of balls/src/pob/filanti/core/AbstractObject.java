package pob.filanti.core;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractObject {
	protected String ID;
	private int row, col;
	List<AbstractObject> possibleMoves;
	AbstractObject[][] matrix;
	private boolean clicked = false;

	public AbstractObject(int row, int col, AbstractObject[][] matrix) {
		this.row = row;
		this.col = col;
		possibleMoves = new ArrayList<>();
		this.matrix = matrix;
	}

	public void calcolatePossibleMoves() {
		possibleMoves.clear();
		// Calcolo la mia riga
		if ((col >= 0) && (col <= 1) && (col + 3 < matrix.length)
				&& (!matrix[row][col + 1].getID().equals(this.getID()))
				&& (matrix[row][col + 2].getID().equals(this.getID()))
				&& (matrix[row][col + 3].getID().equals(this.getID()))) {
			possibleMoves.add(matrix[row][col + 1]);
		}

		if (col > 2 && col < matrix.length) {
			if (matrix[row][col - 2].getID().equals(this.getID()) && matrix[row][col - 3].getID().equals(this.getID())) {
				possibleMoves.add(matrix[row][col - 1]);
			}
			if ((col < (matrix.length - 3)) && matrix[row][col + 3].getID().equals(this.getID())
					&& matrix[row][col + 2].getID().equals(this.getID())) {
				possibleMoves.add(matrix[row][col + 1]);
			}
		}

		// Calcolo la mia colonna
		if ((row >= 0) && (row <= 1) && (row + 3 < matrix.length)
				&& (!matrix[row + 1][col].getID().equals(this.getID()))
				&& (matrix[row + 2][col].getID().equals(this.getID()))
				&& (matrix[row + 3][col].getID().equals(this.getID()))) {
			possibleMoves.add(matrix[row + 1][col]);
		}

		if (row > 2 && row < matrix.length) {
			if (matrix[row - 2][col].getID().equals(this.getID()) && matrix[row - 3][col].getID().equals(this.getID())) {
				possibleMoves.add(matrix[row - 1][col]);
			}
			if ((row < (matrix.length - 3)) && matrix[row + 3][col].getID().equals(this.getID())
					&& matrix[row + 2][col].getID().equals(this.getID())) {
				possibleMoves.add(matrix[row + 1][col]);
			}
		}

		// Calcolo riga precedente
		if (row > 0) {
			if ((col >= 0) && (col < matrix.length - 2) && (matrix[row - 1][col + 1].getID().equals(this.getID()))
					&& (matrix[row - 1][col + 2].getID().equals(this.getID()))) {
				possibleMoves.add(matrix[row - 1][col]);
			} else if ((col > 1) && (col < matrix.length) && (matrix[row - 1][col - 1].getID().equals(this.getID()))
					&& (matrix[row - 1][col - 2].getID().equals(this.getID()))) {
				possibleMoves.add(matrix[row - 1][col]);
			} else if ((col > 0) && (col < matrix.length - 1) && (matrix[row - 1][col - 1].getID().equals(this.getID()))
					&& (matrix[row - 1][col + 1].getID().equals(this.getID()))) {
				possibleMoves.add(matrix[row - 1][col]);
			}
		}
		// Calcolo riga successiva
		if (row < matrix.length - 1) {
			if ((col >= 0) && (col < matrix.length - 2) && (matrix[row + 1][col + 1].getID().equals(this.getID()))
					&& (matrix[row + 1][col + 2].getID().equals(this.getID()))) {
				possibleMoves.add(matrix[row + 1][col]);
			} else if ((col > 1) && (col < matrix.length) && (matrix[row + 1][col - 1].getID().equals(this.getID()))
					&& (matrix[row + 1][col - 2].getID().equals(this.getID()))) {
				possibleMoves.add(matrix[row + 1][col]);
			} else if ((col > 0) && (col < matrix.length - 1) && (matrix[row + 1][col - 1].getID().equals(this.getID()))
					&& (matrix[row + 1][col + 1].getID().equals(this.getID()))) {
				possibleMoves.add(matrix[row + 1][col]);
			}
		}

		// Calcolo colonna precedente
		if (col > 0) {
			if ((row >= 0) && (row < matrix.length - 2) && (matrix[row + 1][col - 1].getID().equals(this.getID()))
					&& (matrix[row + 2][col - 1].getID().equals(this.getID()))) {
				possibleMoves.add(matrix[row][col - 1]);
			} else if ((row > 1) && (row < matrix.length) && (matrix[row - 1][col - 1].getID().equals(this.getID()))
					&& (matrix[row - 2][col - 1].getID().equals(this.getID()))) {
				possibleMoves.add(matrix[row][col - 1]);
			} else if ((row > 0) && (row < matrix.length - 1) && (matrix[row - 1][col - 1].getID().equals(this.getID()))
					&& (matrix[row + 1][col - 1].getID().equals(this.getID()))) {
				possibleMoves.add(matrix[row][col - 1]);
			}
		}
		// Calcolo colonna successiva
		if (col < matrix.length - 1) {
			if ((row >= 0) && (row < matrix.length - 2) && (matrix[row + 1][col + 1].getID().equals(this.getID()))
					&& (matrix[row + 2][col + 1].getID().equals(this.getID()))) {
				possibleMoves.add(matrix[row][col + 1]);
			} else if ((row > 1) && (row < matrix.length) && (matrix[row - 1][col + 1].getID().equals(this.getID()))
					&& (matrix[row - 2][col + 1].getID().equals(this.getID()))) {
				possibleMoves.add(matrix[row][col + 1]);
			} else if ((row > 0) && (row < matrix.length - 1) && (matrix[row - 1][col + 1].getID().equals(this.getID()))
					&& (matrix[row + 1][col + 1].getID().equals(this.getID()))) {
				possibleMoves.add(matrix[row][col + 1]);
			}
		}

	}

	public boolean contains(AbstractObject obj) {
		if (possibleMoves.contains(obj)) {
			return true;
		} else {
			return false;
		}
	}

	public int getCol() {
		return col;
	}

	public String getID() {
		return ID;
	}

	public int getNumberPossibleMoves() {
		return possibleMoves.size();
	}

	public int getRow() {
		return row;
	}

	public boolean isClicked() {
		return clicked;
	}

	public void printPossibleMoves() {
		for (AbstractObject obj : possibleMoves) {
			System.out.println("Possible Moves Object " + this.row + ", " + this.col + "(" + this.getID() + "):"
					+ obj.getRow() + ", " + obj.getCol() + "(" + obj.getID() + ");");
		}
	}

	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public void setRow(int row) {
		this.row = row;
	}
}
