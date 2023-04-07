package e_oop.pack2;

import e_oop.pack1.A;

public class D extends A{ // 상속 : 부모의 변수를 객체생성 없이 사용 가능.
	
	public void print() {
		System.out.println(a);
		System.out.println(b); // 다른패키지의 상속받은 클래스라서 가능
		System.out.println("");
//		System.out.println(c); // 접근제어자로 인해 사용 불가
//		System.out.println(d); // 접근제어자로 인해 사용 불가
	}
}
