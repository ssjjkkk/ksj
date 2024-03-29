package e_oop.myGame2;

public class Character {

	String name;
	int maxHp;
	int maxMp;
	int hp;
	int mp;
	int att;
	int def;
	int level;
	int exp;
	Item[] items;
	
	Character(String name, int maxHp, int maxMp, int hp, int mp, int att, int def) {
		this.name = name;
		this.maxHp = maxHp;
		this.maxMp = maxMp;
		this.hp = hp;
		this.mp = mp;
		this.att = att;
		this.def = def;
		this.level = 1;
		this.exp = 0;
		this.items = new Item[10];
	}

	public void showInfo() {
		System.out.println("================================================");
		System.out.println("----------------------상 태-----------------------");
		System.out.println("이름 : " + name);
		System.out.println("레벨 : " + level + "(" + exp + "/100)");
		System.out.println("체력 : " + hp + "/" + maxHp);
		System.out.println("마나 : " + mp + "/" + maxMp);
		System.out.println("공격 : " + att);
		System.out.println("방어 : " + def);
		System.out.println("----------------------아이템 ----------------------");
		for(int i = 0; i < items.length; i++) {
			if(items[i] != null) {
			System.out.println(items[i].itemInfo());
			}
		}
		
		
		
		System.out.println("================================================");
		
	}

	public void attack(Monster m) {
		int damage = att - m.def;
		damage = damage <= 0 ? 1 : damage;
		m.hp = m.hp < damage ? m.hp - m.hp : m.hp - damage;
		System.out.println(name + "가 공격으로 " + m.name + "에게 " + damage + "만큼 데미지를 주었습니다.");
		System.out.println(m.name + "의 남은 HP : " + m.hp);
		
		
	}

	public void getExp(int exp) {
		System.out.println(exp + "의 경험치를 획득하였습니다.");
		this.exp += exp;
		while(100 <= this.exp) {
			// 레벨업
			levelUp();
			this.exp -= 100;
		}
		
	}
	
	void levelUp() {
		level++;
		maxHp += 10;
		maxMp += 5;
		att += 2;
		def += 2;
		hp = maxHp;
		mp = maxMp;
		System.out.println("LEVEL UP!!");		
	}

	public void getItem(Item item) {
		System.out.println(item.name + "을 획득하였습니다.");
		for(int i = 0; i < items.length; i ++) {
			if(items[i] == null) {
				items[i] = item;
				break;
			}
		}
		// 바로 장착
		maxHp += item.hp;
		maxMp += item.mp;
		att += item.att;
		def += item.def;
	}
	
	
}
