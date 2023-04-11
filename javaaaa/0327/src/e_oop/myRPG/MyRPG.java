package e_oop.myRPG;

import java.util.Arrays;
import java.util.Scanner;


public class MyRPG {
	Trainer t;
	Pocketmon[] pocketmons;
//	Item[] items;
	static Scanner sc = new Scanner(System.in);
	
	MyRPG() {
		t = new Trainer("지우");
		
		pocketmons = new Pocketmon[3];
		pocketmons[0] = new Pocketmon("피카츄", 200, 5, 200, 2, 30, 5);
		pocketmons[1] = new Pocketmon("파이리", 200, 5, 150, 1, 32, 3);
		pocketmons[2] = new Pocketmon("꼬부기", 200, 0, 200, 0, 29, 6);
	}
	
	public static void main(String[] args) {
		
		
		new MyRPG().start();
		

	}

	private void start() {
		firstGetPocketmon();
		while(true) {
			System.out.println("1.내정보\t2.배틀\t9.종료");
			int input = 0;
			input = Integer.parseInt(sc.nextLine());
			switch(input) {
			case 1 :
				t.showInfo();
				break;
			case 2 :
				battle();
				break;
			case 9 :
				System.out.println("게임을 종료합니다.");
				System.exit(0);
				break;
			default :
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
		}
		
	}
	
	private void battle() {
		Pocketmon badPocketmon = pocketmons[(int)(Math.random() * 3 + 1)];
		System.out.println("야생의 " + badPocketmon.name + "가 나타났다!! 전투를 시작합니다.");
		t.fightMon();
		int input = 0;
		battle1 : while(true) {
//			t.fightMon();
			System.out.println("1.공격\t2.도망");
			input = Integer.parseInt(sc.nextLine());
			switch(input) {
			case 1:
				t.attack(badPocketmon);
				if(badPocketmon.hp <= 0) {
					System.out.println(badPocketmon.name + "을(를) 쓰러트렸습니다.");
					// 포켓몬 경험치
					t.getExp(150);
					break battle1;
				}
				t.defence(badPocketmon);
				
				break;
			case 2:
				System.out.println(badPocketmon.name + "에게서 도망갔습니다.");
				break battle1;
			}
		}		
	}
	
	

	public void firstGetPocketmon() {
		System.out.println("첫번째 포켓몬을 정해주세요. 1.피카츄 2.파이리 3.꼬부기");
		int input = 0;
		input = Integer.parseInt(sc.nextLine());
		Pocketmon pocketmon = pocketmons[input-1];
		t.firstGetPmon(pocketmon);
		System.out.println(pocketmons[input-1].name + "을 획득하였습니다.");
	}
	

}
