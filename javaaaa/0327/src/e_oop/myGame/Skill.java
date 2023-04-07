package e_oop.myGame;

public class Skill {

	String[] skills = {"구걸하기", "춤추기", "노래하기", "불쇼", "팬텀마임"};
	
	String skillInfoList(int level) {
		String skillList = " ";
		for (int i = 0; i < level; i++) {
			skillList += (i + 1) + ". " + skills[i] + " ";
		}
		return skillList;
	}

	public int skillUtill(int input) {
		int money = 0;
		if(input == 0) {
			money += 1000;
		}else if(input == 1) {
			money += 5000;
		}else if(input == 2) {
			money += 10000;
		}else if(input == 3) {
			money += 50000;
		}else if(input == 4) {
			money += 100000;
		}
		return money;
	}
	
	
}
