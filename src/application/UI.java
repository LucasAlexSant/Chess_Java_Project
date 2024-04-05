package application;

import chess.ChessPiece;

//Classe responsável por exibir o tabuleiro do jogo de xadrez no console
public class UI {

	// Método estático para imprimir o tabuleiro com as peças de xadrez
	public static void printBoard(ChessPiece[][] pieces) {
		
		// Loop para percorrer sobre as linhas do tabuleiro
		for (int i = 0; i < pieces.length; i++) {
			// Imprime o número da linha (de 8 a 1, pois o tabuleiro é impresso de cima para baixo)
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
        // Verifica se a peça é nula (caso não haja peça na posição)
        if (piece == null) {
            System.out.print("-");
        } else {
            // Imprime a representação da peça
            System.out.print(piece);
        }
        // Imprime um espaço após cada peça
        System.out.print(" ");
    }
}