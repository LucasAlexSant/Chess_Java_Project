package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

//Classe responsável por exibir o tabuleiro do jogo de xadrez no console
public class UI {

	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	// https://stackoverflow.com/questions/2979383/java-clear-the-console
	public static void clearScreen() { 
		System.out.print("\033[H\033[2J");  
		System.out.flush();  
		}  
	
	public static ChessPosition readChessPosition(Scanner sc) {
		try	{
		String s = sc.nextLine();
		char collumn = s.charAt(0);
		int row = Integer.parseInt(s.substring(1));
		return new ChessPosition(collumn, row);
		}
		catch (RuntimeException e) {
			throw new InputMismatchException("error reading ChessPosition. Valid values are from a1 to h8.");
		}
	}
	
	// Método estático para imprimir o tabuleiro com as peças de xadrez
	public static void printBoard(ChessPiece[][] pieces) {

		// Loop para percorrer sobre as linhas do tabuleiro
		for (int i = 0; i < pieces.length; i++) {
			// Imprime o número da linha (de 8 a 1, pois o tabuleiro é impresso de cima para
			// baixo)
			System.out.print((8 - i) + " ");

			// Loop para percorrer sobre as colunas do tabuleiro
			for (int j = 0; j < pieces.length; j++) {
				// Chama o método para imprimir a peça na posição atual
				printPiece(pieces[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}

	// Método privado para imprimir uma peça do tabuleiro
	private static void printPiece(ChessPiece piece) {
		if (piece == null) {
			System.out.print("-");
		} else {
			if (piece.getColor() == Color.WHITE) {
				System.out.print(ANSI_WHITE + piece + ANSI_RESET);
			} else {
				System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
			}
		}
		System.out.print(" ");
	}
}