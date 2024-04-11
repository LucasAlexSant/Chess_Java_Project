package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

//Classe que representa uma peça de xadrez, que é uma extensão da classe Piece
public abstract class ChessPiece extends Piece{

	private Color color;

	public ChessPiece(Board board, Color color) {
		// Chama o construtor da superclasse (Piece) e passa o tabuleiro como parâmetro
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	public ChessPosition getChessPosition() {
		return ChessPosition.fromPosition(position);
	}
	
	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p.getColor() != color;
	}
	
}
