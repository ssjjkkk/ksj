package f_oop2;

class Product {
	String name;
	int price;
	
	Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	// 상품의 정보를 반환하는 메서드
	String getInfo() {
		return name + "(" + price + "원)";
	}
	
}

class Desktop extends Product {
	
	Desktop(String name, int price) {
		super(name, price);
	}
	
	void programming() {
		System.out.println("프로그램을 만듭니다.");
	}
	
}

class Aircon extends Product {
	
	Aircon(String name, int price) {
		super(name, price);
	}
	
	void setTemperature() {
		System.out.println("온도를 설정합니다.");
	}
	
}

class Moodlamp extends Product {

	Moodlamp(String name, int price) {
		super(name, price);
		
	}
	
	void setLight() {
		System.out.println("밝기를 조절합니다.");
	}
	
}

class Customer {
	
	int money = 10000000;
	Product[] item = new Product[100];
	
	void buy(Product p) {
		if(money < p.price) {
			System.out.println("금액이 부족합니다.");
			return;
		}
		money -= p.price;
		for(int i = 0; i < item.length; i++) {
			if(item[i] == null) {
				item[i] = p; 
				break;
			}
		}
		System.out.println(p.getInfo() + "를 구매했다.");
		
	}
	
	void ShowItem() {
		System.out.println("========== 장바구니 ==========");
		for(int i = 0; i < item.length; i++) {
			if(item[i] == null) { 
				break;
			}else {
				System.out.println(item[i].getInfo());
			}
		}
		System.out.println("남은돈 : " + money);
		System.out.println("===========================");
	}
}


public class Store {

	public static void main(String[] args) {
		
		Desktop d1 = new Desktop("삼성 컴퓨터", 1000000);
		Desktop d2 = new Desktop("애플 컴퓨터", 1500000);
		
		Aircon ac1 = new Aircon("삼성 에어컨", 1500000);
		Aircon ac2 = new Aircon("LG 에어컨", 1300000);
		
		Moodlamp m1 = new Moodlamp("삼성 무드등", 50000);
		Moodlamp m2 = new Moodlamp("LG 무드등", 50000);
		
		System.out.println(d1.getInfo());
		System.out.println(d2.getInfo());
		
		System.out.println(ac1.getInfo());
		System.out.println(ac2.getInfo());
		
		System.out.println(m1.getInfo());
		System.out.println(m2.getInfo());
		
		Customer c = new Customer();
		
		c.buy(d1);
		c.buy(ac2);
		c.buy(m1);
		
		c.ShowItem();

	}

}
