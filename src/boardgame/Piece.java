package boardgame;

public abstract class Piece {

	protected Position position;
	private Board board;
	
	
	public Piece(Board board) {
		this.board = board;
		// Inicializa o tabuleiro e a posição da peça como nula
		position = null;
	}

	// Método para obter o tabuleiro onde a peça está
	protected Board getBoard() {
		return board;
	}
	
	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getCollumn()];
	}
	
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for (int i = 0; i<mat.length; i++) {
			for (int j = 0; j<mat.length; i++ ) {
				if (mat[i][j])  {
					return true;
				}
			}
		}
		return false;
	}
	
}
