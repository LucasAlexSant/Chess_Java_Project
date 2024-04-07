package boardgame;

public class Board {

	private int rows;
	private int collumns;
    // Matriz para representar as peças no tabuleiro
	private Piece[][] pieces;
	
	
	
	public Board(int rows, int collumns) {
		// Inicializa o número de linhas e colunas que tem que ser pelo menos 1
		if(rows < 1 || collumns < 1 ) {
			throw new BoardException("error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.collumns = collumns;
		
        // Inicializa a matriz de peças com o tamanho especificado
		pieces = new Piece[rows][collumns];
	}


	public int getRows() {
		return rows;
	}

	
	public int getCollumns() {
		return collumns;
	}

	
	// Método para obter uma peça em uma posição específica do tabuleiro
	public Piece piece(int row, int collumn) {
		if (!positionExists(row,collumn)) {
			throw new BoardException("Position not on the board");
		}
	    return pieces[row][collumn];
	}
	
	// Método para obter uma peça em uma posição específica do tabuleiro usando uma posição
	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getCollumn()];
		
	}
	
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		pieces[position.getRow()][position.getCollumn()] = piece;
		piece.position = position;
	}
	
	private boolean positionExists(int row, int collumn) {
		return row >= 0  && row < rows && collumn >= 0 && collumn < collumns;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getCollumn());
		
	}
	
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
		
	}
	
}
