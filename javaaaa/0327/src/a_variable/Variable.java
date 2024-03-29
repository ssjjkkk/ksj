package a_variable;

import java.util.Scanner;

public class Variable {
	
	int a; // 전역변수

	public static void main(String[] args) {
		
		/*
		 * << 변수 >>
		 * - 하나의 데이터를 저장할 수 있는 메모리상의 공간
		 * - 타입(데이터의 종류)과 변수형(변수의 이름)으로 변수를 만들 수 있다.
		 * 
		 * << 사용 가능한 기본형 데이터>>
		 * - 정수: byte(1byte), short(2byte), int(4byte), long(8byte)
		 * - 실수: float(4byte), double(8byte)
		 * - 문자: char(2byte)
		 * - 논리: boolean(1byte)
		 * 
		 * << 명명 규칙>>
		 * - 블럭 안에서 변수명은 중복될 수 없다.
		 * - 영문 대소문자, 한글, 숫자, 특수문자('_', '$') 를 사용할 수 있다. (* 한글 사용은 자제)
		 * - 대소문자가 구분되며 길이에 제한이 있다.
		 * - 숫자로 시작할 수 없다.
		 * - 예약어는 사용할 수 없다.
		 * - [기본적으로 변수는 소문자를 사용하고, 상수는 대문자를 사용한다.]
		 * - [여러 단어로 이루어진 경우에는 단어의 첫 글자를 대문자로 한다.(상수는 언더바로 구분)]
		 * - [클래스명의 첫글자는 대문자로 한다.]
		 * - [패키지명은 모두 소문자로 한다.]
		 */
		byte _byte;
		short _short;
		int _int;
		long _long;
		float _float;
		double _double;
		char _char;
		boolean _boolean;
		
		_byte = 10;
		_short = 20;
		_int = 30;
		_long = 40L;
		_float = 3.14f;
		_double = 3.14d;    // double은 접미사를 생략할 수 있다.
		_char = '가';        // char char 타입의 문자는 '' 으로 묶여진 것만 가능하다. "" 은 스트링
		_boolean = true;
		
		System.out.println(_byte);
		System.out.println(_short);
		System.out.println(_int);
		System.out.println(_long);
		System.out.println(_float);
		System.out.println(_double);
		System.out.println(_char);
		System.out.println(_boolean);
		
		_int = 100;
		System.out.println(_int);
		_int = 100 + 200;
		System.out.println(_int);
		
		_short = 50;
		System.out.println(_short);
		_short = 50 + 20;
		System.out.println(_short);
		
		_long = 150;
		System.out.println(_long);
		_long = 150 + 250;
		System.out.println(_long);
		
		_char = '나';
		System.out.println(_char);
		
		_float = 4.13f;
		System.out.println(_float);
		
		_double = 5.36;
		System.out.println(_double);
		
		_boolean = false;
		System.out.println(_boolean);
		
		// String : 여러개의 문자를 편리하게 사용하기 위한 콘텐츠
		// 문자열 : ""(쌍따옴표)로 감싸진 문자
//		String _String = new String("abcd");
		String _String = "abcd";
		System.out.println(_String);
		
		_String = "1234";
		System.out.println(_String);
		
		/*
		 * << 리터럴의 종류 >>
		 * 숫자 : 0, 10, -5, 3.14
		 * 문자 : '가', 'a', 'o'
		 * 문자열 : "가나다", "abc", "123", ""
		 * 그외 : true, false, null(값이 없다)
		 * 
		 * << 참조형 타입 >>
		 * - 기본형 타입을 제외한 모든 데이터 타입(배열, 클래스) --> 값이 변수에 직접 저장되는게 아니고 값을 가지고 있는 주소를 저장.
		 * - ex) String, Variable, HelloWorld
		 * - 값이 변수에 저장되지 않고 따로 저장되며, 그 주소가 변수에 저장된다. 
		 */
		
		// 오버플로우
		_byte = 127;
		_int = 128;
		_byte = (byte)_int; // 형변환 : 데이터 타입을 변환하는 것.
		System.out.println(_byte);
		// -128 이라고 출력되는 이유는 바이트 타입이 표현할 수 있는 범위가 -128 ~ 127 까지이기 때문
		// 즉, 범위를 벗어난 것을 표현하려고 하니 데이터 손실이 일어났다. 1만큼 벗어났기 때문에 -128이 표현됨.
		
		// 언더플로우
		_byte = -128;
		_int = -129;
		_byte = (byte)_int;
		System.out.println(_byte);
		// 표현범위가 큰 타입에서 작은 타입으로 형변환 할 경우 데이터가 손실될 수 있다.
		// 바이트의 가장 작은 값은 -128 이지만 -129를 표현하기 위해서 바이트 범위의 가장 큰 범위로 가서 계산되어 표현됨.
		
		_double = 3.14;
		_int = (int)_double;
		System.out.println(_int);
		// 더블타입을 인트타입으로 형변환
		// 더블타입은 실수타입이고 굉장히 큰 표현범위를 가지고 있다. (_int 타입은 21억정도)
		// int타입이 정수 표현을 하기 때문에 출력 결과는 소수점이 사라진다.
		
		_int = _byte;
		_long = _int;
		_double = _int;
		_double = _float;
		// 표현범위가 작은 타입에서 큰 타입으로 형변환 할 경우 데이터가 손실될 염려가 없다.
		// 그러므로 형변환을 생략할 수 있다.
		
		/*
		 * << 상수 >>
		 * - 값을 한 번 저장하면 변경할 수 없는 저장공간
		 * - final int MAX_NUMBER;
		 * - 리터럴에 의미를 부여하기 위해 사용한다.
		*/
		
		final int MAX_NUMBER;
		MAX_NUMBER = 10;
//		MAX_NUMBER = 100;
		
//		콘솔창에서 입력받는 방법
//		Scanner s = new Scanner(System.in);
		
//		System.out.println("문자열을 입력해주세요.");
//		String input1 = s.nextLine();
//		System.out.println("입력받은 문자열:" + input1);
		
//		숫자를 입력 받아보세요.
//		System.out.println("숫자를 입력해주세요.");
//		int input2 = Integer.parseInt(s.nextLine());
//		System.out.println("입력받은 문자열:" + input2);
		
//		문자열을 입력받고 입력받은 문자열을 출력해주세요.
//		Scanner s = new Scanner(System.in);
//		System.out.println("문자열을 입력해주세요.");
//		String input1 = s.nextLine();
//		System.out.println("입력받은 문자열:" + input1);
		
//		숫자를 입력받고 입력받은 숫자를 출력해주세요.
//		System.out.println("숫자를 입력해주세요.");
//		int input2 = Integer.parseInt(s.nextLine());
//		System.out.println("입력받은 숫자:" + input2);
		
		
//		위에서 입력받은 문자열과 숫자를 더해서 출력해주세요.
//		System.out.println("입력받은 문자열+숫자:" + input1 + input2);
		
//		3개의 입력한 숫자를 더해주는 계산기 프로그램을 만들어보세요.
		Scanner ss = new Scanner(System.in);
		System.out.println("숫자를 3번 입력해주세요.");
		int num1 = Integer.parseInt(ss.nextLine());
		int num2 = Integer.parseInt(ss.nextLine());
		int num3 = Integer.parseInt(ss.nextLine());
		System.out.println("더한 값:" + (num1 + num2 + num3));		
		
		
		
	}

}
