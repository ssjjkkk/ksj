package e_oop;

public class SampleClass {

	public static void main(String[] args) {
		int local = 10; // 지역변수 : 메서드 안에서만 사용 가능한 변수
	}
	
	int field;  // 전역변수 이면서 인스턴스 변수 : 클래스 전체 영역에서 사용하는 변수.
				// 초기화를 해주지 않아도 사용할 수 있다.
				// 초기화를 해주지 않으면 기본값으로 초기화 된다.
	boolean bool = false; // 기본값
	String str = null; 	  // 기본값
	
	/*
	 * - 메서드 : 변수를 가지고 할 일
	 * - 선언 방법 : 리턴타입 메서드명(파라미터) { }
	 * - 파라미터(매개변수) : 실행에 필요한 정보 (변수)
	 * - 리턴타입(반환타입) : 실행 후 돌려주는 결과물
	 */
	
	void method1() {
		System.out.println("파라미터도 리턴타입도 없는 메서드");
	}
	
	String method2(int parameter) { // 리턴타입과 파라미터는 있을수도, 없을 수도 있다.
		return parameter + " 를 받아 명령을 수행하고 결과물을 리턴하는 메서드";
	}
	
	void flowTest1 () {
		System.out.println("flowTest1 시작 : 1");
		flowTest3(); // 같은 클래스의 메서드를 호출 할 때는 이렇게 호출한다.
		System.out.println("flowTest1 종료 : 6");
	}
	
	void flowTest2 () {
		System.out.println("flowTest2 시작 : 3");
		System.out.println("flowTest2 종료 : 4");
	}
	
	void flowTest3 () {
		System.out.println("flowTest3 시작 : 2");
		flowTest2();
		System.out.println("flowTest3 종료 : 5");
	}
	
	

}
