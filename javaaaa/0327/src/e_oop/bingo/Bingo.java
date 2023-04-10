package e_oop.bingo;

import java.util.Arrays;
import java.util.Scanner;

public class Bingo {
	static int player;
	static int turn;
	static int totalBingoCount;
	static int bingoCount;
	static BingoBoard b = new BingoBoard();

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		b.bingoRandom();
		
		while(true) {
			totalBingoCount = 0;
			bingoCount = 0;
			b.printBoard();
			new Bingo().bingoCheck();
			if(totalBingoCount >= 5) {
				System.out.println("빙고 5개를 완성했습니다.");
				break;
			}
			new Bingo().inputNum();
		}


	}
	
	void inputNum() {
		System.out.println("1 ~ 25의 숫자를 입력하여 빙고를 완성하세요. / 0을 누르면 종료 됩니다.");
		int input = 0;
		input = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < b.board.length; i++) {
			for(int j = 0; j < b.board.length; j++) {
				if(b.board[i][j] == input) {
					b.hideBoard[i][j] = b.board[i][j]; 
				}
			}
		}
		if(input == 0) {
			System.out.println("게임을 종료합니다.");
			System.exit(0);
		}
	}
	
	void bingoCheck() {
		for(int i = 0; i < b.board.length; i++) {
			for(int j = 0; j < b.board.length; j++) {
				if(b.hideBoard[i][j] != 0) {
					bingoCount ++;
				}
			}
			if(bingoCount >= b.board.length) {
				totalBingoCount ++;
				bingoCount = 0;
			}
			bingoCount = 0;
			for(int j = 0; j < b.board.length; j++) {
				if(b.hideBoard[j][i] != 0) {
					bingoCount ++;
				}
			}
			if(bingoCount >= b.board.length) {
				totalBingoCount ++;
				bingoCount = 0;
			}
			bingoCount = 0;
			for(int j = 0; j < b.board.length; j++) {
				if(i + j ==b.board.length - 1) {
					if(b.hideBoard[i][j] != 0) {
						bingoCount ++;
					}
				}
			}
			if(bingoCount >= b.board.length) {
				totalBingoCount ++;
				bingoCount = 0;
			}
			bingoCount = 0;
			for(int j = 0; j < b.board.length; j++) {
				if(i - j ==0) {
					if(b.hideBoard[i][j] != 0) {
						bingoCount ++;
					}
				}
			}
			if(bingoCount >= b.board.length) {
				totalBingoCount ++;
				bingoCount = 0;
			}
			bingoCount = 0;
		}
		System.out.println("완성한 빙고 개수 : " + totalBingoCount);
	}
	
	

}
