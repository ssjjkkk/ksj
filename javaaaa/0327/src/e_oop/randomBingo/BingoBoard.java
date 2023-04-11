package e_oop.randomBingo;

import java.util.Arrays;
import java.util.Scanner;

import d_array.Array;

public class BingoBoard {
	
	Scanner sc = new Scanner(System.in);
	
	int[][] board = new int[5][5];
	int[][] hideBoard = new int[5][5];
	String[][] prtBoard = new String[5][5];
	
	void boardScale() {
		int input = 0;
		System.out.println("1:1랜덤 빙고게임입니다. 플레이어A, B 모두 빙고를 완성하지 못하면 상대방의 숫자를 입력하여 뺏을 수 있습니다.");
		System.out.println("빙고판의 크기를 정해주세요.(?x?크기)");
		input = Integer.parseInt(sc.nextLine());
		board = new int[input][input];
		hideBoard = new int[input][input];
		prtBoard = new String[input][input];
	}
	
	
	void printBoard() {
		for(int i = 0; i < hideBoard.length; i++) {
			System.out.print(Arrays.toString(prtBoard[i]));
			System.out.print("  ");
			System.out.println("");
		}
	}
	
	void bingoCreate() {
		int input = 0;
		System.out.println("최대숫자의 범위를 정해주세요. (1부터 시작)");
		input = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				board[i][j] = (int)(Math.random() * input + 1);
			}
		}
		for(int i = 0; i < prtBoard.length; i++) {
			for(int j = 0; j < prtBoard[i].length; j++) {
				prtBoard[i][j] = "O";
			}
		}
	}

	
	
	
	
}
