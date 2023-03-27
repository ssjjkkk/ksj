package a_variable;

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
		_char = '가';        // char 타입의 문자는 '' 으로 묶여진 것만 가능하다. "" 은 스트링
		_boolean = true;
		
		System.out.println(_byte);
		System.out.println(_short);
		System.out.println(_int);
		System.out.println(_long);
		System.out.println(_float);
		System.out.println(_double);
		System.out.println(_char);
		System.out.println(_boolean);
	}

}
