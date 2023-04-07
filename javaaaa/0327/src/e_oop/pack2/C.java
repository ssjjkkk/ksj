package e_oop.pack2;

import e_oop.pack1.A;

public class C {
	
	public void print() {
		A a = new A(); // 객체생성 가능
		System.out.println(a.a);
		System.out.println("");
//		System.out.println(a.b); // 상속받은 다른패키지의 클래스거나 같은 패키지여야 함
//		System.out.println(a.c); // 같은 패키지여야 함
//		System.out.println(a.d); // private이라 해당클래스가 아니면 안됨
	}
}
