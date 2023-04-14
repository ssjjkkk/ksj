package f_oop2;

public class SampleChild extends SampleParent {
	
	void childMethod() {
		// 상속받은 변수와 메서드를 사용할 수 있다.
		System.out.println(var);       			// 상속받은 변수
		System.out.println(method(7, 13));		// 상속받은 메서드
		System.out.println(k);
		System.out.println(super.k);
	}
	
	// 오버라이딩 : 부모클래스의 메서드 내용을 변경하여 재구성 하는 것
	// super, super() : this 와 비슷한 역할. 부모 클래스의 멤버와 자식클래스의 멤버가 이름이 똑같을 때 둘을 구분해 주기 위해서 사용한다.
	
	@Override
	int method(int a, int b) {
		return a * b;
	}
	
	int var;
	void test() {
		System.out.println(var); 		// 지역 변수
		System.out.println(this.var);	// 인스턴스 변수
		System.out.println(super.var); 	// 부모 클래스의 인스턴스 변수
		System.out.println(this.method(10, 20));
		System.out.println(super.method(10, 20));
	}
	
	SampleChild(int var) {
		super();
		// super() 를 통해 클래스의 생성자를 호출하고 부모클래스의 인스턴스 변수도 초기화한다.
		// super() 가 없으면 컴파일러가 자동으로 super()를 넣어준다.
		this.var = var;
	}

	public static void main(String[] args) {
		SampleChild sc = new SampleChild(5);
		SampleParent sp = new SampleParent();
//		sc.childMethod();
//		System.out.println(sp.method(7, 13));
//		System.out.println(sc.method(7, 13));
//		sc.test();
		
//		sc = (SampleChild) sp;	// 부모타입이 자식타입에 포함되어 있기 때문에 형변환을 해야한다.
//		sp = sc;       			// 자식 타입에서 부모타입으로 형변환 필요 없음.
		SampleChild sc2 = (SampleChild)new SampleParent();
		// SampleParent 는 3개의 멤버를 가지고 있다.
		// SampleChild 는 6개의 멤버를 가지고 있다.
		// SampleChild 타입의 참조변수는 6개의 멤버를 사용할 수 있어야 하는데 SampleParent 객체는 3개의 멤버만 가지고 있다.
		// 그러므로 부모타입의 객체를 자식타입으로 형변환 하는 것은 에러를 발생시킨다.

	}

}
