package e_oop.pack1;

public class A {
	public int a = 1;		// public 접근제어자가 붙은 변수, 메서드는 어떤 클래스에서라도 접근이 가능하다.
	protected int b = 2;	// protected 접근제어자가 붙은 변수, 메서드는 동일 패키지의 클래스 또는 해당 클래스를 상속받은 다른 패키지의 클래스에서만 접근 가능.
	int c = 3;				// (default)가 생략된 형태. 접근제어자가 없는 변수, 메서드는 default 접근제어자가 되어 해당 패키지 내에서만 접근 가능.
	private int d = 4;  	// private 접근제어자가 붙은 변수, 메서드는 해당 클래스 에서만 접근이 가능하다.
	
	public void print() {
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println("");
	}
	
	
	
	
	
}
