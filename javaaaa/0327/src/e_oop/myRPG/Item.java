package e_oop.myRPG;

public class Item {
	String name;
	int hp;
	int mp;

	Item(String name, int hp, int mp) {
		this.name = name;
		this.hp = hp;
		this.mp = mp;
	}

	public String itemInfo() {
		String info = name + " : ";
		if (hp > 0) info += "체력회복 " + hp;
		if (mp > 0) info += "마나회복 " + mp;		
		return info;
	}
}
