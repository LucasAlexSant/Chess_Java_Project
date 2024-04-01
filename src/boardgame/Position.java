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
	
	@Override
	public String toString() {
		return row +", "+collum;
	}
	
}
