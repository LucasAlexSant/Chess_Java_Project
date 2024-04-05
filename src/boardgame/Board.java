package boardgame;

public class Board {

	private int rows;
	private int collumns;
    // Matriz para representar as peças no tabuleiro
	private Piece[][] pieces;
	
	
	
	public Board(int rows, int collumns) {
		// Inicializa o número de linhas e colunas
		this.rows = rows;
		this.collumns = collumns;
		
        // Inicializa a matriz de peças com o tamanho especificado
		pieces = new Piece[rows][collumns];
	}


	public int getRows() {
		return rows;
	}


	public void setRows(int rows) {
		this.rows = rows;
	}


	public int getCollumns() {
		return collumns;
	}


	public void setCollumns(int collumns) {
		this.collumns = collumns;
	}
	
	// Método para obter uma peça em uma posição específica do tabuleiro
	public Piece piece(int row, int collumn) {
	    return pieces[row][collumn];
	}
	
	// Método para obter uma peça em uma posição específica do tabuleiro usando uma posição
	public Piece piece(Position position) {
		
		return pieces[position.getRow()][position.getCollumn()];
		
	}
	
	public void placePiece(Piece piece, Position position) {
		pieces[position.getRow()][position.getCollumn()] = piece;
		piece.position = position;
	}
	
}
