package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

	private Board board;

	public ChessMatch() {
		// Inicializa o tabuleiro com as dimensões padrão de um tabuleiro de xadrez (8x8)
		board = new Board(8, 8); 
		initialSetup();
	}

	// Método para obter as peças do tabuleiro de xadrez
	public ChessPiece[][] getPieces() {
		// Cria uma matriz para armazenar as peças
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getCollumns()];
		// percorre sobre todas as células do tabuleiro
		for (int i=0; i<board.getRows(); i++) {
			for (int j=0; j<board.getCollumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
				// Converte as peças genéricas em peças de xadrez
			}
		}
		// Retorna a matriz de peças
		return mat;
	}
	
	private void initialSetup() {
		
		board.placePiece(new Rook(board, Color.WHITE), new Position(2,1));
		board.placePiece(new King(board, Color.BLACK), new Position(0,4));
		board.placePiece(new King(board, Color.WHITE), new Position(7,4));

	}
	
}
