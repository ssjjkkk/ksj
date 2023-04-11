package e_oop.randomBingo;

import java.util.Scanner;

public class Bingo {
	static int player;
	static int turn;
	static int totalBingoCountA;
	static int totalBingoCountB;
	static int bingoCount;
	static BingoBoard b = new BingoBoard();

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		b.boardScale();
		System.out.println("완성할 빙고 개수를 정해주세요.");
		int complete = Integer.parseInt(sc.nextLine());
		b.bingoCreate();		
		
		turn = 0;
		while(true) {
			++turn;
			if(turn%2 == 1) {
				player = 1;
				System.out.println("플레이어A 턴");
			}
			if(turn%2 == 0) {
				player = 2;
				System.out.println("플레이어B 턴");
			}
			
			totalBingoCountA = 0;
			totalBingoCountB = 0;
			b.printBoard();
			new Bingo().bingoCheck1();
			new Bingo().bingoCheck2();
			if(totalBingoCountA >= complete) {
				System.out.println("플레이어A가 빙고 " + complete + "개 이상을 완성하였습니다.");
				break;
			}
			if(totalBingoCountB >= complete) {
				System.out.println("플레이어B가 빙고 " + complete + "개 이상을 완성하였습니다.");
				break;
			}
			new Bingo().inputNum();
		}


	}
	
	

	void inputNum() {
		System.out.println("숫자를 입력하여 빙고를 완성하세요. / 0을 누르면 종료 됩니다.");
		int input = 0;
		input = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < b.board.length; i++) {
			for(int j = 0; j < b.board.length; j++) {
				if(b.board[i][j] == input) {
					b.hideBoard[i][j] = b.board[i][j];
					if(player == 1) {
						b.prtBoard[i][j] = Integer.toString(b.hideBoard[i][j]) + "A";
					}
					if(player == 2) {
						b.prtBoard[i][j] = Integer.toString(b.hideBoard[i][j]) + "B";
					}
				}
			}
		}
		if(input == 0) {
			System.out.println("게임을 종료합니다.");
			System.exit(0);
		}
	}
	
	void bingoCheck1() {
		for(int i = 0; i < b.board.length; i++) {
			for(int j = 0; j < b.board.length; j++) {
				if(b.prtBoard[i][j].contains("A")) {
					bingoCount ++;
				}
			}
			if(bingoCount >= b.board.length) {
				totalBingoCountA ++;
				bingoCount = 0;
			}
			bingoCount = 0;
			for(int j = 0; j < b.board.length; j++) {
				if(b.prtBoard[i][j].contains("A")) {
					bingoCount ++;
				}
			}
			if(bingoCount >= b.board.length) {
				totalBingoCountA ++;
				bingoCount = 0;
			}
			bingoCount = 0;
			for(int j = 0; j < b.board.length; j++) {
				if(i + j ==b.board.length - 1) {
					if(b.prtBoard[i][j].contains("A")) {
						bingoCount ++;
					}
				}
			}
			if(bingoCount >= b.board.length) {
				totalBingoCountA ++;
				bingoCount = 0;
			}
			bingoCount = 0;
			for(int j = 0; j < b.board.length; j++) {
				if(i - j ==0) {
					if(b.prtBoard[i][j].contains("A")) {
						bingoCount ++;
					}
				}
			}
			if(bingoCount >= b.board.length) {
				totalBingoCountA ++;
				bingoCount = 0;
			}
			bingoCount = 0;
		}
		System.out.println("플레이어A 완성한 빙고 개수 : " + totalBingoCountA);
	}
	
	void bingoCheck2() {
		for(int i = 0; i < b.board.length; i++) {
			for(int j = 0; j < b.board.length; j++) {
				if(b.prtBoard[i][j].contains("B")) {
					bingoCount ++;
				}
			}
			if(bingoCount >= b.board.length) {
				totalBingoCountB ++;
				bingoCount = 0;
			}
			bingoCount = 0;
			for(int j = 0; j < b.board.length; j++) {
				if(b.prtBoard[i][j].contains("B")) {
					bingoCount ++;
				}
			}
			if(bingoCount >= b.board.length) {
				totalBingoCountB ++;
				bingoCount = 0;
			}
			bingoCount = 0;
			for(int j = 0; j < b.board.length; j++) {
				if(i + j ==b.board.length - 1) {
					if(b.prtBoard[i][j].contains("B")) {
						bingoCount ++;
					}
				}
			}
			if(bingoCount >= b.board.length) {
				totalBingoCountB ++;
				bingoCount = 0;
			}
			bingoCount = 0;
			for(int j = 0; j < b.board.length; j++) {
				if(i - j ==0) {
					if(b.prtBoard[i][j].contains("B")) {
						bingoCount ++;
					}
				}
			}
			if(bingoCount >= b.board.length) {
				totalBingoCountB ++;
				bingoCount = 0;
			}
			bingoCount = 0;
		}
		System.out.println("플레이어B 완성한 빙고 개수 : " + totalBingoCountB);
	}
	
	

}
