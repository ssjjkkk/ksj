package b_operator;

public class ComparisonOperator {

	public static void main(String[] args) {
		
		/*
		 * << 비교 연산자 >>
		 * - < : 작다
		 * - > : 크다
		 * - <= : 작거나 같다
		 * - >= : 크거나 같다
		 * - == : 같다
		 * - != : 같지 않다 
		 */
		
		boolean b = 10 < 20;
		System.out.println(b);
		b = 10 <= 20 - 15;    // 20 - 15 를 먼저 계산함, 산술연산자가 비교연산자보다 먼저 수행된다.
		System.out.println(b);
		
		b = 10.0f == 10.0;
		System.out.println(b);
		b = 10.1f == 10.1;
		System.out.println(b);
		
		// double은 float 으로 형변환 해야 정확하게 비교할 수 있다.
		b = 10.1f == (float)10.1;
		System.out.println(b);
		
		// 문자열 비교
		b = "abc" == "abc";
		System.out.println(b);  // 같은 스트링 리터럴은 같은 주소를 갖는다.
		b = "abc" == new String("abc");
		System.out.println(b);  // new를 써서 새로운 주소를 만들었기 때문에 서로 다르다고 판단.
		// 참조형 타입은 저장된 메모리 주소를 비교하기 때문에 String은 등가 비교 연산자로 내용을 비교할 수 없다.
		// String의 값을 비교하기 위해서는 equals()메서드를 사용한다.
		b = "abc".equals(new String("abc"));
		System.out.println(b);
		
		// 다음의 문장들을 코드로 작성해주세요.
		// 1보다 2가 큰가?
		boolean x = 1 < 2;
		System.out.println(x);
		
		// 0은 100보다 작거나 같은가?
		x = 0 <= 100;
		System.out.println(x);
		
		// 3.14f와 3.14는 다른가?
		x = 3.14f != 3.14;
		System.out.println(x);
		
		// "남자"와 "여자"는 다른가?
		x = !"남자".equals("여자");
		System.out.println(x);
		
		
		
		
		
		
		
		
		
		

	}

}
