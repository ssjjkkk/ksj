package e_oop;

public class VariableInit {
	
	// 멤버 변수 초기화
	int var = 10; 				 // 인스턴스 변수
	static int staticVar = 20;   // 클래스 변수
	/*
	 * 생성자
	 * - 클래스와 같은 이름의 메서드
	 * - 인스턴스 변수를 초기화하기 위해 사용한다.
	 * - 클래스에 생성자는 반드시 하나 이상 존재해야 한다.
	 * - 직접 선언해주지 않으면 컴파일러가 기본 생성자를 만들어준다.
	 * - 생성자는 리턴타입이 없다.
	 */

	VariableInit() {
		var = 50;
		staticVar = 60;
		// 값을 공유해야하는 클래스 변수가 객체 생성 시 마다 계속 초기화되기 때문에 클래스 변수를 생성자에게 초기화 하는 것은 좋지 않다.
		
		// 생성자 사용 이유
		// 초기화에 여러줄의 코드가 필요할 때
		// 초기화에 파라미터가 필요할 때
	}
	
	public static void main(String[] args) {
		Init i = new Init();
		System.out.println(i.a);
		Init i2 = new Init();
		i2.a = 40;
		i2.b = 50;
		i2.c = 60;
		
		Init i3 = new Init(70, 80, 90);
		
	}

}

class Init {
	int a;
	int b;
	int c;
	
	Init(int a, int b, int c) {
		this.a = a; // 전역 변수를 사용하기 위해서 this를 붙인다. 변수의 이름이 같을 때 구분하기 위해 사용한다.
		this.b = b; // this는 클래스에 있는 객체의 주소를 저장하고 있는 하나의 변수
		this.c = c; // 앞의 c는 클래스의 변수. 뒤의 c는 파라미터 변수
		// this : 인스턴스 변수와 지역변수의 이름이 같을 때 둘을 구분하기 위해 사용한다.
	}
	
	// 오버로딩 : 같은 이름의 메서드를 여러개 정의하는 것. 파라미터로 구분한다. 파라미터가 몇개인지, 타입이 무엇인지로 구분한다.
	Init() {
//		a = 10;
//		b = 20;
//		c = 30;
		this(10, 20, 30);
		// this() : 생성자에서 다른 생성자를 호출할 때 사용한다.
	}
	
}


















