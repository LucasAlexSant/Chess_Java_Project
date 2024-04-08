package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "R";
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getCollumns()];
		
		Position p = new Position(0, 0);
		
		//acima
		p.setValues(position.getRow()-1, position.getCollumn());
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
			p.setRow(p.getRow()-1);
		}
		if(getBoard().positionExists(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		
		}
		
		
		//esquerda
		
		p.setValues(position.getRow(), position.getCollumn() -1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
			p.setCollumn(p.getCollumn()-1);
		}
		if(getBoard().positionExists(p)&& isThereAnyPossibleMove()) {
			mat[p.getRow()][p.getCollumn()] = true;
		}
		
		
		//direita
		
		p.setValues(position.getRow(), position.getCollumn() +1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
			p.setCollumn(p.getCollumn()+1);
		}
		if(getBoard().positionExists(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}
		
		
		//baixo
			p.setValues(position.getRow()+1, position.getCollumn());
			while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getCollumn()] = true;
				p.setRow(p.getRow()+1);
			}
			if(getBoard().positionExists(p)) {
				mat[p.getRow()][p.getCollumn()] = true;
				
			}
		
		
		return mat;
	}
}
