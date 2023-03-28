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
		
		int i = 10;
		int j = 20;		
		
		
	}

}
