package boardgame;

public class Piece {

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
	
	
	
}
