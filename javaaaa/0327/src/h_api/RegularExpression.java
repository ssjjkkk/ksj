package h_api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class RegularExpression {

	public static void main(String[] args) {
		/*
		 * 정규표현식 : 문자열의 패턴을 검사하는 표현식
		 * 
		 * ^	: 뒷 문자로 시작
		 * $	: 앞 문자로 종료
		 * .	: 임의의 문자(줄바꿈 제외)
		 * *	: 앞 문자가 0개 이상
		 * +	: 앞 문자가 1개 이상
		 * ?	: 앞 문자가 없거나 1개
		 * []	: 문자의 집합이나 범위([a-z] : a부터 z까지, [^a-z] : a부터 z가 아닌 것)
		 * {}	: 앞 문자의 개수 ({2} : 2개, {2, 4} : 2개이상 4개 이하)
		 * |	: or 연산
		 * \s	: 공백, 탭, 줄바꿈
		 * \S	: 공백, 탭, 줄바꿈이 아닌 문자
		 * \w	: 알파벳이나 숫자
		 * \W	: 알파벳이나 숫자가 아닌 문자
		 * \d	: 숫자
		 * \D	: 숫자가 아닌 문자
		 * (?!)	: 뒷 문자의 대소문자 구분 안함
		 * \	: 정규표현식에서 사용되는 특수문자 표현 
		 */
		
		String str = "";
//		String regex = "[a-z]{3}[0-9]{1,3}";
//		String regex = "[a-zA-Z0-9]+";
//		String regex = "\\w*";
		String regex = ".*";
		
//		Pattern p = Pattern.compile(regex);
//		Matcher m = p.matcher(str);
//		System.out.println(m.matches());
		
		// 아이디, 전화번호, 이메일주소, 비밀번호의 유효성을 검사하는 정규표현식을 만들어주세요.
		String id = "Abc123";
		String pwd = "lkas1532@";
		String phone = "010-4089-1066";
		String email = "Abc123@naver.com";
		
		String regex1 = "[a-zA-Z0-9]{6,11}";
		Pattern p1 = Pattern.compile(regex1);
		Matcher m1 = p1.matcher(id);
		System.out.println(m1.matches());
		
		String regex2 = "(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[\\d&!@#$%^&]).{8,16}";   // ?= 전방 탐색 기호
		Pattern p2 = Pattern.compile(regex2);
		Matcher m2 = p2.matcher(pwd);
		System.out.println(m2.matches());
		
		String regex3 = "0\\d{1,3}-\\d{3,4}-\\d{4}";
		Pattern p3 = Pattern.compile(regex3);
		Matcher m3 = p3.matcher(phone);
		System.out.println(m3.matches());
		
		String regex4 = "[a-zA-Z0-9\\.]+@[a-zA-Z0-9.]+\\.[com|co\\.kr|net]+";
		Pattern p4 = Pattern.compile(regex4);
		Matcher m4 = p4.matcher(email);
		System.out.println(m4.matches());
		// 주민등록 번호
		// \d{6}-[1-4]{1}\d{6}
		
		String asd = "12345678";
		String reasd = asd.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
		String reasd2 = asd.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
		System.out.println(reasd);
		System.out.println(reasd2);
	}
	
}
