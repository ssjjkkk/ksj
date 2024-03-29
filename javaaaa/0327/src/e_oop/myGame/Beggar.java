package e_oop.myGame;

import java.util.Scanner;

public class Beggar {
	
	String name;				// 이름
	double money;				// 돈
	double levelUpMoney;		// 레벨업에 필요한 돈
	int level;					// 레벨
	Skill sk = new Skill();
	String[] a = sk.skills;
	
	Beggar(String name, double money, int level) {
		this.name = name;
		this.money = money;
		this.level = level;
		this.levelUpMoney = 5000;
	}

	public void showInfo() {
		System.out.println("===============================================");
		System.out.println("----------------------상 태----------------------");
		System.out.println("이름 : " + name);
		System.out.println("레벨 : " + level);
		System.out.println("자산 : " + money + "원");
		System.out.println("-----------------------------------------------");
		System.out.println("===============================================");
		
	}

	public void getMoneyManagerList() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("0. 뒤로가기");
			System.out.println(sk.skillInfoList(this.level));
			
			int input = Integer.parseInt(sc.nextLine());
			if (input > 0 && input <= this.level) {
				money += sk.skillUtill(input - 1);
				System.out.println("\n 자산 : " + money + "원");
				
//				this.levelUpMoney = 5000;
				System.out.println("레벨업 자산 : " + levelUpMoney + "원");
				
				this.level = levelUp();
			}else if (input > this.level) {
				System.out.println("현재 레벨에서 할 수 없습니다!!");
			}else if (input == 0) {
				break;
			}
		}
	}

	int levelUp() {
		if(this.level == 1 && money >= levelUpMoney) {
			this.level++;
			this.money = this.money - this.levelUpMoney;
			this.levelUpMoney = 50000;
			System.out.println(this.level + "level 이 되셨습니다!");
		}else if(this.level == 2 && money >= levelUpMoney) {
			this.level++;
			this.money = this.money - this.levelUpMoney;
			this.levelUpMoney = 100000;
			System.out.println(this.level + "level 이 되셨습니다!");
		}else if(this.level == 3 && money >= levelUpMoney) {
			this.level++;
			this.money = this.money - this.levelUpMoney;
			this.levelUpMoney = 300000;
			System.out.println(this.level + "level 이 되셨습니다!");
		}else if(this.level == 4 && money >= levelUpMoney) {
			this.level++;
			this.money = this.money - this.levelUpMoney;
			System.out.println(this.level + "level 이 되셨습니다!");
		}
		return this.level;
	}
	
	
}
