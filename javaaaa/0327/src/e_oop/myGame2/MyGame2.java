package e_oop.myGame2;

import java.util.Scanner;

public class MyGame2 {
	
	Character c;
	Item[] items;
	Scanner sc = new Scanner(System.in);
	
	MyGame2(){
		c = new Character("가렌", 500, 200, 500, 200, 20, 10);
		
		items = new Item[10];
		items[0] = new Item("무한의 대검", 0, 0, 10, 0);
		items[1] = new Item("가시갑옷", 0, 0, 0, 10);
	}

	public static void main(String[] args) {
		
		new MyGame2().start();
	
	}
	
	void start() {
		while(true) {
			System.out.println("1.내정보\t2.사냥\t3.종료");
			int input = 0;
			input = Integer.parseInt(sc.nextLine());
			
			switch (input) {
			case 1:
				c.showInfo();
				break;
			case 2:
				hunt();
				break;
			case 3:
				System.out.println("게임을 종료합니다.");
				System.exit(0);  // 프로그램을 종료시키는 메서드
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
		}
		
	}

	private void hunt() {
		Monster m = new Monster("고블린", 20, 10, 20, 10, 15, 10, new Item[] {items[0], items[1]});
		System.out.println(m.name + "를 만났습니다. 전투를 시작합니다.");
		
		int input = 0;
		battle : while(true) {
			System.out.println("1.공격\t2.도망");
			input = Integer.parseInt(sc.nextLine());
			switch(input) {
			case 1:
				c.attack(m);
				if(m.hp <= 0) {
					System.out.println(m.name + "을(를) 처치했습니다.");
					// 캐릭터가 경험치를 얻는다.
					c.getExp(150);
					// 아이템 드랍
					Item item = m.itemDrop();
					c.getItem(item);
					break battle;
				}
				m.attack(c);
				if(c.hp <= 0) {
					System.out.println(c.name + "이 죽었습니다.");
					System.exit(0);
				}
				break;
			case 2:
				break battle;
			}
		}
		
	}

}
