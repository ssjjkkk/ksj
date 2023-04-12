package e_oop.myRPG;

public class Pocketmon {
	String name;
	int maxHp;
	int hp;
	int att;
	int def;
	int level;
	int exp;
	
	Pocketmon(String name, int maxHp, int hp, int att, int def) {
		this.name = name;
		this.maxHp = maxHp;
		this.hp = hp;
		this.att = att;
		this.def = def;
		this.level = 1;
		this.exp = 0;		
	}

	@Override
	public String toString() {
		return "Pocketmon [name=" + name + ", maxHp=" + maxHp + ", hp=" + hp 
				+ ", att=" + att + ", def=" + def + ", level=" + level + ", exp=" + exp + "]";
	}
	
	
	
}
