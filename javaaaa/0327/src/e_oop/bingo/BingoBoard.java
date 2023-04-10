package e_oop.bingo;

import java.util.Arrays;

public class BingoBoard {
	
	int[][] board = new int[5][5];
	int[][] hideBoard = new int[5][5];
	
	void printBoard() {
		for(int i = 0; i < hideBoard.length; i++) {
			System.out.print(Arrays.toString(hideBoard[i]));
			System.out.println("");
		}
	}
	
	void bingoRandom() {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				board[i][j] = (int)(Math.random() * 25 + 1);
			}
		}
	}
	
	
	
	
}
