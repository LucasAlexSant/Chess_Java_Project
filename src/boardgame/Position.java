package boardgame;

public class Position {

	private int row;
	private int collum;
	
	
	public Position(int row, int collum) {
		this.row = row;
		this.collum = collum;
	}


	public int getRow() {
		return row;
	}


	public void setRow(int row) {
		this.row = row;
	}


	public int getCollumn() {
		return collum;
	}


	public void setCollumn(int collum) {
		this.collum = collum;
	}	
	
	public void setValues(int row, int column) {
		this.row = row;
		this.collum = column;
	}
	
	@Override
	public String toString() {
		return row +", "+collum;
	}
	
}
