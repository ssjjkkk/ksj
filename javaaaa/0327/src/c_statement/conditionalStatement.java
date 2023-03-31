package c_statement;

import java.util.Scanner;

public class conditionalStatement {

	public static void main(String[] args) {

		/*
		 * << if 문 >> - if : 조건식의 결과가 true 이면 블럭 안의 문장을 수행한다. - else if : 다수의 조건이 필요할 때
		 * if 뒤에 추가한다. - else : 결과가 true 인 조건식이 하나도 없는 경우를 위해 추가한다.
		 */

//		int a = 10;
//		if (a < 100) {
//			System.out.println("조건식의 연산결과가 true이면 수행된다.");
//		}
//
//		if (a < 10) {
//			System.out.println("조건식의 연산결과가 false 이면 수행되지 않는다.");
//		}
//		
		
		// 주민등록번호 앞자리에 따른 성별확인 코드 (if문)
//		Scanner s = new Scanner(System.in);
//		System.out.println("단");
//		String regNo = s.nextLine(); // 주민등록번호 첫자리
//		String gender = null; // 성별
//		
//		// 조건문
//		if (regNo.equals("1") || regNo.equals("3")) {
//			gender = "남자";
//		} else if (regNo.equals("2") || regNo.equals("4")) {
//			gender = "여자";
//		} else {
//			gender = "확인불가";
//		}
//		System.out.println("당신의 성별은 " + gender + " 입니다.");
//		
		
//		int num = Integer.parseInt(s.nextLine());
//		for(int j = 1; j < 10; j++) {
//			System.out.println(num + "단" + " : " + num + "x" + j + " = " + num*j);
//		}
		
//		for (int i = 1; i < 10; i++) {
//			for(int j = 1; j < 10; j++) {
//				System.out.println(i + "단" + " : " + i + "x" + j + " = " + i*j);
//			}
//		};
		
		
		// 성적에 등급을 부여하는 프로그램을 작성하세요. (Scanner 를 활용하여 숫자를 입력받아 해당하는 성적을 출력하세요.)
		
//		Scanner s = new Scanner(System.in);
//		System.out.println("성적을 입력하세요.");
//		int score = Integer.parseInt(s.nextLine());
//		String grade = null;
//		switch (score / 10) {
//			case 10 : 
//				grade = "A+";
//				break;
//			case 9 :
//				grade = "A";
//				break;
//			case 8 :
//				grade = "B";
//				break;
//			case 7 :
//				grade = "C";
//				break;
//			case 6 :
//				grade = "D";
//				break;
//			default :
//				grade = "f";
//				break;
//		}
		
//		Scanner s = new Scanner(System.in);
//		System.out.println("성적을 입력하세요.");
//		String input = s.nextLine();
//		boolean result = input.matches("[0-9]+");
//		int score = 0;
//		String grade = null;
//		
//		if(result) {
//			score = Integer.parseInt(input);
//			if(score == 100) {
//				grade = "A+";
//			} else if(score >= 90) {
//				grade = "A";
//			} else if(score >= 80) {
//				grade = "B";
//			} else if(score >= 70) {
//				grade = "C";
//			} else if(score >= 60) {
//				grade = "D";
//			} else {
//				grade = "F";
//			}
//		} else {
//			grade = "숫자로 입력해주세요.";
//		}
//		
//		System.out.println(grade);
		
		// 숫자를 입력받아 그 숫자가 0인지 0이 아닌지 출력해주세요.
		
//		Scanner s = new Scanner(System.in);
//		System.out.println("숫자를 입력하세요.");
//		int num = Integer.parseInt(s.nextLine()); // 값이 String 으로 들어오기 때문에 int 타입으로 형변환 해줘야 한다.
//		switch (num) {
//			case 0:
//			System.out.println("0 입니다.");
//			break;
//			case 1:
//				System.out.println("0이 아닙니다.");
//				break;
//			default:
//				System.out.println("0 이 아닙니다.");
//				break;
//		}
		
		// 숫자를 입력받아 그 숫자가 홀수인지 짝수인지 출력해주세요.
		
//		Scanner s = new Scanner(System.in);
//		System.out.println("숫자를 입력하세요.");
//		int num = Integer.parseInt(s.nextLine());
//		switch (num%2) {
//			case 0:
//				System.out.println("짝수 입니다.");
//				break;
//			default:
//				System.out.println("홀수 입니다.");
//				break;
//		};
		
		// 두개의 숫자를 입력받아 더 큰 숫자를 출력해주세요.
//		Scanner s1 = new Scanner(System.in);
//		System.out.println("첫번째 숫자를 입력하세요.");		
//		int num1 = Integer.parseInt(s1.nextLine());
//		System.out.println("두번째 숫자를 입력하세요.");
//		int num2 = Integer.parseInt(s1.nextLine());
//		
//		if (num1 < num2) {
//			System.out.println("더 큰 숫자 : " + num2);
//		} else if (num1 > num2) {
//			System.out.println("더 큰 숫자 : " + num1);
//		} else {
//			System.out.println("같은 숫자 입니다.");
//		}

		//세개의 숫자를 입력받아 가장 큰 숫자를 출력해주세요.
		Scanner s1 = new Scanner(System.in);
		System.out.println("첫번째 숫자를 입력하세요.");		
		int num1 = Integer.parseInt(s1.nextLine());
		System.out.println("두번째 숫자를 입력하세요.");
		int num2 = Integer.parseInt(s1.nextLine());
		System.out.println("세번째 숫자를 입력하세요.");
		int num3 = Integer.parseInt(s1.nextLine());
		
		if (num1 >= num2 && num1 >= num3) {
			System.out.println("가장 큰 숫자 : " + num1);
		} else if (num2 >= num1 && num2 >= num3) {
			System.out.println("가장 큰 숫자 : " + num2);
		} else {
			System.out.println("가장 큰 숫자 : " + num3);
		};
		

	}

}
