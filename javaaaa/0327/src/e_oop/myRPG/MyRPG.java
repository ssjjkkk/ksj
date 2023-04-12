package e_oop.myRPG;

import java.util.Arrays;
import java.util.Scanner;


public class MyRPG {
	Trainer t;
	Pocketmon[] pocketmons;
	Item[] items;
	static Scanner sc = new Scanner(System.in);
	
	MyRPG() {
		t = new Trainer("지우");
		
		pocketmons = new Pocketmon[6];
		pocketmons[0] = new Pocketmon("피카츄", 200, 200, 30, 5);
		pocketmons[1] = new Pocketmon("파이리", 200, 200, 32, 3);
		pocketmons[2] = new Pocketmon("꼬부기", 200, 200, 29, 6);
		pocketmons[3] = new Pocketmon("이상해씨", 180, 180, 28, 7);
		pocketmons[4] = new Pocketmon("버터풀", 170, 170, 33, 2);
		pocketmons[5] = new Pocketmon("구구", 180, 180, 32, 5);
		
		items = new Item[3];
		items[0] = new Item("회복약", 50, 0);
		items[1] = new Item("고급 회복약", 70, 0);
		items[2] = new Item("이상한 사탕", 0, 70);
	}
	
	public static void main(String[] args) {
		
		new MyRPG().start();
	}

	private void start() {
		firstGetPocketmon();
		while(true) {
			System.out.println("1.내정보\t2.배틀\t3.아이템사용\t9.종료");
			int input = 0;
			input = Integer.parseInt(sc.nextLine());
			switch(input) {
			case 1 :
				t.showInfo();
				break;
			case 2 :
				battle();
				break;
			case 3:
				t.useItem();
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
			System.out.println("1.공격\t2.아이템사용\t3.내정보\t4.도망");
			input = Integer.parseInt(sc.nextLine());
			switch(input) {
			case 1:
				t.attack(badPocketmon);
				if(badPocketmon.hp <= 0) {
					System.out.println(badPocketmon.name + "을(를) 쓰러트렸습니다.");
					t.getExp(30);
					Item dItem = items[(int)(Math.random() * items.length)];
					t.getItem(dItem);
					t.getPocketmon(badPocketmon);
					badPocketmon.hp = badPocketmon.maxHp;
					break battle1;
				}
				t.defence(badPocketmon);
				if(t.fightPocketmon.hp <= 0) {
					System.out.println(t.fightPocketmon.name + "(이)가 쓰러졌습니다.");
					t.fightPocketmon.hp = 1;
					System.out.println(t.fightPocketmon.name + "이 50의 경험치를 분실 하였습니다.");
					t.fightPocketmon.exp -= 50;
					System.out.println("야생의 " + badPocketmon.name + "(이)가 피를 흘리며 도망갔습니다.");
					badPocketmon.hp += 70;
					break battle1;
				}
				break;
			case 2:
				t.useItem();
				break;
			case 3 :
				t.showInfo();
				break;
			case 4:
				System.out.println(badPocketmon.name + "에게서 도망갔습니다.");
				break battle1;
			}
		}		
	}
	
	

	

	public void firstGetPocketmon() {
		System.out.println("첫번째 포켓몬을 정해주세요.");
		for(int i = 0; i < pocketmons.length; i++) {
			if(pocketmons[i] != null) {
				System.out.print(i+1 + "." + pocketmons[i].name + " / ");	
			}
		}
		int input = 0;
		input = Integer.parseInt(sc.nextLine());
		Pocketmon pocketmon = pocketmons[input-1];
		t.firstGetPmon(pocketmon);
		System.out.println(pocketmons[input-1].name + "을 획득하였습니다.");
	}
	

}
