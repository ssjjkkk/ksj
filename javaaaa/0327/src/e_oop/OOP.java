package e_oop;

public class OOP {

	public static void main(String[] args) {
		/*
		 * 객체지향 프로그래밍(Object Oriented Programming)
		 * - 프로그래밍을 단순히 코드의 연속으로 보는 것이 아니라 객체간의 상호작용으로 보는 것.
		 * - 코드의 재사용성이 높고 유지보수가 용이하다.
		 */
		
		SampleClass sc = new SampleClass(); // SampleClass 타입의 변수를 만들어서 주소를 저장.
											// new SampleClass(); 부분이 객체를 생성
											// 이 생성된 객체의 위치를 변수에 저장한 것.
		System.out.println(sc.field);
		System.out.println(sc.bool);
		System.out.println(sc.str);
		sc.method1();
		String returnValue = sc.method2(10);
		System.out.println(returnValue);
		
		sc.flowTest1();
		
		ClassMaker sc2 = new ClassMaker();
		sc2.A();
		int returnVal = sc2.B();
		System.out.println(returnVal);
		sc2.C(2);
		int returnVal2 = sc2.D(3, 5);
		System.out.println(returnVal2);
		
		Calculator cal = new Calculator();
		
		// 다음을 한 줄씩 계산해서 최종 결과값을 출력해주세요.
		// 1. 123456 + 654321
		long calVal1 = cal.A(123456, 654321);
		System.out.println(calVal1);
		// 2. 1번의 결과값 * 123456
		long calVal2 = cal.C(calVal1, 123456);
		System.out.println(calVal2);
		// 3. 2번의 결과값 / 123456
		long calVal3 = cal.D(calVal2, 123456);
		System.out.println(calVal3);
		// 4. 3번의 결과값 - 654321
		long calVal4 = cal.B(calVal3, 654321);
		System.out.println(calVal4);
		// 5. 4번의 결과값 % 123456
		long calVal5 = cal.E(calVal4, 123456);
		System.out.println(calVal5);
		
		
		
	}

}
