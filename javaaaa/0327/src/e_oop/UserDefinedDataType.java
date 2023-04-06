package e_oop;

public class UserDefinedDataType {

	public static void main(String[] args) {
		/*
		 * 사용자 정의 데이터 타입 (클래스의 다른말)
		 * - 데이터의 최종 진화 형태이다. (변수 -> 배열  -> 구조체 -> 클래스)
		 * - 서로 다른 타입의 데이터를 묶어서 사용하는 것이다.
		 * - 변수와 메서드로 구성할 수 있다.
		 */		
		
//		int kor;
//		int eng;
//		int math;
//		int sum;
//		double avg;
//		String name;
		
		int[] scores;
		
		Student student;
		student = new Student();
		Student student2 = new Student();
		
		student.name = "김석준";
		student.kor = 80;
		
		student2.name = "홍길동";
		student2.kor = 70;
		
		System.out.println(student.name);
		System.out.println(student.kor);
		System.out.println(student2.name);
		System.out.println(student2.kor);
		
		
		
		
	}

}

class Student {
	int kor;
	int eng;
	int math;
	int sum;
	double avg;
	String name;
	
	
}
