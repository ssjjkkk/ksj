package f_oop2;

public class Starcraft {

	public static void main(String[] args) {
		
		Marine marine = new Marine();
		Tank tank = new Tank();
		DropShip dropship = new DropShip();
		SCV scv = new SCV();
		
		scv.repair(tank);
		scv.repair(dropship);
		scv.repair(scv);
//		scv.repair(marine);
		

	}

}

class Unit {
	int hp; // 체력
	final int MAX_HP; // 최대 체력
	
	Unit(int hp) {
		MAX_HP = hp;
		this.hp = hp;
	}
}

class Marine extends Unit {
	
	Marine() {
		super(40);
	}
}

class Tank extends Unit implements Repairable {
	
	Tank() {
		super(150);
	}
}

class DropShip extends Unit implements Repairable {
	
	DropShip() {
		super(200);
	}
}

class SCV extends Unit implements Repairable {
	
	SCV() {
		super(50);
	}
	
	void repair(Repairable r) {
		if(r instanceof Unit) {   // Unit으로 형변환이 가능한지 확인
			Unit u = (Unit) r;
			while(u.hp <= u.MAX_HP) {
				u.hp++;
			}
		}
	}
	
}

interface Repairable {};












