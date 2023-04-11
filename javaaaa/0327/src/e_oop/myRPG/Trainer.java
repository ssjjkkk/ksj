package e_oop.myRPG;

import java.util.Arrays;
import java.util.Scanner;

public class Trainer {
	String name;
	Pocketmon[] pocketmons; 
	Pocketmon fightPocketmon;
	Trainer(String name) {
		this.name = name;
		this.pocketmons = new Pocketmon[3];
	}

	public void showInfo() {
		System.out.println("================================================");
		System.out.println("이름 : " + name);
		System.out.println("----------------------포켓몬 ----------------------");
		for(int i = 0; i < pocketmons.length; i++) {
			if(pocketmons[i] != null) {
			System.out.println("포켓몬 이름 : " + pocketmons[i].name);
			System.out.print("레벨 : " + pocketmons[i].level);
			System.out.print(" 체력 " + pocketmons[i].hp + "/" + pocketmons[i].maxHp);
			System.out.print(" 마나 " + pocketmons[i].mp);
			System.out.print(" 공격력 " + pocketmons[i].att);
			System.out.print(" 방어력 " + pocketmons[i].def);
			System.out.println("");
			System.out.println("-----------------------------------------------");
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
		System.out.println(fightPocketmon.name + "가 공격으로 " + badPocketmon.name + "에게 " + damage + "만큼 데미지를 주었습니다.");
		System.out.println(badPocketmon.name + "의 남은 HP : " + badPocketmon.hp);
	}

	public void fightMon() {
		Scanner sc = new Scanner(System.in);
		System.out.println("내보낼 포켓몬을 골라주세요.");
		for(int i = 0; i < pocketmons.length; i++) {
			if(pocketmons[i] != null) {
				System.out.print(i + "." + pocketmons[i].name);	
			}
		}
		int input = 0;
		input = Integer.parseInt(sc.nextLine());
		
		fightPocketmon = pocketmons[input];
		System.out.println(pocketmons[input].name + "너로 정했다.");
	}

	public void getExp(int exp) {
		System.out.println(fightPocketmon + "이" + exp + "의 경험치를 획득하였습니다.");
		fightPocketmon.exp += exp;
		while(100 <= fightPocketmon.exp) {
			levelUp();
			fightPocketmon.exp -= 100;
		}
		
	}

	private void levelUp() {
		fightPocketmon.level++;
		fightPocketmon.maxHp += 10;
		fightPocketmon.maxMp += 5;
		fightPocketmon.att += 2;
		fightPocketmon.def += 2;
		fightPocketmon.hp = fightPocketmon.maxHp;
		fightPocketmon.mp = fightPocketmon.maxMp;
		System.out.println("LEVEL UP!!");
	}

	public void defence(Pocketmon badPocketmon) {
		int damage = badPocketmon.att - fightPocketmon.def;
		damage = damage <= 0 ? 1 : damage;
		fightPocketmon.hp = fightPocketmon.hp < damage ? fightPocketmon.hp - fightPocketmon.hp : fightPocketmon.hp - damage;
		System.out.println(badPocketmon.name + "가 공격으로 " + fightPocketmon.name + "에게 " + damage + "만큼 데미지를 주었습니다.");
		System.out.println(fightPocketmon.name + "의 남은 HP : " + fightPocketmon.hp);
		if(fightPocketmon.hp <= 0) {
			System.out.println(fightPocketmon + "이 죽었습니다.");
			System.exit(0);
		}
	}

}
