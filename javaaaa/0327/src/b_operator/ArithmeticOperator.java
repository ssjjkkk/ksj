package b_operator;

public class ArithmeticOperator {

	public static void main(String[] args) {
		/*
		 * << 산술 연산자 >>
		 * - + : 더하기
		 * - - : 빼기
		 * - * : 곱하기
		 * - / : 나누기
		 * - % : 나머지
		 * - 이항 연산자는 양쪽의 피연산자의 타입이 일치해야 연산이 가능하다.  
		*/
		
		int a = 10 + 20 - 10 * 5 / 10 % 2;
		// *, /, % 연산자가 +, - 보다 연산의 우선순위가 높다.
		// 우선순위가 동일할 경우  왼쪽부터 연산이 수행된다.
		System.out.println(a); 
		
		double d = 10 + 20.3;
		System.out.println(d);
		
		int value1 = 3;
		value1++;
		System.out.println(value1);
		
		int value2 = 3;
		value2++;
		System.out.println(value2);
		
		int value3 = 3;
		int value4 = value3++;
		System.out.println(value3);
		System.out.println(value4);
		
		int value5 = 3;
		int value6 = ++value5;
		System.out.println(value5);
		System.out.println(value6);
		
		int value7 = 3;
		int value8 = 4;
		int value9 = 2 + value7-- + ++value8;
		System.out.println(value7);
		System.out.println(value8);
		System.out.println(value9);
		
		// 전위형 덧셈, 뺄셈 연산은 해당줄에서 바로 연산되어 값이 변한다.
		// 후위형 덧셈, 뺄셈 연산은 해당줄의 다음줄 부터 연산되어 값이 변한다.
		
		int i = 0;
		System.out.println("++i =" + ++i); // 1
		i = 0;
		System.out.println("i++ = " + i++); // 0
		System.out.println(i); // 1
		
		double round = 50.6;
		System.out.println((int)(round + 0.5));
		System.out.println(Math.round(round));
		// 만약에 소수점 두번째 자리에서 반올림을 하려면 이 메서드를 사용할 수 없다.
		
		double round2 = 50.56;
		System.out.println((int)(round2 * 10f + 0.5) / 10f); // 반올림을 하기위해 0.5를 더함
		
		// 3개의 int형 변수를 선언 및 초기화 후 합계와 평균을 구해주세요.
		// 평균은 소수점 둘째자리에서 반올림 해주세요.
		
		int t1 = 15;
		int t2 = 38;
		int t3 = 87;
		int t4 = t1 + t2 + t3;
		
		System.out.println(t1 + t2 + t3); // 140
		System.out.println(t4/3f);
		System.out.println(Math.round(t4/3f * 10f) / 10f);
		
		
		
		
		
		
		
		
		
	}

}
