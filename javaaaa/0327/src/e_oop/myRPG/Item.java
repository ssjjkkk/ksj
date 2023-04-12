package e_oop.myRPG;

public class Item {
	String name;
	int hp;
	int exp;
	

	Item(String name, int hp, int exp) {
		this.name = name;
		this.hp = hp;
		this.exp = exp;
	}

	public String itemInfo() {
		String info = name + " : ";
		if (hp > 0) info += "체력회복 " + hp;	
		if (exp > 0) info += "경험치 획득 " + exp;
		return info;
	}
}
