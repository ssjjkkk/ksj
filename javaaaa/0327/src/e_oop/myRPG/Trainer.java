package e_oop.myRPG;

import java.util.Arrays;
import java.util.Scanner;

public class Trainer {
	String name;
	Pocketmon[] pocketmons; 
	Pocketmon fightPocketmon;
	Item[] items;
	Trainer(String name) {
		this.name = name;
		this.pocketmons = new Pocketmon[6];
		this.items = new Item[5];
	}

	public void showInfo() {
		System.out.println("================================================");
		System.out.println("이름 : " + name);
		System.out.println("----------------------포켓몬 ----------------------");
		for(int i = 0; i < pocketmons.length; i++) {
			if(pocketmons[i] != null) {
			System.out.println("포켓몬 이름 : " + pocketmons[i].name);
			System.out.print("레벨 : " + pocketmons[i].level);
			System.out.print(" 경험치 " + pocketmons[i].exp);
			System.out.print(" 체력 " + pocketmons[i].hp + "/" + pocketmons[i].maxHp);
			System.out.print(" 공격력 " + pocketmons[i].att);
			System.out.print(" 방어력 " + pocketmons[i].def);
			System.out.println("");
			System.out.println("-----------------------------------------------");
			}
		}
		System.out.println("----------------------아이템 ----------------------");
		for(int i = 0; i < items.length; i++) {
			if(items[i] != null) {
				System.out.println(items[i].name + " : hp" + items[i].hp + " 회복");
			}
		}
		System.out.println("================================================");
	}

	public void firstGetPmon(Pocketmon pocketmon) {
		pocketmons[0] = pocketmon;
	}

	public void attack(Pocketmon badPocketmon) {
		int damage = fightPocketmon.att - badPocketmon.def;
		damage = damage <= 0 ? 1 : damage;
		badPocketmon.hp = badPocketmon.hp < damage ? badPocketmon.hp - badPocketmon.hp : badPocketmon.hp - damage;
		System.out.println(fightPocketmon.name + "(이)가 공격으로 " + badPocketmon.name + "에게 " + damage + "만큼 데미지를 주었습니다.");
		System.out.println(badPocketmon.name + "의 남은 HP : " + badPocketmon.hp);
	}

	public void fightMon() {
		Scanner sc = new Scanner(System.in);
		System.out.println("내보낼 포켓몬을 골라주세요.");
		for(int i = 0; i < pocketmons.length; i++) {
			if(pocketmons[i] != null) {
				System.out.print(i+1 + "." + pocketmons[i].name);	
			}
		}
		System.out.println("");
		int input = 0;
		input = Integer.parseInt(sc.nextLine());
		
		fightPocketmon = pocketmons[input-1];
		System.out.println(fightPocketmon.name + "너로 정했다.");
	}

	public void getExp(int exp) {
		System.out.println(fightPocketmon.name + "(이)가" + exp + "의 경험치를 획득하였습니다.");
		fightPocketmon.exp += exp;
		while(100 <= fightPocketmon.exp) {
			levelUp();
			fightPocketmon.exp -= 100;
		}
	}

	private void levelUp() {
		fightPocketmon.level++;
		fightPocketmon.maxHp += 10;
		fightPocketmon.att += 2;
		fightPocketmon.def += 2;
		fightPocketmon.hp = fightPocketmon.maxHp;
		System.out.println("LEVEL UP!!");
	}

	public void defence(Pocketmon badPocketmon) {
		int damage = badPocketmon.att - fightPocketmon.def;
		damage = damage <= 0 ? 1 : damage;
		fightPocketmon.hp = fightPocketmon.hp < damage ? fightPocketmon.hp - fightPocketmon.hp : fightPocketmon.hp - damage;
		System.out.println(badPocketmon.name + "(이)가 공격으로 " + fightPocketmon.name + "에게 " + damage + "만큼 데미지를 주었습니다.");
		System.out.println(fightPocketmon.name + "의 남은 HP : " + fightPocketmon.hp);
		
	}

	public void getPocketmon(Pocketmon badPocketmon) {
		for(int i = 0; i < pocketmons.length; i++) {
			if(pocketmons[i] == null) {
				pocketmons[i] = badPocketmon;
				System.out.println(badPocketmon.name + "을 잡았습니다.");
				break;
			}
		}
		
	}

	public void getItem(Item dItem) {
		if(dItem != null) {
			for(int i = 0; i < items.length; i++) {
				if(items[i] == null) {
					items[i] = dItem;
					System.out.println(dItem.name + "을 획득하였습니다.");
					break;
				}
			}
		}
	}

	public void useItem() {
		for(int k = 0; k < items.length; k++) {
			if(items[k] != null) {
				Scanner sc = new Scanner(System.in);
				for(int i = 0; i < items.length; i++) {
					if(items[i] != null) {
						System.out.print(i+1 + "." + items[i].name + ": hp회복 " + items[i].hp + "/ ");
					}
				}
				System.out.println("");
				int input = 0;
				input = Integer.parseInt(sc.nextLine());
				Item usedItem = items[input-1];
				System.out.println("사용할 포켓몬을 선택해주세요.");
				for(int i = 0; i < pocketmons.length; i++) {
					if(pocketmons[i] != null) {
					System.out.println(i+1 + "." + pocketmons[i].name);
					System.out.print(" 경험치 " + pocketmons[i].exp);
					System.out.print(" 체력 " + pocketmons[i].hp + "/" + pocketmons[i].maxHp);
					System.out.print(" 공격력 " + pocketmons[i].att);
					System.out.print(" 방어력 " + pocketmons[i].def);
					System.out.println("");
					System.out.println("-----------------------------------------------");
					}
				}
				int input1 = 0;
				input1 = Integer.parseInt(sc.nextLine());
				pocketmons[input1-1].hp = pocketmons[input1-1].hp + usedItem.hp < pocketmons[input1-1].maxHp ? pocketmons[input1-1].hp + usedItem.hp : pocketmons[input1-1].maxHp;
				pocketmons[input1-1].exp += usedItem.exp; 
				items[input-1] = null;
				System.out.println(usedItem.name + "(를)을 " + pocketmons[input1-1].name + "에게 사용했습니다.");
				break;
			}
		}		
	}
	

}









