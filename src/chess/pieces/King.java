package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	private ChessMatch chessMatch;

	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}

	private boolean testRookCastlig(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getmoveCount() == 0;
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getCollumns()];

		Position p = new Position(0, 0);

		// acima
		p.setValues(position.getRow() - 1, position.getCollumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCollumn()] = true;

		}

		// abaixo
		p.setValues(position.getRow() + 1, position.getCollumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCollumn()] = true;

		}

		// esquerda
		p.setValues(position.getRow(), position.getCollumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCollumn()] = true;

		}

		// direita
		p.setValues(position.getRow(), position.getCollumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCollumn()] = true;

		}

		// noroeste
		p.setValues(position.getRow() - 1, position.getCollumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCollumn()] = true;

		}

		// nordeste
		p.setValues(position.getRow() - 1, position.getCollumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCollumn()] = true;

		}

		// sudoeste
		p.setValues(position.getRow() + 1, position.getCollumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCollumn()] = true;

		}

		// sudeste
		p.setValues(position.getRow() + 1, position.getCollumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCollumn()] = true;

		}

		// specialMove Castling
		if (getmoveCount() == 0 && !chessMatch.getCheck()) {
			// castling lado rei
			Position posT1 = new Position(position.getRow(), position.getCollumn() + 3);
			if (testRookCastlig(posT1)) {
				Position p1 = new Position(position.getRow(), position.getCollumn() + 1);
				Position p2 = new Position(position.getRow(), position.getCollumn() + 2);
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
					mat[position.getRow()][position.getCollumn() + 2] = true;
				}

			}

			// castling lado rainha
			Position posT2 = new Position(position.getRow(), position.getCollumn() - 4);
			if (testRookCastlig(posT2)) {
				Position p1 = new Position(position.getRow(), position.getCollumn() - 1);
				Position p2 = new Position(position.getRow(), position.getCollumn() - 2);
				Position p3 = new Position(position.getRow(), position.getCollumn() - 3);
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
					mat[position.getRow()][position.getCollumn() - 2] = true;
				}

			}

		}
		return mat;

	}

}
