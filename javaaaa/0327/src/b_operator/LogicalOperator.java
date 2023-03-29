package b_operator;

public class LogicalOperator {

	public static void main(String[] args) {
		
		/*
		 * << 논리 연산자 >>
		 * - && (and) : 피연산자 둘 다 true 이면 true를 결과로 얻는다.
		 * - || (or) : 피연산자 중 하나라도 true이면 true를 결과로 얻는다.
		 * - !(not) : 피연산자가 true이면 false를, false이면 true를 결과로 얻는다.
		 * - 피연산자로 boolean만 허용한다.				
		 */
		
		// a가 0보다 크고 10보다 작거나 같다.
		int a = 6;
		boolean b1 = 0 < a;     // a가 0보다 크다
		boolean b2 = a <= 10;	// a가 10보다 작거나 같다.
		boolean b = b1 && b2;
		System.out.println(b);
		
		// a가 2의 배수이거나 3의 배수인가?
		b = a % 2 == 0 || a % 3 == 0;
		System.out.println(b);
		
		// a가 2의 배수이거나 3의 배수이고 10이상인가?
		b = (a % 2 == 0 || a % 3 == 0) && a >= 10 ;
		// &&가 ||보다 먼저 수행되기 때문에 문제의 의도와 다르게 되므로 ()를 해준다.
		System.out.println(b);
		
		b = true && true;  // true
		b = true && false; // false
		b = false && true; // false
		b = false && false;// false
		
		int d = 10;
		b = d < 10 && 0 < d++;
		// 왼쪽이 false 이기 때문에 오른쪽은 수행하지 않는다. 그러므로 d++ 코드가 적용되지 않아 결과가 10이 나온다.
		System.out.println(d);
				
		int x = 1, y = 2;
		b = x + 3 * y > y - 2 || x < 3 && y >= 5; // 7 > 0 || 1 < 3 && 2 >=5
		System.out.println(b);
		
		
		
		
		
		
		
		
		
		
	}

}
